package com.example.nikehealth.clases;

import java.io.Serializable;

public class atencionsaludclase implements Serializable  {
    boolean consultamedico = false;
    boolean tomamedicamentos = false;
    boolean problemasemocionales = false;
    boolean padecimientosestres = false;

    public atencionsaludclase() {
    }

    public atencionsaludclase(boolean consultamedico, boolean tomamedicamentos, boolean problemasemocionales, boolean padecimientosestres) {
        this.consultamedico = consultamedico;
        this.tomamedicamentos = tomamedicamentos;
        this.problemasemocionales = problemasemocionales;
        this.padecimientosestres = padecimientosestres;
    }

    public boolean isConsultamedico() {
        return consultamedico;
    }

    public void setConsultamedico(boolean consultamedico) {
        this.consultamedico = consultamedico;
    }

    public boolean isTomamedicamentos() {
        return tomamedicamentos;
    }

    public void setTomamedicamentos(boolean tomamedicamentos) {
        this.tomamedicamentos = tomamedicamentos;
    }

    public boolean isProblemasemocionales() {
        return problemasemocionales;
    }

    public void setProblemasemocionales(boolean problemasemocionales) {
        this.problemasemocionales = problemasemocionales;
    }

    public boolean isPadecimientosestres() {
        return padecimientosestres;
    }

    public void setPadecimientosestres(boolean padecimientosestres) {
        this.padecimientosestres = padecimientosestres;
    }
}
