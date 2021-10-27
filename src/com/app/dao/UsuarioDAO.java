package com.app.dao;

import com.app.negocio.Usuario;

import java.util.ArrayList;

public class UsuarioDAO implements IUsuarioDAO{

    @Override
    public void guardar(Usuario usuario) {
        ArchivoUsuario archivo = new ArchivoUsuario("archivos/usuarios.txt");
        ArrayList lista = archivo.listar();
        long max = 0;

        if(usuario.getId() == 0) {
            for(Object objeto: lista)
            {
                if(((Usuario) objeto).getId() > max)
                    max = ((Usuario) objeto).getId();
            }
            usuario.setId(max + 1);
            lista.add(usuario);
        }
        else{
            for(Object objeto : lista){
                Usuario us = (Usuario) objeto;
                if(us.getId() == usuario.getId()){
                    lista.remove(us);
                    lista.add(usuario);
                }
            }
        }

        archivo.guardar(lista);
    }

    @Override
    public void eliminar(Long id) {
        ArchivoUsuario archivo = new ArchivoUsuario("archivos/usuarios.txt");
        ArrayList lista = archivo.listar();

        int index = 0;
        int i = 0;
        for(Object objeto:lista)
        {
            if(((Usuario)objeto).getId() == id)
                index = i;
            i++;
        }
        lista.remove(index);
        archivo.guardar(lista);
    }

    @Override
    public ArrayList<Usuario> listar() {
        ArchivoUsuario archivo = new ArchivoUsuario( "archivos/usuarios.txt");
        ArrayList lista = archivo.listar();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        for(Object obj: lista)
            usuarios.add((Usuario) obj);

        return usuarios;
    }

    @Override
    public Usuario recuperar(String userName) {
        ArrayList<Usuario> usuarios = this.listar();
        Usuario resultado = null;

        for(Usuario us : usuarios) {

            if (us.getUsuario().equals(userName))
                resultado = us;
        }

        return resultado;
    }
}
