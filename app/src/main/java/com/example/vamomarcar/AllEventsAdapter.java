package com.example.vamomarcar;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AllEventsAdapter extends RecyclerView.Adapter {
    Context context;
    List<Event> eventos;

    public AllEventsAdapter(Context context, List<Event> eventos){
        this.context = context;
        this.eventos = eventos;
    }

    @NonNull
    @Override

    public int getItemViewType(int position){
        return eventos.get(position).getType();
    }


    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view;
         switch (viewType){
             case 0:
                 view = layoutInflater.inflate(R.layout.event_item, parent, false);
                 return new MyViewHolder(view);

             case 1:
                 view = layoutInflater.inflate(R.layout.event_item_invite, parent, false);
                 return new MyViewHolder(view);

         }
         return null;

    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {
        Event evento = eventos.get(position);
        ImageView imageView;
        TextView nome;
        TextView desc;
        TextView participants;
        TextView local;

        switch (holder.getItemViewType()){
            case 0:
                imageView = holder.itemView.findViewById(R.id.imvPhotoEv);
                imageView.setImageResource(evento.getThumb());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context, EventoMarcado.class);
                        context.startActivity(i);

                    }
                });

                nome = holder.itemView.findViewById(R.id.tvTitle);
                nome.setText(evento.getTitle());

                desc = holder.itemView.findViewById(R.id.tvDesc);
                desc.setText(evento.getDesc());

                participants = holder.itemView.findViewById(R.id.tvParticipants);
                participants.setText(String.valueOf(evento.getTotalParticipantes()) + " Participantes");
                TextView data = holder.itemView.findViewById(R.id.tvDate);

                if (evento.getStatus() == "marcado") {
                    data.setText(evento.getDataFormatada() + "    " +evento.getHora() );

                }
                else if (evento.getStatus() == "sugestao"){
                    long prazoSugestao = evento.getPrazoSugestao();
                    CountDownTimer countDownTimer = new CountDownTimer(prazoSugestao,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            long hora = TimeUnit.MILLISECONDS.toHours(millisUntilFinished);
                            long min = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished - TimeUnit.HOURS.toMillis(hora));
                            long sec = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished - TimeUnit.HOURS.toMillis(hora) - TimeUnit.MINUTES.toMillis(min));
                            data.setText("Sugestão: " + hora + ":" + min + ":" + sec);
                        }

                        @Override
                        public void onFinish() {
                            data.setText("");

                        }
                    };
                    countDownTimer.start();
                }
                else {
                    long prazoVotacao = evento.getPrazoVotacao();
                    CountDownTimer countDownTimer = new CountDownTimer(prazoVotacao,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            long hora = TimeUnit.MILLISECONDS.toHours(millisUntilFinished);
                            long min = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished - TimeUnit.HOURS.toMillis(hora));
                            long sec = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished - TimeUnit.HOURS.toMillis(hora) - TimeUnit.MINUTES.toMillis(min));
                            data.setText("Votação: " + hora + ":" + min + ":" + sec);
                        }

                        @Override
                        public void onFinish() {
                            data.setText("");

                        }
                    };
                    countDownTimer.start();
                }





                local = holder.itemView.findViewById(R.id.tvLocation);
                local.setText("Local: " + evento.getLocal());

            case 1:
                imageView = holder.itemView.findViewById(R.id.imvPhotoEv);
                imageView.setImageResource(evento.getThumb());

                nome = holder.itemView.findViewById(R.id.tvTitle);
                nome.setText(evento.getTitle());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(context, EventoMarcado.class);
                        context.startActivity(i);

                    }
                });

                desc = holder.itemView.findViewById(R.id.tvDesc);
                desc.setText(evento.getDesc());

                participants = holder.itemView.findViewById(R.id.tvParticipants);
                participants.setText(String.valueOf(evento.getTotalParticipantes()) + " Participantes");
                local = holder.itemView.findViewById(R.id.tvLocation);
                local.setText("Local: " + evento.getLocal());

    }
    }


    @Override
    public int getItemCount() {
        return eventos.size();
    }
}
