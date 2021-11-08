package com.app.dao;

import com.app.negocio.Odontologo;
import com.app.negocio.Paciente;
import java.util.ArrayList;

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
                Paciente pa = (Paciente) objeto;
                if(pa.getId() == paciente.getId()){
                    lista.remove(pa);
                    lista.add(paciente);
                }
            }
        }

        archivoP.guardar(lista);
    }

    @Override
    public ArrayList<Paciente> listar() {
        ArchivoPaciente archivo = new ArchivoPaciente ( "archivos/pacientes.txt");
        ArrayList lista = archivo.listar();
        ArrayList<Paciente> pacientes = new ArrayList<>();

        for(Object obj: lista)
            pacientes.add((Paciente) obj);

        return pacientes;
    }

    @Override
    public void eliminar(int id) {
        ArchivoPaciente archivo = new ArchivoPaciente("archivos/pacientes.txt");
        ArrayList lista = archivo.listar();

        int index = 0;
        int i = 0;
        for(Object objeto:lista)
        {
            if(((Paciente)objeto).getId() == id)
                index = i;
            i++;
        }
        lista.remove(index);
        archivo.guardar(lista);
    }

    @Override
    public void recuperar(int id) {
        ArrayList<Paciente> pacientes = this.listar();
        Paciente resultado = null;

        for(Pacientes pa: pacientes) {
            if (pa.getId() == id)
                resultado = pa;
        }

        return resultado;
    }
}
