package com.app.negocio;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String usuario;
    private String password;
    private String rol; //A - Administrador; O - Odontologo; P - Paciente

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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


}
