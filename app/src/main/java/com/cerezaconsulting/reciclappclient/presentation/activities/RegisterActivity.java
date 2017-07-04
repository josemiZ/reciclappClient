package com.cerezaconsulting.reciclappclient.presentation.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.cerezaconsulting.reciclappclient.R;
import com.cerezaconsulting.reciclappclient.core.BaseActivity;
import com.cerezaconsulting.reciclappclient.presentation.fragments.RegisterFragment;
import com.cerezaconsulting.reciclappclient.presentation.presenters.RegisterPresenter;
import com.cerezaconsulting.reciclappclient.presentation.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by miguel on 16/05/17.
 */

public class RegisterActivity extends BaseActivity {
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
        ab.setTitle("");
        ab.setDisplayHomeAsUpEnabled(true);

        RegisterFragment fragment = (RegisterFragment) getSupportFragmentManager().findFragmentById(R.id.body);
        if(fragment==null){
            fragment = RegisterFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),fragment,R.id.body);
        }
        new RegisterPresenter(fragment,getApplicationContext());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
