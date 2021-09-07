package com.example.vamomarcar;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AllEventsAdapter extends RecyclerView.Adapter {
    Context context;
    List<Event> eventos;

     static String LOG_TAG_INFO = "Mili Seconds";

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
                 view = layoutInflater.inflate(R.layout.invite_item, parent, false);
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

        switch (getItemViewType(position)){
            case 0:
                imageView = holder.itemView.findViewById(R.id.imvPhotoEv);
                imageView.setImageResource(evento.getThumb());


                nome = holder.itemView.findViewById(R.id.tvTitle);
                nome.setText(evento.getTitle());

                desc = holder.itemView.findViewById(R.id.tvDesc);
                desc.setText(evento.getDesc());

                participants = holder.itemView.findViewById(R.id.tvParticipants);
                participants.setText(String.valueOf(evento.getTotalParticipantes()) + " Participantes");
                TextView data = holder.itemView.findViewById(R.id.tvDate);

                if (evento.getStatus() == 0) {
                    data.setText(evento.getDataFormatada() + "    " +evento.getHora() );
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent b = new Intent(context, EventoMarcado.class);
                            b.putExtra("index",position);
                            context.startActivity(b);

                        }
                    });

                }
                else if (evento.getStatus() == 1){

                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent b = new Intent(context, SugestaoActivity.class);
                            b.putExtra("index",position);
                            context.startActivity(b);

                        }
                    });

                    Calendar prazoSugestao = evento.getPrazoSugestao();
                    Calendar atual = Calendar.getInstance();
                    long prazoS = prazoSugestao.getTimeInMillis() - atual.getTimeInMillis();
                    Log.i(LOG_TAG_INFO, String.valueOf(prazoS));
                    Log.i(LOG_TAG_INFO, String.valueOf(prazoSugestao.getTimeInMillis()));
                    CountDownTimer countDownTimer = new CountDownTimer(prazoS,1000) {
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
                else if(evento.getStatus() == 2) {

                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(context, SugestaoActivity.class);
                            i.putExtra("index",position);
                            context.startActivity(i);

                        }
                    });

                    Calendar prazoVotacao = evento.getPrazoVotacao();
                    Calendar atual = Calendar.getInstance();
                    long prazoV = prazoVotacao.getTimeInMillis() - atual.getTimeInMillis();
                    CountDownTimer countDownTimer = new CountDownTimer(prazoV,1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            long hora = TimeUnit.MILLISECONDS.toHours(millisUntilFinished);
                            long min = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished - TimeUnit.HOURS.toMillis(hora));
                            long sec = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished - TimeUnit.HOURS.toMillis(hora) - TimeUnit.MINUTES.toMillis(min));
                            data.setText("Votação: " + hora + ":" + min + ":" + sec);
                        }

                        @Override
                        public void onFinish() {
                            data.setText("Disponível para marcar!");

                        }
                    };
                    countDownTimer.start();
                }





                local = holder.itemView.findViewById(R.id.tvLocation);
                local.setText("Local: " + evento.getLocal());
                break;

            case 1:

                if(evento.getStatus() == 0) {
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent b = new Intent(context, EventoMarcado.class);
                            b.putExtra("index",position);
                            context.startActivity(b);

                        }
                    });
                }

                else if (evento.getStatus() == 1 || evento.getStatus() == 2){
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent b = new Intent(context, SugestaoActivity.class);
                            b.putExtra("index",position);
                            context.startActivity(b);

                        }
                    });
                }

                imageView = holder.itemView.findViewById(R.id.imvPhotoEvI);
                imageView.setImageResource(evento.getThumb());

                nome = holder.itemView.findViewById(R.id.tvTitleI);
                nome.setText(evento.getTitle());


                desc = holder.itemView.findViewById(R.id.tvDescI);
                desc.setText(evento.getDesc());

                participants = holder.itemView.findViewById(R.id.tvParticipantsI);
                participants.setText(String.valueOf(evento.getTotalParticipantes()) + " Participantes");
                local = holder.itemView.findViewById(R.id.tvLocationI);
                local.setText("Local: " + evento.getLocal());
                break;

    }
    }


    @Override
    public int getItemCount() {
        return eventos.size();
    }
}
