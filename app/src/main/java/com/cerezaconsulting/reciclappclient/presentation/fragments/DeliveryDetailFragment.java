package com.cerezaconsulting.reciclappclient.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cerezaconsulting.reciclappclient.R;
import com.cerezaconsulting.reciclappclient.core.BaseFragment;
import com.cerezaconsulting.reciclappclient.data.entities.DeliveryDetailEntity;
import com.cerezaconsulting.reciclappclient.data.entities.DeliveryEntity;
import com.cerezaconsulting.reciclappclient.data.entities.GarbageEntity;
import com.cerezaconsulting.reciclappclient.presentation.adapters.DeliveryDetailAdapter;
import com.cerezaconsulting.reciclappclient.presentation.contracts.DeliveryDetailContract;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by miguel on 30/06/17.
 */

public class DeliveryDetailFragment extends BaseFragment implements DeliveryDetailContract.View{

    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_supervisor)
    TextView tvSupervisor;
    @BindView(R.id.tv_collection_point)
    TextView tvCollectionPoint;
    Unbinder unbinder;
    @BindView(R.id.rv_delivery_list)
    RecyclerView rvDeliveryList;
    @BindView(R.id.tv_total_points)
    TextView tvTotalPoints;

    private DeliveryDetailContract.Presenter presenter;
    private DeliveryEntity deliveryEntity;
    private LinearLayoutManager layoutManager;
    private DeliveryDetailAdapter adapter;

    public static DeliveryDetailFragment newInstance(Bundle bundle) {
        DeliveryDetailFragment fragment = new DeliveryDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        deliveryEntity = (DeliveryEntity) getArguments().getSerializable("delivery");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_delivery_description, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvDeliveryList.setLayoutManager(layoutManager);

        adapter = new DeliveryDetailAdapter(new ArrayList<DeliveryDetailEntity>());
        rvDeliveryList.setAdapter(adapter);
       /* tvDate.setText(deliveryEntity.getDate());
        tvSupervisor.setText(deliveryEntity.getGatheringEntity().getDirection());
        tvCollectionPoint.setText(deliveryEntity.getGatheringEntity().getName());
        tvTotalPoints.setText(deliveryEntity.getTotal_points()+"");*/

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadDeliveryDetail(deliveryEntity);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getDeliveryDetail(DeliveryEntity deliveryEntity) {
        tvDate.setText(deliveryEntity.getDate());
        tvSupervisor.setText(deliveryEntity.getGatheringEntity().getDirection());
        tvCollectionPoint.setText(deliveryEntity.getGatheringEntity().getName());
        tvTotalPoints.setText(deliveryEntity.getTotal_points()+"");
        if(adapter!=null) {
            adapter.setList(deliveryEntity.getDeliveryDetailEntities());
        }
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void setMessageError(String error) {

    }

    @Override
    public void setDialogMessage(String message) {

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setPresenter(DeliveryDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
