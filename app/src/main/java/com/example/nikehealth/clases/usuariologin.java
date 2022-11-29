package com.example.nikehealth.clases;

public class usuariologin
{    String correo;
    String contraseña;
    boolean Registrado;

    public usuariologin(String correo, String contraseña, boolean registrado) {
        this.correo = correo;
        this.contraseña = contraseña;
        Registrado = registrado;
    }

    public usuariologin() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean getRegistrado() {
        return Registrado;
    }

    public void setRegistrado(boolean registrado) {
        Registrado = registrado;
    }
}