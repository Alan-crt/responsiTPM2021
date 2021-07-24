package com.example.responsi.data.remote.response;

import com.google.gson.annotations.SerializedName;

public class KasusResponse {
    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("data")
    private KasusDataResponse kasusDataResponse;

    public int getStatusCode() {
        return statusCode;
    }

    public KasusDataResponse getData() {
        return kasusDataResponse;
    }
}
