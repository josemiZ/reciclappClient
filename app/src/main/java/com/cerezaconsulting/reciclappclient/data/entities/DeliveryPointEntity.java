package com.cerezaconsulting.reciclappclient.data.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by miguel on 20/06/17.
 */

public class DeliveryPointEntity implements Serializable {
    @SerializedName("acopio_id")
    private String id;
    @SerializedName("nombre")
    private String name;
    @SerializedName("direccion")
    private String direction;
    @SerializedName("distrito")
    private String district;
    @SerializedName("latitud")
    private double latitude;
    @SerializedName("longitud")
    private double longitude;

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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
