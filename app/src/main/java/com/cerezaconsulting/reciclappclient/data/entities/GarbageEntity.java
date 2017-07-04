package com.cerezaconsulting.reciclappclient.data.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by miguel on 4/07/17.
 */

public class GarbageEntity implements Serializable{
    @SerializedName("desecho_id")
    private String id;
    @SerializedName("descripcion")
    private String description;
    @SerializedName("unidad")
    private String unit;
    @SerializedName("equivalencia")
    private String quantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
