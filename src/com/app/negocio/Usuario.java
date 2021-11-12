package com.app.negocio;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String usuario;
    private String password;

    private Character rol; //A - Administrador; O - Odontologo; P - Paciente

    private long id;

    public Usuario() {
        //Constructor
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String userName) {
        this.usuario = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Character getRol() {
        return rol;
    }

    public void setRol(Character rol) {
        this.rol = rol;
    }

    public Usuario login(String usuario, String password){
        Usuario userLogged = new Usuario();

        return userLogged;
    }
}
