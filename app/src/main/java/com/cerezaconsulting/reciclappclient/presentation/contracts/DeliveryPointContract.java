package com.cerezaconsulting.reciclappclient.presentation.contracts;

import com.cerezaconsulting.reciclappclient.core.BasePresenter;
import com.cerezaconsulting.reciclappclient.core.BaseView;
import com.cerezaconsulting.reciclappclient.data.entities.DeliveryPointEntity;

import java.util.ArrayList;

/**
 * Created by miguel on 20/06/17.
 */

public interface DeliveryPointContract {
    interface View extends BaseView<Presenter>{
        void getDeliveryPoints(ArrayList<DeliveryPointEntity> list);
    }
    interface Presenter extends BasePresenter{

    }
}
