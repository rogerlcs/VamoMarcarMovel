package com.example.vamomarcar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {
    private String nome;
    private Date dtNasc;
    private String bio;
    private String cidade;
    private String estado;
    private List<Event> myEvents;



    public Usuario(String nome, Date dtNasc, String bio, String cidade, String estado) {
        this.nome = nome;
        this.dtNasc = dtNasc;
        this.bio = bio;
        this.cidade = cidade;
        this.estado = estado;
        this.myEvents = new ArrayList<>();
    }

    public void addEvent(Event e){
        this.myEvents.add(e);
    }

    public List<Event> getMyEvents() {
        return myEvents;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
