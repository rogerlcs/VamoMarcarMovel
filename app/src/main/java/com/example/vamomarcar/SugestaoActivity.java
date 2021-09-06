package com.example.vamomarcar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class SugestaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugestao);

        Toolbar toolbar = findViewById(R.id.tbEventoSugestao);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        MainActivityViewModel vm = new ViewModelProvider(SugestaoActivity.this).get(MainActivityViewModel.class);
        Event evento = vm.getEventos().get(2);

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

        Calendar prazoSugestao = evento.getPrazoSugestao();
        Calendar atual = Calendar.getInstance();

        TextView tvCronometro = findViewById(R.id.tvCronometro);

        long prazoS = prazoSugestao.getTimeInMillis() - atual.getTimeInMillis();
        CountDownTimer countDownTimer = new CountDownTimer(prazoS,1000) {
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


        TextView tvLocalEvS = findViewById(R.id.tvLocalEvS);
        tvLocalEvS.setText("Local: " + evento.getLocal());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tbevento, menu);
        return true;
    }
}