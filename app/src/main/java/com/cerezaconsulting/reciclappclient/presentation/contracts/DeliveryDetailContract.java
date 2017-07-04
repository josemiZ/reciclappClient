package com.cerezaconsulting.reciclappclient.presentation.contracts;

import com.cerezaconsulting.reciclappclient.core.BasePresenter;
import com.cerezaconsulting.reciclappclient.core.BaseView;
import com.cerezaconsulting.reciclappclient.data.entities.DeliveryEntity;

/**
 * Created by miguel on 4/07/17.
 */

public interface DeliveryDetailContract {
    interface View extends BaseView<Presenter> {
        void getDeliveryDetail(DeliveryEntity deliveryEntity);
    }
    interface Presenter extends BasePresenter{
        void loadDeliveryDetail(DeliveryEntity deliveryEntity);
    }
}
