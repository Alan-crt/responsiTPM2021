package com.example.responsi.data.remote;

import android.util.Log;

import com.example.responsi.data.model.Kasus;
import com.example.responsi.data.model.Rujukan;
import com.example.responsi.data.remote.response.KasusResponse;
import com.example.responsi.data.remote.response.RujukanResponse;
import com.example.responsi.data.remote.service.ApiConfig;

import java.util.Collections;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSource {
    private final ApiConfig apiConfig;

    public LiveData<List<Kasus>> getKasus() {
        MutableLiveData<List<Kasus>> kasusList = new MutableLiveData<>();
        apiConfig.getApiService().getKasus().enqueue(new Callback<KasusResponse>() {
            @Override
            public void onResponse(Call<KasusResponse> call, Response<KasusResponse> response) {
                KasusResponse data = response.body();
                if (data != null) {
                    List<Kasus> dataKasus = data.getData().getKasusList();
                    Collections.reverse(dataKasus);
                    kasusList.postValue(dataKasus);
                }
            }

            @Override
            public void onFailure(Call<KasusResponse> call, Throwable t) {
                Log.e("API getKasus()", t.getMessage());
            }
        });
        return kasusList;
    }

    public LiveData<List<Rujukan>> getRujukan() {
        MutableLiveData<List<Rujukan>> rujukanList = new MutableLiveData<>();
        apiConfig.getApiService().getRujukan().enqueue(new Callback<RujukanResponse>() {
            @Override
            public void onResponse(Call<RujukanResponse> call, Response<RujukanResponse> response) {
                RujukanResponse data = response.body();
                if (data != null)
                    rujukanList.postValue(data.getrujukanList());
            }

            @Override
            public void onFailure(Call<RujukanResponse> call, Throwable t) {

            }
        });
        return rujukanList;
    }

    public RemoteDataSource(ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
    }

    private static volatile RemoteDataSource instance;

    public static RemoteDataSource getInstance(ApiConfig apiConfig) {
        if (instance == null)
            instance = new RemoteDataSource(apiConfig);
        return instance;
    }
}
