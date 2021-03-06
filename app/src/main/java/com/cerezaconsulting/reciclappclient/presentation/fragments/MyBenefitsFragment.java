package com.cerezaconsulting.reciclappclient.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cerezaconsulting.reciclappclient.R;
import com.cerezaconsulting.reciclappclient.core.BaseFragment;
import com.cerezaconsulting.reciclappclient.data.entities.BenefitEntity;
import com.cerezaconsulting.reciclappclient.presentation.contracts.MyBenefitsContract;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by miguel on 30/05/17.
 */

public class MyBenefitsFragment extends BaseFragment implements MyBenefitsContract.View{

    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.tv_no_items)
    TextView tvNoItems;
    Unbinder unbinder;

    public static MyBenefitsFragment newInstance() {
        return new MyBenefitsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void loadBenefits(ArrayList<BenefitEntity> list) {

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
        return false;
    }

    @Override
    public void setPresenter(MyBenefitsContract.Presenter presenter) {

    }
}
