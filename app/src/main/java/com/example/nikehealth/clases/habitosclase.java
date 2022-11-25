package com.example.nikehealth.clases;

import java.io.Serializable;

public class habitosclase implements Serializable {

    int DiaSemana,HoraDormir,TiempoSueño;
    int Ocio=0,Salud=0,Trabajo=0;
    int TiempoOcio,TiempoSiesta;

    public habitosclase() {
    }

    public habitosclase(int diaSemana, int horaDormir, int tiempoSueño, int ocio, int salud, int trabajo, int tiempoOcio, int tiempoSiesta) {
        DiaSemana = diaSemana;
        HoraDormir = horaDormir;
        TiempoSueño = tiempoSueño;
        Ocio = ocio;
        Salud = salud;
        Trabajo = trabajo;
        TiempoOcio = tiempoOcio;
        TiempoSiesta = tiempoSiesta;
    }

    public int getDiaSemana() {
        return DiaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        DiaSemana = diaSemana;
    }

    public int getHoraDormir() {
        return HoraDormir;
    }

    public void setHoraDormir(int horaDormir) {
        HoraDormir = horaDormir;
    }

    public int getTiempoSueño() {
        return TiempoSueño;
    }

    public void setTiempoSueño(int tiempoSueño) {
        TiempoSueño = tiempoSueño;
    }

    public int getOcio() {
        return Ocio;
    }

    public void setOcio(int ocio) {
        Ocio = ocio;
    }

    public int getSalud() {
        return Salud;
    }

    public void setSalud(int salud) {
        Salud = salud;
    }

    public int getTrabajo() {
        return Trabajo;
    }

    public void setTrabajo(int trabajo) {
        Trabajo = trabajo;
    }

    public int getTiempoOcio() {
        return TiempoOcio;
    }

    public void setTiempoOcio(int tiempoOcio) {
        TiempoOcio = tiempoOcio;
    }

    public int getTiempoSiesta() {
        return TiempoSiesta;
    }

    public void setTiempoSiesta(int tiempoSiesta) {
        TiempoSiesta = tiempoSiesta;
    }
}
