package com.example.vamomarcar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CriarEventoAdapter  extends RecyclerView.Adapter {
    Usuario user;
    CriarEventoActivity criarEventoActivity;

    public CriarEventoAdapter(CriarEventoActivity criarEventoActivity, Usuario user){
        this.criarEventoActivity = criarEventoActivity;
        this.user = user;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.criarEventoActivity);
        View view = layoutInflater.inflate(R.layout.amigos_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {
        Usuario usuario = this.user.getAmigos().get(position);
        TextView tvNomeAmg = holder.itemView.findViewById(R.id.tvNomeAmg);
        tvNomeAmg.setText(usuario.getNome());
    }

    @Override
    public int getItemCount() {
        return user.getAmigos().size();
    }
}
