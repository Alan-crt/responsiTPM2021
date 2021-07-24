package com.example.responsi.data.model;

import com.google.gson.annotations.SerializedName;

public class Kasus {
    @SerializedName("tanggal")
    private final String tanggal;
    @SerializedName("confirmation_selesai")
    private final int sembuh;
    @SerializedName("confirmation_meninggal")
    private final int meninggal;
    @SerializedName("confirmation_diisolasi")
    private final int konfirmasi;

    public Kasus(String tanggal, int sembuh, int konfirmasi, int meninggal) {
        this.tanggal = tanggal;
        this.sembuh = sembuh;
        this.konfirmasi = konfirmasi;
        this.meninggal = meninggal;
    }

    public String getTanggal() {
        return tanggal;
    }

    public int getSembuh() {
        return sembuh;
    }

    public int getMeninggal() {
        return meninggal;
    }

    public int getKonfirmasi() {
        return konfirmasi;
    }
}
