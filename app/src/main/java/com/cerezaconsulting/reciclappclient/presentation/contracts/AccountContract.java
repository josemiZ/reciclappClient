package com.cerezaconsulting.reciclappclient.presentation.contracts;

import com.cerezaconsulting.reciclappclient.core.BasePresenter;
import com.cerezaconsulting.reciclappclient.core.BaseView;
import com.cerezaconsulting.reciclappclient.data.entities.UserEntity;

/**
 * Created by miguel on 29/06/17.
 */

public interface AccountContract {
    interface View extends BaseView<Presenter>{
        void loadUser(UserEntity userEntity);
    }
    interface Presenter extends BasePresenter{
        void closeSession();
    }
}
