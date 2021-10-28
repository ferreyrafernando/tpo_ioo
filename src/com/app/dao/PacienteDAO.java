package com.app.dao;

import com.app.negocio.Paciente;
import com.app.negocio.Usuario;


public class PacienteDAO implements IPacienteDAO{

    @Override
    public void guardar(Paciente paciente) {
        ArchivoPaciente archivoP = new ArchivoPaciente("archivos/pacientes.txt");
        ArrayList lista = archivoP.listar();
        long max = 0;

        if(paciente.getId() == 0) {
            for(Object objeto: lista)
            {
                if(((Paciente) objeto).getId() > max)
                    max = ((Paciente) objeto).getId();
            }
            paciente.setId(max + 1);
            lista.add(paciente);
        }
        else{
            for(Object objeto : lista){
                Paciente us = (Paciente) objeto;
                if(us.getId() == paciente.getId()){
                    lista.remove(us);
                    lista.add(paciente);
                }
            }
        }

        archivoP.guardar(lista);
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public void recuperar(int id) {

    }
}
