package com.example.vamomarcar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Topico {
    Calendar data;
    int votos;

    public Topico(Calendar data) {
        this.data = data;
        this.votos = 0;
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
