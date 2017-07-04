package com.cerezaconsulting.reciclappclient.presentation.fragments;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.cerezaconsulting.reciclappclient.R;
import com.cerezaconsulting.reciclappclient.core.BaseFragment;
import com.google.zxing.Result;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by miguel on 16/05/17.
 */

public class ReceivedBenefitFragment extends BaseFragment implements ZXingScannerView.ResultHandler, EasyPermissions.PermissionCallbacks{

    private static final int RC_CAMERA_PERM = 123;

    @BindView(R.id.fl_content_frame)
    FrameLayout flContentFrame;
    Unbinder unbinder;
    private boolean isOpenCamera = false;
    private ZXingScannerView mScannerView;

    public static ReceivedBenefitFragment newInstance() {
        return new ReceivedBenefitFragment();
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
        mScannerView = new ZXingScannerView(getContext());
        flContentFrame.addView(mScannerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        methodRequiresPermissionCamera();
    }

    @AfterPermissionGranted(RC_CAMERA_PERM)
    private void methodRequiresPermissionCamera() {
        String[] perms = {Manifest.permission.CAMERA};
        if (EasyPermissions.hasPermissions(this.getContext(), perms)) {
            if (!isOpenCamera) {
                initScanner();
                isOpenCamera = true;
            }
        } else {
            EasyPermissions.requestPermissions(this, getResources().getString(R.string.perm_camera),
                    RC_CAMERA_PERM, perms);
        }

    }

    private void initScanner() {
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        if (requestCode == RC_CAMERA_PERM) {
            if (!isOpenCamera) {
                initScanner();
                isOpenCamera = true;
            }
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void handleResult(Result result) {
        Toast.makeText(getContext(), result.getText(), Toast.LENGTH_SHORT).show();
    }

}
