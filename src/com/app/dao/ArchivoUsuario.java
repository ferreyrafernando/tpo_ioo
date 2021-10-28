package com.app.dao;

import com.app.negocio.Usuario;

import java.io.*;
import java.util.ArrayList;

public class ArchivoUsuario {

    private String path;

    public ArchivoUsuario(String path){
        this.path = path;
    }

    public void guardar(ArrayList coleccion)
    {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(coleccion);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Usuario> listar()
    {
        ArrayList lista = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Object objeto = objectInputStream.readObject();
            if(objeto != null) {
                lista = (ArrayList) objeto;
            }else
                lista = new ArrayList();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            lista = new ArrayList();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }

}