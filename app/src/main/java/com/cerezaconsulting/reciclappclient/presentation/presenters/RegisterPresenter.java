package com.cerezaconsulting.reciclappclient.presentation.presenters;

import android.content.Context;

import com.cerezaconsulting.reciclappclient.R;
import com.cerezaconsulting.reciclappclient.data.entities.AccessTokenEntity;
import com.cerezaconsulting.reciclappclient.data.entities.UserEntity;
import com.cerezaconsulting.reciclappclient.data.repositories.local.SessionManager;
import com.cerezaconsulting.reciclappclient.data.repositories.remote.ApiConstants;
import com.cerezaconsulting.reciclappclient.data.repositories.remote.ServiceFactory;
import com.cerezaconsulting.reciclappclient.data.repositories.remote.request.UserRequest;
import com.cerezaconsulting.reciclappclient.presentation.contracts.RegisterContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by miguel on 18/06/17.
 */

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View mView;
    private Context context;

    public RegisterPresenter(RegisterContract.View mView, Context context) {
        this.mView = mView;
        this.context = context;
        this.mView.setPresenter(this);
    }

    @Override
    public void registerUser(UserEntity userEntity) {
        mView.setLoadingIndicator(true);
        UserRequest userRequest = ServiceFactory.createService(UserRequest.class);
        Call<Void> call = userRequest.registerUser(ApiConstants.APP_JSON,userEntity);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                if(response.isSuccessful()){
                    mView.registerSuccessfully();
                }
                else{
                    mView.setMessageError(context.getString(R.string.there_was_an_error_try_it_later));
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                if(!mView.isActive()){
                    return;
                }
                mView.setLoadingIndicator(false);
                mView.setMessageError(context.getString(R.string.no_server_connection_try_it_later));
            }
        });
    }

    @Override
    public void start() {

    }
}
