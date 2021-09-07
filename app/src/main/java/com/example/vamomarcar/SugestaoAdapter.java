package com.example.vamomarcar;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
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

    @Override
    public int getItemViewType(int position) {
        return evento.getStatus();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.sugestaoActivity);
        View v;
        switch (viewType){
            case 1:
                v = layoutInflater.inflate(R.layout.sugestao_item, parent, false);
                return new MyViewHolder(v);
            case 2:
                v = layoutInflater.inflate(R.layout.votacao_item, parent, false);
                return new MyViewHolder(v);
        }
        return null;

    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {
        Topico c = this.evento.getOpcoesDataHora().get(position);
        MainActivityViewModel vm = new ViewModelProvider(sugestaoActivity).get(MainActivityViewModel.class);
        Event event = vm.getEventos().get(vm.getEventos().indexOf(this.evento));
        TextView tvData;
        String data = c.getDataFormatada();
        String hora = c.getHora();
        switch (holder.getItemViewType()) {
            case 1:
                tvData = holder.itemView.findViewById(R.id.tvData);
                tvData.setText(data + ", " + hora);
                break;
            case 2:
                int votos = c.getVotos();
                tvData = holder.itemView.findViewById(R.id.tvDataVotacao);
                tvData.setText(data + ", " + hora + " - " + votos);
                ImageButton imageButton = holder.itemView.findViewById(R.id.imbVoto);
                imageButton.setVisibility(c.getVisible());
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int votos = c.getVotos();
                        if(c.jaClicou()){
                            votos --;
                            imageButton.setColorFilter(Color.argb(255, 133, 132, 132));
                            c.setClicou(false);
                        }
                        else {
                        votos++;
                        imageButton.setColorFilter(Color.argb(255, 0, 0, 0));
                        c.setClicou(true);
                        }
                        tvData.setText(data + ", " + hora + " - " + votos);
                        event.getOpcoesDataHora().get(position).setVotos(votos);
                    }
                });
                break;

        }
    }

    @Override
    public int getItemCount() {
        return evento.getOpcoesDataHora().size();
    }
}
