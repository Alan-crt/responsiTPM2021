package com.example.responsi.data.remote.service;

import com.example.responsi.data.remote.response.KasusResponse;
import com.example.responsi.data.remote.response.RujukanResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/api/v1/rekapitulasi_v2/jabar/harian")
    Call<KasusResponse> getKasus();

    @GET("/api/v1/sebaran_v2/jabar/faskes")
    Call<RujukanResponse> getRujukan();
}
