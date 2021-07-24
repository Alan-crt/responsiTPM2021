package com.example.responsi.ui.kasus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.responsi.R;
import com.example.responsi.data.model.Kasus;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class KasusAdapter extends RecyclerView.Adapter<KasusAdapter.ViewHolder> {
    private final List<Kasus> kasusList = new ArrayList<>();

    public void setData(List<Kasus> kasusList) {
        this.kasusList.clear();
        this.kasusList.addAll(kasusList);
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kasus, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        holder.bind(kasusList.get(position));
    }

    @Override
    public int getItemCount() {
        return kasusList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvTanggal;
        private final TextView tvKonfirmasi;
        private final TextView tvSembuh;
        private final TextView tvMeninggal;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvKonfirmasi = itemView.findViewById(R.id.tv_konfirmasi);
            tvSembuh = itemView.findViewById(R.id.tv_sembuh);
            tvMeninggal = itemView.findViewById(R.id.tv_meninggal);
        }

        void bind(Kasus kasus) {
            tvTanggal.setText(kasus.getTanggal());
            tvMeninggal.setText(kasus.getMeninggal() + " Kasus");
            tvSembuh.setText(kasus.getSembuh() + "");
            tvKonfirmasi.setText(kasus.getKonfirmasi() + " Kasus");
        }
    }
}
