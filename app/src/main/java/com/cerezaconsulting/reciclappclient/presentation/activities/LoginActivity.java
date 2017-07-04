package com.cerezaconsulting.reciclappclient.presentation.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cerezaconsulting.reciclappclient.R;
import com.cerezaconsulting.reciclappclient.core.BaseActivity;
import com.cerezaconsulting.reciclappclient.presentation.fragments.LoginFragment;
import com.cerezaconsulting.reciclappclient.presentation.presenters.LoginPresenter;
import com.cerezaconsulting.reciclappclient.presentation.utils.ActivityUtils;

/**
 * Created by miguel on 16/05/17.
 */

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean);
        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.body);
        if(loginFragment==null){
            loginFragment = LoginFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),loginFragment,R.id.body);
        }
        new LoginPresenter(loginFragment,getApplicationContext());
    }

}
