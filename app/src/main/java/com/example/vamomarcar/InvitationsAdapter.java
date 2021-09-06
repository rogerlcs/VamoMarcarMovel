package com.example.vamomarcar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InvitationsAdapter extends RecyclerView.Adapter {

    Context context;
    List<Event> eventos;

    public InvitationsAdapter(Context context, List<Event> eventos){
        this.context = context;
        this.eventos = eventos;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.invite_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {
        Event evento = eventos.get(0);
        ImageView imageView = holder.itemView.findViewById(R.id.imvPhotoEvI);
        imageView.setImageResource(evento.getThumb());

        TextView nome = holder.itemView.findViewById(R.id.tvTitleI);
        nome.setText(evento.getTitle());

        TextView desc = holder.itemView.findViewById(R.id.tvDescI);
        desc.setText(evento.getDesc());

        TextView participants = holder.itemView.findViewById(R.id.tvParticipantsI);
        participants.setText(String.valueOf(evento.getTotalParticipantes()) + " Participantes");
        TextView data = holder.itemView.findViewById(R.id.tvDateI);


        TextView local = holder.itemView.findViewById(R.id.tvLocationI);
        local.setText("Local: " + evento.getLocal());
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }
}
