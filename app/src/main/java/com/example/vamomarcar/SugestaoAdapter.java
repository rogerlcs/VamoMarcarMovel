package com.example.vamomarcar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SugestaoAdapter extends RecyclerView.Adapter {

    SugestaoActivity sugestaoActivity;
    Event evento;

    public  SugestaoAdapter(Event evento, SugestaoActivity sugestaoActivity){
        this.evento = evento;
        this.sugestaoActivity = sugestaoActivity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.sugestaoActivity);
        View v = layoutInflater.inflate(R.layout.sugestao_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {
        Topico c = evento.getOpcoesDataHora().get(position);
        TextView tvData = holder.itemView.findViewById(R.id.tvData);
        String data = c.getDataFormatada();
        String hora = c.getHora();
        tvData.setText(data + ", "+ hora);

    }

    @Override
    public int getItemCount() {
        return evento.getOpcoesDataHora().size();
    }
}
