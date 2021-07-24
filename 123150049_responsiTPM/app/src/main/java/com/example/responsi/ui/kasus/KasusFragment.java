package com.example.responsi.ui.kasus;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.responsi.R;
import com.example.responsi.ui.MainViewModel;
import com.example.responsi.viewmodel.ViewModelFactory;

import org.jetbrains.annotations.NotNull;

public class KasusFragment extends Fragment {

    private MainViewModel viewModel;

    private RecyclerView rvKasus;
    private KasusAdapter adapter;

    public KasusFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kasus, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewModelFactory factory = ViewModelFactory.getInstance(getContext());
        viewModel = new ViewModelProvider(requireActivity(), factory).get(MainViewModel.class);

        rvKasus = view.findViewById(R.id.rv_kasus);

        adapter = new KasusAdapter();
        rvKasus.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvKasus.setAdapter(adapter);

        viewModel.getKasus().observe(getViewLifecycleOwner(), dataKasus -> adapter.setData(dataKasus));
    }
}