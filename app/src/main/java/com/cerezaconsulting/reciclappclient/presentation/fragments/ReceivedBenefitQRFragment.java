package com.cerezaconsulting.reciclappclient.presentation.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cerezaconsulting.reciclappclient.R;
import com.cerezaconsulting.reciclappclient.core.BaseFragment;
import com.cerezaconsulting.reciclappclient.data.entities.UserEntity;
import com.cerezaconsulting.reciclappclient.data.repositories.local.SessionManager;
import com.cerezaconsulting.reciclappclient.presentation.utils.BarcodeUtils;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by miguel on 30/05/17.
 */

public class ReceivedBenefitQRFragment extends BaseFragment {

    @BindView(R.id.fl_content_frame)
    ImageView flContentFrame;
    Unbinder unbinder;

    private SessionManager sessionManager;

    public static ReceivedBenefitQRFragment newInstance() {
        return new ReceivedBenefitQRFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_received_benefit, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sessionManager = new SessionManager(getContext());
        UserEntity userEntity = sessionManager.getUserEntity();
        String userJson = new Gson().toJson(userEntity);
        Bitmap bitmap = BarcodeUtils.encodeAsBitmapQR(userJson,250);
        flContentFrame.setImageBitmap(bitmap);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
