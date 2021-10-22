package com.app.negocio;

public class Usuario {
    private String usuario;
    private String password;

    public Usuario() {
        //Constructor
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

    public Usuario login(String usuario, String password){
        Usuario userLogged = new Usuario();

        return userLogged;
    }
}
