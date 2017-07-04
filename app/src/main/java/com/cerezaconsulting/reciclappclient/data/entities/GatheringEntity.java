package com.cerezaconsulting.reciclappclient.data.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by miguel on 21/06/17.
 */

public class GatheringEntity implements Serializable {
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
    @SerializedName("papel_max")
    private int total_paper;
    @SerializedName("papel_actual")
    private int paper_quantity;
    @SerializedName("vidrio_max")
    private int total_glass;
    @SerializedName("vidrio_actual")
    private int glass_quantity;
    @SerializedName("plastico_max")
    private int total_plastic;
    @SerializedName("plastico_actual")
    private int plastic_quantity;

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

    public int getTotal_paper() {
        return total_paper;
    }

    public void setTotal_paper(int total_paper) {
        this.total_paper = total_paper;
    }

    public int getPaper_quantity() {
        return paper_quantity;
    }

    public void setPaper_quantity(int paper_quantity) {
        this.paper_quantity = paper_quantity;
    }

    public int getTotal_glass() {
        return total_glass;
    }

    public void setTotal_glass(int total_glass) {
        this.total_glass = total_glass;
    }

    public int getGlass_quantity() {
        return glass_quantity;
    }

    public void setGlass_quantity(int glass_quantity) {
        this.glass_quantity = glass_quantity;
    }

    public int getTotal_plastic() {
        return total_plastic;
    }

    public void setTotal_plastic(int total_plastic) {
        this.total_plastic = total_plastic;
    }

    public int getPlastic_quantity() {
        return plastic_quantity;
    }

    public void setPlastic_quantity(int plastic_quantity) {
        this.plastic_quantity = plastic_quantity;
    }
}
