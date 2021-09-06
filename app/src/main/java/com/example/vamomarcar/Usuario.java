package com.example.vamomarcar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Usuario {
    private String nome;
    private Calendar dtNasc;
    private String bio;
    private String cidade;
    private String estado;
    private List<Event> myEvents;
    private List<Usuario> amigos = new ArrayList<>();



    public Usuario(String nome, Calendar dtNasc, String bio, String cidade, String estado) {
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

    public void addAmigo(Usuario u){
        this.amigos.add(u);
    }

    public List<Usuario> getAmigos(){
        return this.amigos;
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

    public Calendar getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Calendar dtNasc) {
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

    public String getMonthName(){
       String monthName = this.dtNasc.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
       return monthName;
    }

    public String getYear(){
        String year = String.valueOf(this.dtNasc.get(Calendar.YEAR));
        return year;
    }

    public String getDay(){
        int day = this.dtNasc.get(Calendar.DAY_OF_MONTH);
        String dayofmonth = String.valueOf(day);
        return dayofmonth;
    }

}
