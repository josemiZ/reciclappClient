package com.cerezaconsulting.reciclappclient.presentation.presenters;

import android.content.Context;

import com.cerezaconsulting.reciclappclient.R;
import com.cerezaconsulting.reciclappclient.data.entities.DeliveryPointEntity;
import com.cerezaconsulting.reciclappclient.data.entities.trackholders.EntityTrackHolder;
import com.cerezaconsulting.reciclappclient.data.repositories.local.SessionManager;
import com.cerezaconsulting.reciclappclient.data.repositories.remote.ApiConstants;
import com.cerezaconsulting.reciclappclient.data.repositories.remote.ServiceFactory;
import com.cerezaconsulting.reciclappclient.data.repositories.remote.request.DeliveryPointsRequest;
import com.cerezaconsulting.reciclappclient.presentation.contracts.DeliveryPointContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by miguel on 20/06/17.
 */

public class DeliveryPointsPresenter implements DeliveryPointContract.Presenter {

    private DeliveryPointContract.View mView;
    private Context context;
    private SessionManager sessionManager;

    public DeliveryPointsPresenter(DeliveryPointContract.View mView, Context context) {
        this.mView = mView;
        this.context = context;
        sessionManager = new SessionManager(context);
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {
        mView.setLoadingIndicator(true);
        String token = sessionManager.getUserToken();
        DeliveryPointsRequest request = ServiceFactory.createService(DeliveryPointsRequest.class);
        Call<EntityTrackHolder<DeliveryPointEntity>> call = request.getDeliveryPoints("Bearer "+token, ApiConstants.APP_JSON);
        call.enqueue(new Callback<EntityTrackHolder<DeliveryPointEntity>>() {
            @Override
            public void onResponse(Call<EntityTrackHolder<DeliveryPointEntity>> call, Response<EntityTrackHolder<DeliveryPointEntity>> response) {
                if(!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                if(response.isSuccessful()){
                    mView.getDeliveryPoints(response.body().getData());
                }
                else{
                    mView.setMessageError(context.getString(R.string.there_was_an_error_try_it_later));
                }
            }

            @Override
            public void onFailure(Call<EntityTrackHolder<DeliveryPointEntity>> call, Throwable t) {
                if(!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.setMessageError(context.getString(R.string.no_server_connection_try_it_later));
            }
        });
    }
}
