package com.example.responsi.di;

import android.content.Context;

import com.example.responsi.data.AppRepository;
import com.example.responsi.data.remote.RemoteDataSource;
import com.example.responsi.data.remote.service.ApiConfig;

public class Injection {
    public static AppRepository provideRepository(Context context) {
        ApiConfig apiConfig = new ApiConfig();
        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(apiConfig);

        return AppRepository.getInstance(remoteDataSource);
    }
}
