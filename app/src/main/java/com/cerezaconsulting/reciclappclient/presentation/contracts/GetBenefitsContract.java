package com.cerezaconsulting.reciclappclient.presentation.contracts;

import com.cerezaconsulting.reciclappclient.core.BasePresenter;
import com.cerezaconsulting.reciclappclient.core.BaseView;
import com.cerezaconsulting.reciclappclient.data.entities.BusinessEntity;

import java.util.ArrayList;

/**
 * Created by miguel on 29/06/17.
 */

public interface GetBenefitsContract {
    interface View extends BaseView<Presenter>{
        void loadBenefits(ArrayList<BusinessEntity> list);
    }
    interface Presenter extends BasePresenter{

    }
}
