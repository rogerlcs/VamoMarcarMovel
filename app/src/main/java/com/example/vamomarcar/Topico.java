package com.example.vamomarcar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Topico {
   private Calendar data;
    private int votos;
    private boolean clicou = false;

    public Topico(Calendar data) {
        this.data = data;
        this.votos = 0;
    }

    public boolean jaClicou() {
        return clicou;
    }

    public void setClicou(boolean clicou) {
        this.clicou = clicou;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public String getDataFormatada(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM");
        String data = sdf.format(this.data.getTime());
        return data;
    }

    public String getHora(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String hora = sdf.format(this.data.getTime());
        return hora;
    }
}
