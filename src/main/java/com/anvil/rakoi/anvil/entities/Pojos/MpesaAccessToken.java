package com.anvil.rakoi.anvil.entities.Pojos;

public class MpesaAccessToken {

    public String access_token;
    public String expires_in;

    public MpesaAccessToken(String accessToken, String expires_in) {
        this.access_token = accessToken;
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return "MpesaResponse{" +
                "accessToken='" + access_token + '\'' +
                ", expiresIn='" + expires_in + '\'' +
                '}';
    }

    public String   getBearer(){
        return "Bearer "+access_token;
    }
}
