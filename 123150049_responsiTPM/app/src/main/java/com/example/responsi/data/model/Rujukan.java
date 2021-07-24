package com.example.responsi.data.model;

import com.google.gson.annotations.SerializedName;

public class Rujukan {
    @SerializedName("nama")
    private final String nama;

    @SerializedName("alamat")
    private final String alamat;

    @SerializedName("longitude")
    private final double longitude;

    @SerializedName("latitude")
    private final double latitude;

    public Rujukan(String nama, String alamat, double longitude, double latitude) {
        this.nama = nama;
        this.alamat = alamat;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
