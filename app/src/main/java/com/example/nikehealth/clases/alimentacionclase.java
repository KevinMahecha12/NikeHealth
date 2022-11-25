package com.example.nikehealth.clases;

import java.io.Serializable;

public class alimentacionclase implements Serializable {
    int Comidas,DesayunoCalorias,ComidaCalorias,CenaCalorias,OpcionLitrosAgua;

    public alimentacionclase() {
    }

    public alimentacionclase(int comidas, int desayunoCalorias, int comidaCalorias, int cenaCalorias, int opcionLitrosAgua) {
        Comidas = comidas;
        DesayunoCalorias = desayunoCalorias;
        ComidaCalorias = comidaCalorias;
        CenaCalorias = cenaCalorias;
        OpcionLitrosAgua = opcionLitrosAgua;
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
}
