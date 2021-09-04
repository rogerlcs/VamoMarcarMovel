package com.example.vamomarcar;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyEventsAdapter extends RecyclerView.Adapter {

    Context context;
    List<Event> eventos;
    Usuario user;

    public MyEventsAdapter(Context context, Usuario user){
        this.context = context;
        this.eventos = eventos;
        this.user = user;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.event_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {
        Event evento = user.getMyEvents().get(position);
        ImageView imageView = holder.itemView.findViewById(R.id.imvPhotoEv);
        imageView.setImageResource(evento.getThumb());

        TextView nome = holder.itemView.findViewById(R.id.tvTitle);
        nome.setText(evento.getTitle());

        TextView desc = holder.itemView.findViewById(R.id.tvDesc);
        desc.setText(evento.getDesc());

        TextView participants = holder.itemView.findViewById(R.id.tvParticipants);
        participants.setText(String.valueOf(evento.getTotalParticipantes()) + " Participantes");
        TextView data = holder.itemView.findViewById(R.id.tvDate);

        if (evento.getStatus() == "marcado") {
            data.setText(evento.getDataFormatada() + "    " +evento.getHora() );

        }
        else if (evento.getStatus() == "sugestao"){
            Calendar prazoSugestao = evento.getPrazoSugestao();
            Calendar atual = Calendar.getInstance();
            long prazoS = prazoSugestao.getTimeInMillis() - atual.getTimeInMillis();
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
        else {
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
                            data.setText("");

                        }
                    };
                    countDownTimer.start();
                }





                TextView local = holder.itemView.findViewById(R.id.tvLocation);
                local.setText("Local: " + evento.getLocal());
            }







    @Override
    public int getItemCount() {
        return user.getMyEvents().size();
    }
}
