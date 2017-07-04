package com.cerezaconsulting.reciclappclient.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cerezaconsulting.reciclappclient.R;
import com.cerezaconsulting.reciclappclient.core.BaseActivity;
import com.cerezaconsulting.reciclappclient.core.BaseFragment;
import com.cerezaconsulting.reciclappclient.data.entities.DeliveryEntity;
import com.cerezaconsulting.reciclappclient.presentation.activities.DeliveryDetailActivity;
import com.cerezaconsulting.reciclappclient.presentation.activities.ReceivedBenefitQrActivity;
import com.cerezaconsulting.reciclappclient.presentation.adapters.MyDeliveriesAdapter;
import com.cerezaconsulting.reciclappclient.presentation.contracts.MyDeliveriesContract;
import com.cerezaconsulting.reciclappclient.presentation.presenters.communicators.CommunicatorEntity;
import com.cerezaconsulting.reciclappclient.presentation.utils.ProgressDialogCustom;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by miguel on 30/05/17.
 */

public class MyDeliveriesFragment extends BaseFragment implements MyDeliveriesContract.View{

    @BindView(R.id.rv_deliveries)
    RecyclerView rvDeliveries;
    @BindView(R.id.tv_no_deliveries)
    TextView tvNoDeliveries;
    Unbinder unbinder;
    @BindView(R.id.btn_make_delivery)
    Button btnMakeDelivery;

    private LinearLayoutManager layoutManager;
    private MyDeliveriesAdapter adapter;
    private MyDeliveriesContract.Presenter presenter;
    private ProgressDialogCustom mProgressDialogCustom;

    public static MyDeliveriesFragment newInstance() {
        return new MyDeliveriesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_my_delivery, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressDialogCustom = new ProgressDialogCustom(getContext(),"Cargando...");
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvDeliveries.setLayoutManager(layoutManager);

        adapter = new MyDeliveriesAdapter(new ArrayList<DeliveryEntity>(),(CommunicatorEntity<DeliveryEntity>)presenter);
        rvDeliveries.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_make_delivery)
    public void onViewClicked() {
        next(getActivity(),null, ReceivedBenefitQrActivity.class,false);
    }

    @Override
    public void getMyDeliveries(ArrayList<DeliveryEntity> list) {
        if(adapter!=null){
            adapter.setList(list);
            tvNoDeliveries.setVisibility(list.size()!=0?View.GONE:View.VISIBLE);
        }
    }

    @Override
    public void deliveryDetail(DeliveryEntity deliveryEntity) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("delivery",deliveryEntity);
        next(getActivity(),bundle,DeliveryDetailActivity.class,false);
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if(mProgressDialogCustom!=null){
            if(active){
                mProgressDialogCustom.show();
            }
            else{
                mProgressDialogCustom.dismiss();
            }
        }
    }

    @Override
    public void setMessageError(String error) {
        ((BaseActivity)getActivity()).showMessageError(error);
    }

    @Override
    public void setDialogMessage(String message) {
        ((BaseActivity)getActivity()).showMessage(message);
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setPresenter(MyDeliveriesContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
