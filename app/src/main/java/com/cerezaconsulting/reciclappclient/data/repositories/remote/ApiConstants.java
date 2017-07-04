package com.cerezaconsulting.reciclappclient.data.repositories.remote;

/**
 * Created by miguel on 18/06/17.
 */

public class ApiConstants {

    public static final String REGISTER = "registro";
    public static final String LOGIN = "oauth/token";
    public static final String USER_DESCRIPTION = "usuario";
    public static final String BENEFITS = "beneficios";
    public static final String USER_BENEFITS = "usuarios/{id}/beneficios";
    public static final String USER_BENEFIT_DESCRIPTION = "usuarios/{id}/beneficios/{bf_id}";
    public static final String USER_DELIVERIES = "usuarios/{id}/entregas";
    public static final String USER_DELIVERY_DESCRIPTION = "usuarios/{id}/entregas/{dv_id}";
    public static final String DELIVERY_POINTS = "puntos-de-acopio/";
    public static final String DELIVERY_POINT_DESCRIPTION = "puntos-de-acopio/{dp_id}";

    //API KEYS CONSTANTS
    public static final String GRANT_TYPE = "password";
    public static final String CLIENT_ID = "2";
    public static final String APP_JSON = "application/json";
    public static final String CLIENT_SECRET = "KSHlBYOBsJClp3WQ1RBUlTORH9ujzEAz2uiVk8tr";

}
