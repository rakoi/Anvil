package com.anvil.rakoi.anvil.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;


public class MpesaConfiguration {
    @Autowired
    private Environment env;

    public String consumerKey;
    public String consumerSecret;
    public String grantType;
    public String oauthEndPoint;

    public MpesaConfiguration(String consumerKey, String consumerSecret, String grantType, String oauthEndPoint) {
        this.consumerKey = env.getProperty("MPESA_CONSUMER_KEY");;
        this.consumerSecret = env.getProperty("MPESA_CONSUMER_SECRET");;
        this.grantType = env.getProperty("GRANT_TYPE");;
        this.oauthEndPoint = env.getProperty("END_POINT");;
    }

    public Environment getEnv() {
        return env;
    }

    public void setEnv(Environment env) {
        this.env = env;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getOauthEndPoint() {
        return oauthEndPoint;
    }

    public void setOauthEndPoint(String oauthEndPoint) {
        this.oauthEndPoint = oauthEndPoint;
    }
}
