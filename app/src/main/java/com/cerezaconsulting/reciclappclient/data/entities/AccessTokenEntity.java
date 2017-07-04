package com.cerezaconsulting.reciclappclient.data.entities;

import java.io.Serializable;

/**
 * Created by miguel on 18/06/17.
 */

public class AccessTokenEntity implements Serializable {
    private String access_token;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
