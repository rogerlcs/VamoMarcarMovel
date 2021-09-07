package com.example.vamomarcar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Event {
    private int thumb;
    private String title;
    private String desc;
    private int type = 0;
    private List<Usuario> participantes;
    private Date data;
    private List<Topico> opcoesDataHora = new ArrayList<>();
    private Calendar prazoVotacao;
    private Calendar prazoSugestao;
    private String local;
    private int status;




    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Event(int thumb, String title, String desc, List<Usuario> participantes, Calendar prazoVotacao, Calendar prazoSugestao, String local) {
        this.thumb = thumb;
        this.title = title;
        this.desc = desc;
        this.participantes = participantes;
        this.prazoVotacao = prazoVotacao;
        this.prazoSugestao = prazoSugestao;
        this.local = local;
        this.data = null;
    }

    public int getThumb() {
        return thumb;
    }

    public void setThumb(int thumb) {
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Usuario> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Usuario> participantes) {
        this.participantes = participantes;
    }

    public Date getData() {
        return data;
    }

    public String getDataFormatada(){
        return new SimpleDateFormat(("dd/MM/yyyy")).format(this.data);
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String dataFormatada = sdf.format(data);
        return dataFormatada;
    }

    public List<Topico> getOpcoesDataHora() {
        return opcoesDataHora;
    }

    public void addOpcoesDataHora(Topico topico) {
        this.opcoesDataHora.add(topico);
    }

    public Calendar getPrazoVotacao() {
        return prazoVotacao;
    }

    public void setPrazoVotacao(Calendar prazoVotacao) {
        this.prazoVotacao = prazoVotacao;
    }

    public Calendar getPrazoSugestao() {
        return prazoSugestao;
    }

    public void setPrazoSugestao(Calendar prazoSugestao) {
        this.prazoSugestao = prazoSugestao;
    }

    public int getTotalParticipantes(){
        return participantes.size();
    }

    public void orgarnizarDatas(){
        Collections.sort(opcoesDataHora);
    }

    public List<Topico> getResult(){
         orgarnizarDatas();
         if(opcoesDataHora.size() > 2){
             List<Topico> vencedores = new ArrayList<>();
             vencedores.add(opcoesDataHora.get(0));
             vencedores.add(opcoesDataHora.get(1));
             vencedores.add(opcoesDataHora.get(2));
             return vencedores;
         }
         return opcoesDataHora;
    }
}


