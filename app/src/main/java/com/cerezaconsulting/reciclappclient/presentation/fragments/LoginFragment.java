package com.cerezaconsulting.reciclappclient.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cerezaconsulting.reciclappclient.R;
import com.cerezaconsulting.reciclappclient.core.BaseActivity;
import com.cerezaconsulting.reciclappclient.core.BaseFragment;
import com.cerezaconsulting.reciclappclient.data.entities.UserEntity;
import com.cerezaconsulting.reciclappclient.data.repositories.local.SessionManager;
import com.cerezaconsulting.reciclappclient.presentation.activities.LoadActivity;
import com.cerezaconsulting.reciclappclient.presentation.activities.MainActivity;
import com.cerezaconsulting.reciclappclient.presentation.activities.RegisterActivity;
import com.cerezaconsulting.reciclappclient.presentation.contracts.LoginContract;
import com.cerezaconsulting.reciclappclient.presentation.utils.ProgressDialogCustom;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by miguel on 16/05/17.
 */

public class LoginFragment extends BaseFragment implements LoginContract.View,Validator.ValidationListener{

    @Email(message = "Email no válido")
    @BindView(R.id.et_user)
    EditText etUser;
    @NotEmpty(message = "Este campo no puede ser vacío")
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_forgot_password)
    TextView tvForgotPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_register)
    Button btnRegister;
    Unbinder unbinder;

    private LoginContract.Presenter presenter;
    private ProgressDialogCustom mProgressDialogCustom;
    private Validator validator;


    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mProgressDialogCustom = new ProgressDialogCustom(getContext(),"Iniciando Sesión...");
        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_forgot_password, R.id.btn_login, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_forgot_password:
                break;
            case R.id.btn_login:
                validator.validate();
                break;
            case R.id.btn_register:
                next(getActivity(),null, RegisterActivity.class,false);
                break;
        }
    }

    @Override
    public void loginSuccessfully() {
        next(getActivity(),null, LoadActivity.class,true);
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
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onValidationSucceeded() {
        presenter.login(etUser.getText().toString(),etPassword.getText().toString());
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(getContext());
            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else if (view instanceof TextView) {
                ((TextView) view).setError(message);
            } else {
                setMessageError(message);
            }
        }
    }
}
