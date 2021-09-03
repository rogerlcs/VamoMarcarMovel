package com.example.vamomarcar;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivityViewModel extends ViewModel {

    static String LOG_TAG_INFO = "Ciclo de vida MainActivity";

    List<Event> eventos = new ArrayList<>();
    Usuario user;



    public MainActivityViewModel(){

        Calendar calendar = Calendar.getInstance();
        calendar.set(2001,1,22);
        Date data = calendar.getTime();
        this.user = new Usuario("Flavio",data,"dasdedaed","Serra","Espiríto Santo");






        calendar = Calendar.getInstance();
        calendar.set(2002,02,22);
        data = calendar.getTime();
        Usuario usuario1 = new Usuario("Felipe",data,"dasdedaed","Serra","Espiríto Santo");
        calendar.set(1996,05,23);
        data = calendar.getTime();
        Usuario usuario2 = new Usuario("Pedro",data,"dasdedaed","Vitória","Espiríto Santo");
        calendar.set(2003,04,14);
        data = calendar.getTime();
        Usuario usuario3 = new Usuario("Marcelo",data,"dasdedaed","Vila Velhar","Espiríto Santo");
        List<Usuario> usuarios = new ArrayList<>();


        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(user);


        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2021,8,04,14,00);
        Calendar atual = Calendar.getInstance();
        long prazo1 = calendar1.getTimeInMillis() - atual.getTimeInMillis();
        calendar1.set(2021,8,04,14,30);
        long prazo2 = calendar1.getTimeInMillis() - atual.getTimeInMillis();
        Log.i(LOG_TAG_INFO, String.valueOf(calendar1.getTimeInMillis()));
        Log.i(LOG_TAG_INFO, String.valueOf(atual.getTimeInMillis()));
        Log.i(LOG_TAG_INFO, String.valueOf(prazo1));
        Log.i(LOG_TAG_INFO, String.valueOf(prazo2));


        Event evento1 = new Event(R.drawable.parque,"Parque da Cidade","Ida ao parque da cidade",usuarios, prazo1, prazo2,"Parque da Cidade");
        evento1.setData(calendar1.getTime());
        evento1.setStatus("marcado");
        this.user.addEvent(evento1);
        Event evento2 = new Event(R.drawable.shopping,"Shopping","Ida ao Shopping",usuarios, prazo1, prazo2, "Shopping Vitória");
        evento2.setStatus("votacao");
        this.user.addEvent(evento2);
        Event evento3 = new Event(R.drawable.pedradacebola,"Pedra da Cebola","Ida a Pedra da Cebola",usuarios, prazo1, prazo2, "Pedra da cebola - Vitória");
        Event evento4 = new Event(R.drawable.parque,"Praia","Ida a praia",usuarios, prazo1, prazo2, "Praia de Camburia");
        evento4.setData(calendar1.getTime());
        evento4.setType(1);

        eventos.add(evento1);
        eventos.add(evento2);
        eventos.add(evento3);
        eventos.add(evento4);
    }

    public List<Event> getEventos() {

        return eventos;
    }

    public Usuario getUser() {
        return user;
    }

}
