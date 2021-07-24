package com.example.responsi.data.remote.response;

import java.util.List;

import com.example.responsi.data.model.Kasus;
import com.google.gson.annotations.SerializedName;

public class KasusDataResponse {

    @SerializedName("content")
    private List<Kasus> kasusList;

    public List<Kasus> getKasusList() {
        return kasusList;
    }
}