package com.example.responsi.ui;

import com.example.responsi.data.AppRepository;
import com.example.responsi.data.model.Kasus;
import com.example.responsi.data.model.Rujukan;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private final AppRepository appRepository;

    public LiveData<List<Kasus>> getKasus() {
        return appRepository.getKasus();
    }

    public LiveData<List<Rujukan>> getRujukan() {
        return appRepository.getRujukan();
    }

    public MainViewModel(AppRepository appRepository) {
        this.appRepository = appRepository;
    }
}
