package com.cerezaconsulting.reciclappclient.data.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by miguel on 4/07/17.
 */

public class DeliveryDetailEntity implements Serializable {
    @SerializedName("detalle_entrega_id")
    private String id;
    @SerializedName("cantidad")
    private String quantity;
    @SerializedName("puntos")
    private String points;
    @SerializedName("desecho")
    private GarbageEntity garbageEntity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public GarbageEntity getGarbageEntity() {
        return garbageEntity;
    }

    public void setGarbageEntity(GarbageEntity garbageEntity) {
        this.garbageEntity = garbageEntity;
    }

}
