package com.app.dao;

import com.app.negocio.Paciente;
import java.util.ArrayList;

public class PacienteDAO implements IPacienteDAO{

    @Override
    public void guardar(Paciente paciente) {
        /* Lo dejo comentado porque el método listar que está puesto, al no estar implementado,
        no deja ejecutar la GUI para testear, cuando esté implementado sacar el comentado


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
                Paciente pa = (Paciente) objeto;
                if(pa.getId() == paciente.getId()){
                    lista.remove(pa);
                    lista.add(paciente);
                }
            }
        }

        archivoP.guardar(lista);

         */
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public void recuperar(int id) {

    }
}
