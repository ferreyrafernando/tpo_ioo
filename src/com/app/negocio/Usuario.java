package com.app.negocio;

public class Usuario {
    private String userName;
    private String password;

    public Usuario() {
        //Constructor
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario login(String user, String pass){
        Usuario userLogged = new Usuario();

        return userLogged;
    }
}
