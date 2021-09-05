package com.example.vamomarcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CriarEventoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_evento);

        Toolbar toolbar = findViewById(R.id.tbCriarEvento);
        setSupportActionBar(toolbar);


        MainActivityViewModel vm = new ViewModelProvider(this).get(MainActivityViewModel.class);
        Usuario usuario = vm.getUser();

        CriarEventoAdapter criarEventoAdapter = new CriarEventoAdapter(this, usuario);

        RecyclerView rvCriarEvento = findViewById(R.id.rvCriarEvento);
        rvCriarEvento.setAdapter(criarEventoAdapter);
        rvCriarEvento.setLayoutManager(new LinearLayoutManager(this));



    }
}