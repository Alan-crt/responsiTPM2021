package com.example.responsi.viewmodel;

import android.content.Context;

import com.example.responsi.data.AppRepository;
import com.example.responsi.di.Injection;
import com.example.responsi.ui.MainViewModel;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final AppRepository appRepository;

    @SuppressWarnings("unchecked")
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class))
            return (T) new MainViewModel(appRepository);

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }

    private ViewModelFactory(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    private static volatile ViewModelFactory instance;

    public static ViewModelFactory getInstance(Context context) {
        if (instance == null)
            instance = new ViewModelFactory(Injection.provideRepository(context));
        return instance;
    }
}
