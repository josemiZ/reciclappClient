package com.cerezaconsulting.reciclappclient.data.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by miguel on 16/05/17.
 */

public class UserEntity implements Serializable{
    @SerializedName("usuario_id")
    private String user_id;
    @SerializedName("nombre")
    private String first_name;
    @SerializedName("apellido")
    private String last_name;
    private String email;
    @SerializedName("tipo")
    private String type;
    private String dni;
    @SerializedName("estado")
    private int state;
    @SerializedName("puntos")
    private int points;
    @SerializedName("imagen")
    private String image;
    @SerializedName("direccion")
    private String direction;
    @SerializedName("distrito")
    private String district;
    @SerializedName("nacimiento")
    private String birth_date;

    private ArrayList<BenefitEntity> benefits;

    private String password;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<BenefitEntity> getBenefits() {
        return benefits;
    }

    public void setBenefits(ArrayList<BenefitEntity> benefits) {
        this.benefits = benefits;
    }

    public String getFullName(){
        String fullName = "";
        if(first_name!=null && last_name!=null){
            fullName=first_name+" "+last_name;
        }
        return fullName;
    }
}
