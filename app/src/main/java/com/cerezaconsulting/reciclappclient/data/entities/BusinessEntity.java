package com.cerezaconsulting.reciclappclient.data.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by miguel on 29/06/17.
 */

public class BusinessEntity implements Serializable {
    @SerializedName("sponsor_id")
    private String id;
    @SerializedName("razon_social")
    private String business_name;
    @SerializedName("ruc")
    private String business_document;
    @SerializedName("direccion")
    private String direction;
    @SerializedName("telefono")
    private String phone;
    @SerializedName("contacto")
    private String contact;
    @SerializedName("distrito")
    private String district;
    private ArrayList<BenefitEntity> benefits;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getBusiness_document() {
        return business_document;
    }

    public void setBusiness_document(String business_document) {
        this.business_document = business_document;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public ArrayList<BenefitEntity> getBenefits() {
        return benefits;
    }

    public void setBenefits(ArrayList<BenefitEntity> benefits) {
        this.benefits = benefits;
    }
}
