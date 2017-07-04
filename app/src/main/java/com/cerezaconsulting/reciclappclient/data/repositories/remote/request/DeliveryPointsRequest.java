package com.cerezaconsulting.reciclappclient.data.repositories.remote.request;

import com.cerezaconsulting.reciclappclient.data.entities.DeliveryPointEntity;
import com.cerezaconsulting.reciclappclient.data.entities.trackholders.EntityTrackHolder;
import com.cerezaconsulting.reciclappclient.data.repositories.remote.ApiConstants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by miguel on 20/06/17.
 */

public interface DeliveryPointsRequest {
    @GET(ApiConstants.DELIVERY_POINTS)
    Call<EntityTrackHolder<DeliveryPointEntity>> getDeliveryPoints(@Header("Authorization") String token,@Header("Accept") String json);

}
