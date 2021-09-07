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
        this.user = new Usuario("Flavio Henrique",calendar,"Eu posso não estar onde eu quero estar ainda, mas eu me aproximo cada vez mais todos os dias","Serra","Espiríto Santo");






        calendar = Calendar.getInstance();
        calendar.set(2002,02,22);
        Usuario usuario1 = new Usuario("Felipe Santos",calendar,"dasdedaed","Serra","Espiríto Santo");
        calendar.set(1996,05,23);
        Usuario usuario2 = new Usuario("Pedro Souza",calendar,"dasdedaed","Vitória","Espiríto Santo");
        calendar.set(2003,04,14);
        Usuario usuario3 = new Usuario("Marcelo Araújo",calendar,"dasdedaed","Vila Velha","Espiríto Santo");
        List<Usuario> usuarios = new ArrayList<>();


        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(user);

        user.addAmigo(usuario1);
        user.addAmigo(usuario2);
        user.addAmigo(usuario3);



        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.set(2021,8,7,17,32);

        Calendar prazo1 = calendar1;

        calendar2.set(2021,8,8,17,23);

        Calendar prazo2 = calendar2;



        Event evento1 = new Event(R.drawable.parque,"Parque da Cidade","Ida ao parque da cidade",usuarios, prazo1, prazo2,"Parque da Cidade");
        evento1.setData(calendar1.getTime());
        evento1.setStatus(0);
        this.user.addEvent(evento1);

        Event evento2 = new Event(R.drawable.shopping,"Shopping","Ida ao Shopping",usuarios, prazo1, prazo2, "Shopping Vitória");
        evento2.setStatus(2);
        Topico topico1 = new Topico(calendar1);
        Topico topico2 = new Topico(calendar1);
        topico2.setVotos(5);
        Topico topico3 = new Topico(calendar1);
        topico3.setVotos(3);
        Topico topico4 = new Topico(calendar1);
        topico4.setVotos(1);
        evento2.addOpcoesDataHora(topico1);
        evento2.addOpcoesDataHora(topico2);
        evento2.addOpcoesDataHora(topico3);
        evento2.addOpcoesDataHora(topico4);
        evento2.orgarnizarDatas();

        this.user.addEvent(evento2);
        Event evento3 = new Event(R.drawable.pedradacebola,"Pedra da Cebola","Ida a Pedra da Cebola",usuarios, prazo1, prazo2, "Pedra da cebola - Vitória");
        evento3.setStatus(1);

        evento3.addOpcoesDataHora(topico1);
        evento3.addOpcoesDataHora(topico2);
        evento3.addOpcoesDataHora(topico3);
        evento3.addOpcoesDataHora(topico4);

        Event evento4 = new Event(R.drawable.praia,"Praia","Ida a praia",usuarios, prazo1, prazo2, "Praia de Camburi");
        evento4.setData(calendar1.getTime());
        evento4.setType(1);
        evento4.setStatus(0);

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
