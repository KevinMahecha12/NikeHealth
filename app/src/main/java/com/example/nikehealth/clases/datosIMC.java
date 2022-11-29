package com.example.nikehealth.clases;

public class datosIMC {
    String nombre;
    float imc;
    int Comidas,DesayunoCalorias,ComidaCalorias,CenaCalorias,OpcionLitrosAgua;

    public datosIMC() {
    }

    public datosIMC(String nombre, float imc) {
        this.nombre = nombre;
        this.imc = imc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }
}
