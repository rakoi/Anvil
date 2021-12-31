package com.anvil.rakoi.anvil.entities.Pojos;

public class Body {

    public StkCallback stkCallback;



    public Body() {
    }

    public Body(StkCallback stkCallback) {

        this.stkCallback = stkCallback;
    }

    public StkCallback getStkCallback() {
        return stkCallback;
    }

    public void setStkCallback(StkCallback stkCallback) {
        this.stkCallback = stkCallback;
    }

    @Override
    public String toString() {
        return "Body{" +
                "stkCallback=" + stkCallback +
                '}';
    }
}
