package com.example.nikehealth.clases;

import java.io.Serializable;

public class cargarIMC extends datosIMC implements Serializable {
    String datosIMC;



    public cargarIMC(String datosIMC) {
        this.datosIMC = datosIMC;
    }

    public cargarIMC(String nombre, float imc, String datosIMC) {
        super(nombre, imc);
        this.datosIMC = datosIMC;
    }

    public String getDatosIMC() {
        return datosIMC;
    }

    public void setDatosIMC(String datosIMC) {
        this.datosIMC = datosIMC;
    }
}
