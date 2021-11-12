package com.app.dao;

import com.app.negocio.Turno;

import java.util.ArrayList;
import java.util.ListIterator;

public class TurnoDAO implements ITurnoDAO{

    @Override
    public void guardar(Turno turno) {
        ArchivoPaciente archivo = new ArchivoPaciente("archivos/turnos.txt");
        ArrayList lista = archivo.listar();
        long max = 0;

        if(turno.getId() == 0) {
            for(Object objeto: lista)
            {
                if(((Turno) objeto).getId() > max)
                    max = ((Turno) objeto).getId();
            }
            turno.setId(max + 1);
            lista.add(turno);
        }
        else{
            ListIterator<Turno> iter = lista.listIterator();
            while(iter.hasNext()){
                if(iter.next().getId() == turno.getId()){
                    iter.remove();
                }
            }
            lista.add(turno);
        }

        archivo.guardar(lista);
    }

    @Override
    public ArrayList<Turno> listar() {
        ArchivoTurno archivo = new ArchivoTurno ( "archivos/turnos.txt");
        ArrayList lista = archivo.listar();
        ArrayList<Turno> turnos = new ArrayList<>();

        for(Object obj: lista)
            turnos.add((Turno) obj);

        return turnos;
    }


    @Override
    public Turno recuperar(Long id) {
        ArrayList<Turno> turnos = this.listar();
        Turno resultado = null;

        for(Turno tu: turnos) {
            if (tu.getId() == id)
                resultado = tu;
        }

        return resultado;
    }

}
