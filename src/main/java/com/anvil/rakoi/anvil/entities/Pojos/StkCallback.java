package com.anvil.rakoi.anvil.entities.Pojos;

public class StkCallback {



    public String MerchantRequestID;
    public String CheckoutRequestID;
    public String ResultDesc;
    public String ResultCode;
    public CallbackMetaData CallbackMetadata;

    public StkCallback() {
    }

    public StkCallback(String merchantRequestID, String checkoutRequestID, String resultDesc, String resultCode, CallbackMetaData callbackMetaData) {
        MerchantRequestID = merchantRequestID;
        CheckoutRequestID = checkoutRequestID;
        ResultDesc = resultDesc;
        ResultCode = resultCode;
        this.CallbackMetadata = callbackMetaData;
    }

    public String getMerchantRequestID() {
        return MerchantRequestID;
    }

    public void setMerchantRequestID(String merchantRequestID) {
        MerchantRequestID = merchantRequestID;
    }

    public String getCheckoutRequestID() {
        return CheckoutRequestID;
    }

    public void setCheckoutRequestID(String checkoutRequestID) {
        CheckoutRequestID = checkoutRequestID;
    }

    public String getResultDesc() {
        return ResultDesc;
    }

    public void setResultDesc(String resultDesc) {
        ResultDesc = resultDesc;
    }

    public String getResultCode() {
        return ResultCode;
    }

    public void setResultCode(String resultCode) {
        ResultCode = resultCode;
    }

    public CallbackMetaData getCallbackMetaData() {
        return CallbackMetadata;
    }

    public void setCallbackMetaData(CallbackMetaData callbackMetaData) {
        this.CallbackMetadata = callbackMetaData;
    }

    @Override
    public String toString() {
        return "StkCallback{" +
                "MerchantRequestID='" + MerchantRequestID + '\'' +
                ", CheckoutRequestID='" + CheckoutRequestID + '\'' +
                ", ResultDesc='" + ResultDesc + '\'' +
                ", ResultCode='" + ResultCode + '\'' +
                ", CallbackMetadata=" + CallbackMetadata +
                '}';
    }
}
