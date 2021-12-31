package com.anvil.rakoi.anvil.entities.Pojos;

public class StkPushAsyncResponse {

    public Body Body;

    public StkPushAsyncResponse() {
    }

    public StkPushAsyncResponse(Body body) {
        this.Body = body;
    }

    public Body getBody() {
        return Body;
    }

    public void setBody(Body body) {
        this.Body = body;
    }

    @Override
    public String toString() {
        return "StkPushAsyncResponse{" +
                "Body=" + Body +
                '}';
    }
}

