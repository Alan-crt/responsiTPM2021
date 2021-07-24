package com.example.responsi.data;

import com.example.responsi.data.model.Kasus;
import com.example.responsi.data.model.Rujukan;
import com.example.responsi.data.remote.RemoteDataSource;

import java.util.List;

import androidx.lifecycle.LiveData;

public class AppRepository {
    private final RemoteDataSource remoteDataSource;

    public LiveData<List<Kasus>> getKasus() {
        return remoteDataSource.getKasus();
    }

    public LiveData<List<Rujukan>> getRujukan() {
        return remoteDataSource.getRujukan();
    }

    private AppRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    private static volatile AppRepository instance;

    public static AppRepository getInstance(RemoteDataSource remoteDataSource) {
        if (instance == null)
            instance = new AppRepository(
                    remoteDataSource
            );
        return instance;
    }
}
