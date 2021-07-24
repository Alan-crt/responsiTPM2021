package com.example.responsi.ui.Rujukan;

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

public class RujukanFragment extends Fragment {

    private MainViewModel viewModel;

    private RecyclerView rvRujukan;
    private RujukanAdapter adapter;

    public RujukanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rujukan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewModelFactory factory = ViewModelFactory.getInstance(getContext());
        viewModel = new ViewModelProvider(requireActivity(), factory).get(MainViewModel.class);

        rvRujukan = view.findViewById(R.id.rv_rujukan);

        adapter = new RujukanAdapter();
        rvRujukan.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvRujukan.setAdapter(adapter);

        viewModel.getRujukan().observe(getViewLifecycleOwner(), dataRujukan -> adapter.setData(dataRujukan));
    }
}