package com.cerezaconsulting.reciclappclient.presentation.contracts;

import com.cerezaconsulting.reciclappclient.core.BasePresenter;
import com.cerezaconsulting.reciclappclient.core.BaseView;
import com.cerezaconsulting.reciclappclient.data.entities.UserEntity;

/**
 * Created by miguel on 18/06/17.
 */

public interface RegisterContract {
    interface View extends BaseView<Presenter>{
        void registerSuccessfully();
    }
    interface Presenter extends BasePresenter{
        void registerUser(UserEntity userEntity);
    }
}
