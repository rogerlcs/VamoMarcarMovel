package com.example.vamomarcar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter {
    ResultActivity resultActivity;
    List<Topico> topicos;

    public ResultAdapter(ResultActivity resultActivity, List<Topico> topicos) {
        this.resultActivity = resultActivity;
        this.topicos = topicos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(resultActivity);
        View v = layoutInflater.inflate(R.layout.result_item, parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {
        Topico t = topicos.get(position);
        TextView tvResult = holder.itemView.findViewById(R.id.tvResult);
        tvResult.setText(t.getDataFormatada() + ", " + t.getHora() + " - " + t.getVotos());

    }

    @Override
    public int getItemCount() {
        return topicos.size();
    }
}
