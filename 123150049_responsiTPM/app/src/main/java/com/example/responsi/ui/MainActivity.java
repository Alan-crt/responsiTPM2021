package com.example.responsi.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.responsi.R;
import com.example.responsi.ui.Rujukan.RujukanFragment;
import com.example.responsi.ui.kasus.KasusFragment;
import com.example.responsi.viewmodel.ViewModelFactory;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Covid");

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        viewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_kasus:
                    setFragment(new KasusFragment());
                    break;
                case R.id.menu_rujukan:
                    setFragment(new RujukanFragment());
                    break;
            }
            return false;
        });

        setFragment(new KasusFragment());
    }

    private void setFragment(Fragment fragment) {
        if (fragment != null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, fragment)
                    .show(fragment)
                    .commit();
    }
}