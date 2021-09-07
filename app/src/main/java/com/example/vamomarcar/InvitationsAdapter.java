package com.example.vamomarcar;

import android.content.Context;
import android.content.Intent;
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
    List<Integer> eventosindex;

    public InvitationsAdapter(Context context, List<Event> eventos, List<Integer> eventosindex ){
        this.context = context;
        this.eventos = eventos;
        this.eventosindex = eventosindex;
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
        Event evento = eventos.get(position);
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


        if(evento.getStatus() == 0) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent b = new Intent(context, EventoMarcado.class);
                    b.putExtra("index",eventosindex.get(position));
                    context.startActivity(b);

                }
            });
        }

        else if (evento.getStatus() == 1 || evento.getStatus() == 2){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent b = new Intent(context, SugestaoActivity.class);
                    b.putExtra("index",eventosindex.get(position));
                    context.startActivity(b);

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }
}
