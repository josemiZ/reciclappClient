package com.cerezaconsulting.reciclappclient.data.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by miguel on 13/06/17.
 */

public class BenefitEntity implements Serializable {
    @SerializedName("beneficio_id")
    private String id;
    @SerializedName("nombre")
    private String name;
    @SerializedName("descripcion")
    private String description;
    @SerializedName("req_puntos")
    private int req_points;
    @SerializedName("tipo")
    private int type;
    @SerializedName("cantidad")
    private int quantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReq_points() {
        return req_points;
    }

    public void setReq_points(int req_points) {
        this.req_points = req_points;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
