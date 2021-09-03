package com.example.vamomarcar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventoMarcadoAdapter extends RecyclerView.Adapter {
    Context context;
    Event evento;

    public EventoMarcadoAdapter(Context context, Event evento){
        this.context = context;
        this.evento = evento;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.participante_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {
        Usuario e = evento.getParticipantes().get(position);
        TextView tvNome = holder.itemView.findViewById(R.id.tvNomeP);
        tvNome.setText(e.getNome());

    }

    @Override
    public int getItemCount() {
        return evento.getTotalParticipantes();
    }
}
