package com.example.responsi.ui.Rujukan;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.responsi.R;
import com.example.responsi.data.model.Rujukan;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RujukanAdapter extends RecyclerView.Adapter<RujukanAdapter.ViewHolder> {
    private final List<Rujukan> rujukanList = new ArrayList<>();

    public void setData(List<Rujukan> rujukanList) {
        this.rujukanList.clear();
        this.rujukanList.addAll(rujukanList);
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rujukan, parent, false);
        return new RujukanAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.bind(rujukanList.get(position));
    }

    @Override
    public int getItemCount() {
        return rujukanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvNama;
        private final TextView tvAlamat;
        private final Button btnMaps;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            btnMaps = itemView.findViewById(R.id.btn_maps);
        }

        void bind(Rujukan rujukan) {
            tvNama.setText(rujukan.getNama());
            tvAlamat.setText(rujukan.getAlamat());

            btnMaps.setOnClickListener(v -> {
                double longitude = rujukan.getLongitude();
                double latitude = rujukan.getLatitude();

                String location = "geo:" + latitude + "," + longitude + "?q=";

                Uri gmmIntentUri =
                        Uri.parse(location + Uri.encode(rujukan.getNama()));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                itemView.getContext().startActivity(mapIntent);
            });
        }
    }
}
