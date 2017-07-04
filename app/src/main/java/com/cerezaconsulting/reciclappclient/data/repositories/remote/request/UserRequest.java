package com.cerezaconsulting.reciclappclient.data.repositories.remote.request;

import com.cerezaconsulting.reciclappclient.data.entities.AccessTokenEntity;
import com.cerezaconsulting.reciclappclient.data.entities.UserEntity;
import com.cerezaconsulting.reciclappclient.data.repositories.remote.ApiConstants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by miguel on 18/06/17.
 */

public interface UserRequest {
    //@FormUrlEncoded
    @POST(ApiConstants.REGISTER)
    Call<Void> registerUser(@Header("Content-type") String contentType, @Body UserEntity userEntity);

    @FormUrlEncoded
    @POST(ApiConstants.LOGIN)
    Call<AccessTokenEntity> login(@Field("username") String email,@Field("password") String password,
                                  @Field("grant_type") String grant_type, @Field("client_id") String client_id,
                                  @Field("client_secret") String client_secret);

    @GET(ApiConstants.USER_DESCRIPTION)
    Call<UserEntity> getUser(@Header("Authorization") String token);
}
