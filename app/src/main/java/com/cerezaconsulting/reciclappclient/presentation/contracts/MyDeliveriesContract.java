package com.cerezaconsulting.reciclappclient.presentation.contracts;

import com.cerezaconsulting.reciclappclient.core.BasePresenter;
import com.cerezaconsulting.reciclappclient.core.BaseView;
import com.cerezaconsulting.reciclappclient.data.entities.DeliveryEntity;

import java.util.ArrayList;

/**
 * Created by miguel on 20/06/17.
 */

public interface MyDeliveriesContract {
    interface View extends BaseView<Presenter> {
        void getMyDeliveries(ArrayList<DeliveryEntity> list);
        void deliveryDetail(DeliveryEntity deliveryEntity);
    }
    interface Presenter extends BasePresenter{

    }
}
