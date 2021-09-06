package com.example.vamomarcar;

import java.util.Calendar;
import java.util.List;

public class Topico {
    Calendar data;
    int votos;

    public Topico(Calendar data, int votos) {
        this.data = data;
        this.votos = votos;
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
}
