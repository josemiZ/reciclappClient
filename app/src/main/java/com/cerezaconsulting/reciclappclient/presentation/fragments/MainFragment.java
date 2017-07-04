package com.cerezaconsulting.reciclappclient.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cerezaconsulting.reciclappclient.R;
import com.cerezaconsulting.reciclappclient.core.BaseFragment;
import com.cerezaconsulting.reciclappclient.data.entities.UserEntity;
import com.cerezaconsulting.reciclappclient.data.repositories.local.SessionManager;
import com.cerezaconsulting.reciclappclient.presentation.activities.AccountActivity;
import com.cerezaconsulting.reciclappclient.presentation.activities.BenefitsActivity;
import com.cerezaconsulting.reciclappclient.presentation.activities.DeliveryPointsActivity;
import com.cerezaconsulting.reciclappclient.presentation.activities.MyDeliveriesActivity;
import com.cerezaconsulting.reciclappclient.presentation.activities.ReceivedBenefitQrActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by miguel on 30/05/17.
 */

public class MainFragment extends BaseFragment {

    @BindView(R.id.btn_recycle)
    LinearLayout btnRecycle;
    @BindView(R.id.btn_my_deliveries)
    LinearLayout btnMyDeliveries;
    @BindView(R.id.btn_find_us)
    LinearLayout btnFindUs;
    @BindView(R.id.btn_benefits)
    LinearLayout btnBenefits;
    @BindView(R.id.btn_account)
    LinearLayout btnAccount;
    Unbinder unbinder;
    @BindView(R.id.tv_welcome_user)
    TextView tvWelcomeUser;
    @BindView(R.id.tv_points)
    TextView tvPoints;

    private SessionManager sessionManager;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_my_history, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sessionManager = new SessionManager(getContext());
        UserEntity userEntity = sessionManager.getUserEntity();
        tvWelcomeUser.setText(getString(R.string.hello) + " " + userEntity.getFullName() + getString(R.string.good_day));
        tvPoints.setText(getString(R.string.to_date_you_have)+" "+userEntity.getPoints()+" "+getString(R.string.points));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_recycle, R.id.btn_my_deliveries, R.id.btn_find_us, R.id.btn_benefits, R.id.btn_account})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_recycle:
                next(getActivity(), null, ReceivedBenefitQrActivity.class, false);
                break;
            case R.id.btn_my_deliveries:
                next(getActivity(), null, MyDeliveriesActivity.class, false);
                break;
            case R.id.btn_find_us:
                next(getActivity(), null, DeliveryPointsActivity.class, false);
                break;
            case R.id.btn_benefits:
                next(getActivity(), null, BenefitsActivity.class, false);
                break;
            case R.id.btn_account:
                next(getActivity(), null, AccountActivity.class, false);
                break;
        }
    }
}
