package com.app.odontologo;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Random;

public class OdontologoDAO implements IOdontologoDAO{

    @Override
    public void guardar(Odontologo odontologo) {
        ArchivoOdontologo archivo = new ArchivoOdontologo("archivos/odontologos.txt");
        ArrayList lista = archivo.listar();
        long max = 0;

        if(odontologo.getId() == 0) {
            for(Object objeto: lista)
            {
                if(((Odontologo) objeto).getId() > max)
                    max = ((Odontologo) objeto).getId();
            }
            odontologo.setId(max + 1);
            lista.add(odontologo);
        }
        else{
            for(Object objeto : lista){
                Odontologo od = (Odontologo) objeto;
                if(od.getId() == odontologo.getId()){
                    lista.remove(od);
                    lista.add(odontologo);
                }
            }
        }

        archivo.guardar(lista);
    }

    @Override
    public void eliminar(Long id) {
        ArchivoOdontologo archivo = new ArchivoOdontologo("archivos/odontologos.txt");
        ArrayList lista = archivo.listar();

        int index = 0;
        int i = 0;
        for(Object objeto:lista)
        {
            if(((Odontologo)objeto).getId() == id)
                index = i;
            i++;
        }
        lista.remove(index);
        archivo.guardar(lista);
    }

    @Override
    public ArrayList<Odontologo> listar() {
        ArchivoOdontologo archivo = new ArchivoOdontologo( "archivos/odontologos.txt");
        ArrayList lista = archivo.listar();
        ArrayList<Odontologo> odontologos = new ArrayList<>();

        for(Object obj: lista)
            odontologos.add((Odontologo) obj);

        return odontologos;
    }

    @Override
    public Odontologo recuperar(Long id) {
        ArrayList<Odontologo> odontologos = this.listar();
        Odontologo resultado = null;

        for(Odontologo od : odontologos) {
            if (od.getId() == id)
                resultado = od;
        }

        return resultado;
    }
}