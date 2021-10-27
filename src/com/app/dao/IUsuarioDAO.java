package com.app.dao;

import com.app.negocio.Usuario;

import java.util.ArrayList;

public interface IUsuarioDAO {

    public void guardar(Usuario usuario);
    public Usuario recuperar(String userName);
    public void eliminar(Long id);
    public ArrayList<Usuario> listar();
}
