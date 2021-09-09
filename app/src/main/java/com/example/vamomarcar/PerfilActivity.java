package com.example.vamomarcar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

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

        ImageButton imbEditPerfil = findViewById(R.id.imbEditPerfil);
        imbEditPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PerfilActivity.this, EditPerfilActivity.class);
                startActivity(i);
            }
        });

        //Logout
        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Config.setLogin(PerfilActivity.this, "");
                Config.setPassword(PerfilActivity.this, "");
                Intent i = new Intent(PerfilActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

    }
}