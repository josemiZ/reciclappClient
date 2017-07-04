package com.cerezaconsulting.reciclappclient.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cerezaconsulting.reciclappclient.R;
import com.cerezaconsulting.reciclappclient.core.BaseActivity;
import com.cerezaconsulting.reciclappclient.core.BaseFragment;
import com.cerezaconsulting.reciclappclient.data.entities.DeliveryPointEntity;
import com.cerezaconsulting.reciclappclient.presentation.contracts.DeliveryPointContract;
import com.cerezaconsulting.reciclappclient.presentation.utils.ProgressDialogCustom;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by miguel on 13/06/17.
 */

public class DeliveryPointsFragment extends BaseFragment implements OnMapReadyCallback,DeliveryPointContract.View {

    @BindView(R.id.mv_delivery_point)
    MapView mvDeliveryPoint;
    Unbinder unbinder;

    private DeliveryPointContract.Presenter presenter;
    private GoogleMap googleMap;
    private ProgressDialogCustom mProgressDialogCustom;

    public static DeliveryPointsFragment newInstance() {
        return new DeliveryPointsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_delivery_points, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressDialogCustom = new ProgressDialogCustom(getContext(),"Cargando...");
        mvDeliveryPoint.onCreate(savedInstanceState);
        mvDeliveryPoint.getMapAsync(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mvDeliveryPoint.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
        mvDeliveryPoint.onResume();
    }

    @Override
    public void onPause() {
        mvDeliveryPoint.onPause();
        super.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mvDeliveryPoint.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap  = googleMap;
        presenter.start();
    }

    @Override
    public void getDeliveryPoints(ArrayList<DeliveryPointEntity> list) {
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(-12.0560204,-77.0866113))
                .zoom(12)
                .build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        for (DeliveryPointEntity entity: list){
            LatLng latLng = new LatLng(entity.getLatitude(),entity.getLongitude());
            googleMap.addMarker(new MarkerOptions().position(latLng).title(entity.getName()));
        }

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
    public void setPresenter(DeliveryPointContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
