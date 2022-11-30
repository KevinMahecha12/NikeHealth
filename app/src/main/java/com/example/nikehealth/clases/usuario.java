package com.example.nikehealth.clases;

import java.io.Serializable;

public class Usuario implements Serializable {    int id;
    String nombre;
    int edad,genero;
    Double peso,estatura;
    int Comidas,DesayunoCalorias,ComidaCalorias,CenaCalorias,OpcionLitrosAgua;
    int DiaSemana,HoraDormir,TiempoSueño;
    int Ocio=0,Salud=0,Trabajo=0;
    int TiempoOcio,TiempoSiesta;

    public Usuario() {
    }

    public Usuario(int id, String nombre, int edad, int genero, Double peso, Double estatura, int comidas, int desayunoCalorias, int comidaCalorias, int cenaCalorias, int opcionLitrosAgua, int diaSemana, int horaDormir, int tiempoSueño, int ocio, int salud, int trabajo, int tiempoOcio, int tiempoSiesta) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.peso = peso;
        this.estatura = estatura;
        Comidas = comidas;
        DesayunoCalorias = desayunoCalorias;
        ComidaCalorias = comidaCalorias;
        CenaCalorias = cenaCalorias;
        OpcionLitrosAgua = opcionLitrosAgua;
        DiaSemana = diaSemana;
        HoraDormir = horaDormir;
        TiempoSueño = tiempoSueño;
        Ocio = ocio;
        Salud = salud;
        Trabajo = trabajo;
        TiempoOcio = tiempoOcio;
        TiempoSiesta = tiempoSiesta;
    }

    public int getComidas() {
        return Comidas;
    }

    public void setComidas(int comidas) {
        Comidas = comidas;
    }

    public int getDesayunoCalorias() {
        return DesayunoCalorias;
    }

    public void setDesayunoCalorias(int desayunoCalorias) {
        DesayunoCalorias = desayunoCalorias;
    }

    public int getComidaCalorias() {
        return ComidaCalorias;
    }

    public void setComidaCalorias(int comidaCalorias) {
        ComidaCalorias = comidaCalorias;
    }

    public int getCenaCalorias() {
        return CenaCalorias;
    }

    public void setCenaCalorias(int cenaCalorias) {
        CenaCalorias = cenaCalorias;
    }

    public int getOpcionLitrosAgua() {
        return OpcionLitrosAgua;
    }

    public void setOpcionLitrosAgua(int opcionLitrosAgua) {
        OpcionLitrosAgua = opcionLitrosAgua;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getEstatura() {
        return estatura;
    }

    public void setEstatura(Double estatura) {
        this.estatura = estatura;
    }
}
