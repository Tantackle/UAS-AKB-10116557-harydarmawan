package com.example.uas;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

//Tanggal :13 Agustus 2019
//Nim     :10116557
//Nama    :Hari Darmawan
//Kelas   :IF-13

public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.MyViewHolder> {
    private List<TemanModel> temanModels;
    Context context;

    public TemanAdapter(Context context, List<TemanModel> temanModels){
        this.context = context;
        this.temanModels = temanModels;
    }

    @Override
    public TemanAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_teman, parent, false);
        return new MyViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(TemanAdapter.MyViewHolder holder, int position) {
        final TemanModel model = temanModels.get(position);
        holder.nim.setText(model.getNim().toString());
        holder.nama.setText(model.getNama());
        holder.kelas.setText(model.getKelas());
        holder.tlp.setText(model.getTlp());
        holder.email.setText(model.getEmail());
        holder.sosmed.setText(model.getSosmed());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("id", model.getId().toString());
                intent.putExtra("nim", model.getNim().toString());
                intent.putExtra("nama", model.getNama());
                intent.putExtra("kelas", model.getKelas());
                intent.putExtra("tlp", model.getTlp());
                intent.putExtra("email", model.getEmail());
                intent.putExtra("sosmed", model.getSosmed());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return temanModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nim, nama, kelas, tlp ,email, sosmed;

        public MyViewHolder(View itemView){
            super(itemView);
            nim = itemView.findViewById(R.id.tvNim);
            nama = itemView.findViewById(R.id.tvNama);
            kelas = itemView.findViewById(R.id.tvKelas);
            tlp = itemView.findViewById(R.id.tvTlp);
            email = itemView.findViewById(R.id.tvEmail);
            sosmed = itemView.findViewById(R.id.tvSosmed);
        }
    }
}
