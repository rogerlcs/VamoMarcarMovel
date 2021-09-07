package com.example.vamomarcar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class SugestaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugestao);

        Intent i = getIntent();
        int position = i.getIntExtra("index",1);
        FloatingActionButton floatingActionButton = findViewById(R.id.fabMarcar);
        floatingActionButton.setClickable(false);
        floatingActionButton.setVisibility(View.INVISIBLE);

        Toolbar toolbar = findViewById(R.id.tbEventoSugestao);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        MainActivityViewModel vm = new ViewModelProvider(SugestaoActivity.this).get(MainActivityViewModel.class);
        Event evento = vm.getEventos().get(position);


        SugestaoAdapter sugestaoAdapter = new SugestaoAdapter(evento, SugestaoActivity.this);
        RecyclerView rvDataSugestoes = findViewById(R.id.rvDatasSugestoes);
        rvDataSugestoes.setAdapter(sugestaoAdapter);
        rvDataSugestoes.setLayoutManager(new LinearLayoutManager(this));

        EventoMarcadoAdapter eventoMarcadoAdapter = new EventoMarcadoAdapter(this, evento);

        RecyclerView rvParticipantes = findViewById(R.id.rvParticpSugestao);
        rvParticipantes.setAdapter(eventoMarcadoAdapter);
        rvParticipantes.setLayoutManager(new LinearLayoutManager(this));

        ImageView imageView = findViewById(R.id.imEventoSugestao);
        imageView.setImageResource(evento.getThumb());

        TextView tvNomeSugestao = findViewById(R.id.tvNomeSugestao);
        tvNomeSugestao.setText(evento.getTitle());

        TextView tvDescEvS = findViewById(R.id.tvDescEvS);
        tvDescEvS.setText(evento.getDesc());

        ImageButton imageButton = findViewById(R.id.imButton);


        Calendar atual = Calendar.getInstance();

        TextView tvCronometro = findViewById(R.id.tvCronometro);
        CountDownTimer countDownTimer;

        switch (evento.getStatus()) {
            case 1:
                Calendar prazoSugestao = evento.getPrazoSugestao();
                long prazoS = prazoSugestao.getTimeInMillis() - atual.getTimeInMillis();
                 countDownTimer = new CountDownTimer(prazoS, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        long hora = TimeUnit.MILLISECONDS.toHours(millisUntilFinished);
                        long min = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished - TimeUnit.HOURS.toMillis(hora));
                        long sec = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished - TimeUnit.HOURS.toMillis(hora) - TimeUnit.MINUTES.toMillis(min));
                        tvCronometro.setText("Sugestão: " + hora + ":" + min + ":" + sec);
                    }

                    @Override
                    public void onFinish() {
                        tvCronometro.setText("");

                    }
                };
                countDownTimer.start();
                break;
            case 2:
                imageButton.setClickable(false);
                imageButton.setColorFilter(Color.argb(0,0,0,0));
                Calendar prazoVotacao = evento.getPrazoVotacao();
                long prazoV = prazoVotacao.getTimeInMillis() - atual.getTimeInMillis();
                countDownTimer = new CountDownTimer(prazoV,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        long hora = TimeUnit.MILLISECONDS.toHours(millisUntilFinished);
                        long min = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished - TimeUnit.HOURS.toMillis(hora));
                        long sec = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished - TimeUnit.HOURS.toMillis(hora) - TimeUnit.MINUTES.toMillis(min));
                        tvCronometro.setText("Votação: " + hora + ":" + min + ":" + sec);
                    }

                    @Override
                    public void onFinish() {
                        tvCronometro.setText("");
                        for(int i1 =0; i1<evento.getOpcoesDataHora().size();i1++){
                            Topico topico = evento.getOpcoesDataHora().get(i1);
                            topico.setVisible(View.INVISIBLE);
                        }
                        floatingActionButton.setClickable(true);
                        floatingActionButton.setVisibility(View.VISIBLE);

                    }
                };
                countDownTimer.start();
        }


            TextView tvLocalEvS = findViewById(R.id.tvLocalEvS);
            tvLocalEvS.setText("Local: " + evento.getLocal());


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(SugestaoActivity.this).setMessage("Deseja Marcar o Evento?").
                        setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(SugestaoActivity.this, ResultActivity.class);
                                i.putExtra("index",position);
                                startActivity(i);
                            }
                        }).setNegativeButton("Não",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tbevento, menu);
        return true;
    }
}