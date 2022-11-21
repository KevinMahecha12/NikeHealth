package com.example.nikehealth;

import java.io.Serializable;

public class datosclase implements Serializable {

    String nombre,ocupacion;
    int edad;
    Double peso,estatura;

    public datosclase() {
    }

    public datosclase(String nombre, String ocupacion, int edad, Double peso, Double estatura) {
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
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

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
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
