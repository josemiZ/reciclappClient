package com.cerezaconsulting.reciclappclient.presentation.contracts;

import com.cerezaconsulting.reciclappclient.core.BasePresenter;
import com.cerezaconsulting.reciclappclient.core.BaseView;

/**
 * Created by miguel on 18/06/17.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter>{
        void loginSuccessfully();
    }
    interface Presenter extends BasePresenter{
        void login(String email,String password);
    }
}
