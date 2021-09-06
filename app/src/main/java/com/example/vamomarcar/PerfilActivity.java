package com.example.vamomarcar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Toolbar toolbar = findViewById(R.id.tbPerfil);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        MainActivityViewModel vm = new ViewModelProvider(PerfilActivity.this).get(MainActivityViewModel.class);
        Usuario u = vm.getUser();

        TextView tvNomePerfil = findViewById(R.id.tvNomePerfil);
        tvNomePerfil.setText(u.getNome());

        TextView tvBioPerfil = findViewById(R.id.tvBioPerfil);
        tvBioPerfil.setText(u.getBio());

        TextView tvDtNasc = findViewById(R.id.tvDtNasc);
        tvDtNasc.setText(u.getDay() + " de " + u.getMonthName() + " de " + u.getYear());

        TextView tvTotalAmigos = findViewById(R.id.tvTotalAmigos);
        tvTotalAmigos.setText(u.getAmigos().size() + " amigos");

        TextView tvLocalPerfil = findViewById(R.id.tvLocalPerfil);
        tvLocalPerfil.setText(u.getCidade() + " - " + u.getEstado());

    }
}