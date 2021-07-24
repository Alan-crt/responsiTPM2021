package com.example.responsi.data.remote.service;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
    private Retrofit retrofit;

    public ApiService getApiService() {
        if (retrofit == null) {
//            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//            interceptor.level(HttpLoggingInterceptor.Level.BODY);
//
//            OkHttpClient client = new OkHttpClient
//                    .Builder()
//                    .addInterceptor(interceptor)
//                    .build();

            OkHttpClient client = new OkHttpClient
                    .Builder()
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://covid19-public.digitalservice.id/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiService.class);
    }
}
