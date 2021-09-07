package com.example.vamomarcar;

import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Topico implements Comparable<Topico> {
   private Calendar data;
    private int votos = 0;
    private boolean clicou = false;
    private int visible = View.VISIBLE;

    public Topico(Calendar data) {
        this.data = data;
    }

    public boolean isClicou() {
        return clicou;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
        String data = sdf.format(this.data.getTime());
        return data;
    }

    public String getHora(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String hora = sdf.format(this.data.getTime());
        return hora;
    }

    @Override
    public int compareTo(Topico o) {
        if (this.votos > o.getVotos()) {
            return -1;
        } if (this.votos < o.getVotos()) {
            return 1;
        }
        return 0;
    }
}
