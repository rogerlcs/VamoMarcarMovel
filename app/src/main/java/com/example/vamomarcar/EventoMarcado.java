package com.example.vamomarcar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

public class EventoMarcado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_marcado);

        Toolbar tbEventoMarcado = findViewById(R.id.tbEventoMarcado);
        setSupportActionBar(tbEventoMarcado);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        MainActivityViewModel mainActivityViewModel = new ViewModelProvider(EventoMarcado.this).get(MainActivityViewModel.class);
        Event evento = mainActivityViewModel.getEventos().get(0);

        EventoMarcadoAdapter eventoMarcadoAdapter = new EventoMarcadoAdapter(this, evento);

        RecyclerView rvParticipantes = findViewById(R.id.rvParticp);
        rvParticipantes.setAdapter(eventoMarcadoAdapter);
        rvParticipantes.setLayoutManager(new LinearLayoutManager(this));

        ImageView imageView = findViewById(R.id.imEvento);
        imageView.setImageResource(evento.getThumb());

        TextView tvNome = findViewById(R.id.tvNome);
        tvNome.setText(evento.getTitle());

        TextView tvDescEv = findViewById(R.id.tvDescEv);
        tvDescEv.setText(evento.getDesc());

        TextView tvHoraData = findViewById(R.id.tvHoraData);
        tvHoraData.setText("Hora e Data: "+ evento.getDataFormatada() + "  " + evento.getHora());

        TextView tvLocalEv = findViewById(R.id.tvLocalEv);
        tvLocalEv.setText("Local: " + evento.getLocal());






    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        //Mostrando o icone de share na toolbar;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tbevento, menu);
        return true;
    }




}