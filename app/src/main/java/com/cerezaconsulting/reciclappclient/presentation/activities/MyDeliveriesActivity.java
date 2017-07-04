package com.cerezaconsulting.reciclappclient.presentation.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.cerezaconsulting.reciclappclient.R;
import com.cerezaconsulting.reciclappclient.core.BaseActivity;
import com.cerezaconsulting.reciclappclient.presentation.fragments.MyDeliveriesFragment;
import com.cerezaconsulting.reciclappclient.presentation.presenters.MyDeliveriesPresenter;
import com.cerezaconsulting.reciclappclient.presentation.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by miguel on 30/05/17.
 */

public class MyDeliveriesActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setTitle(R.string.my_deliveries);
        ab.setDisplayHomeAsUpEnabled(true);

        MyDeliveriesFragment fragment = (MyDeliveriesFragment) getSupportFragmentManager().findFragmentById(R.id.body);
        if(fragment==null){
            fragment = MyDeliveriesFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),fragment,R.id.body);
        }
        new MyDeliveriesPresenter(fragment,getApplicationContext());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
