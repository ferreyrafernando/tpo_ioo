package com.app.service;


import com.app.dao.IUsuarioDAO;
import com.app.dao.UsuarioDAO;
import com.app.negocio.Usuario;

import java.util.ArrayList;

public class UsuarioService {

    private IUsuarioDAO usuarioDAO;

    public UsuarioService(){
        usuarioDAO = new UsuarioDAO();
    }

    public void guardar(Usuario usuario){
        usuarioDAO.guardar(usuario);
    }

    public Usuario recuperar(String userName){
        return usuarioDAO.recuperar(userName);
    }

    public void eliminar(String userName){
        usuarioDAO.eliminar(userName);
    }

    public ArrayList<Usuario> listar() {
        return usuarioDAO.listar();
    }
}
