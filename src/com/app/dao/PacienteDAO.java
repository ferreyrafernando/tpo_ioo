package com.app.dao;

import com.app.negocio.Paciente;

import java.util.ArrayList;
import java.util.ListIterator;

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
            ListIterator<Paciente> iter = lista.listIterator();
            while(iter.hasNext()){
                if(iter.next().getId() == paciente.getId()){
                    iter.remove();
                }
            }
            lista.add(paciente);
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
    public void eliminar(Long id) {
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
    public Paciente recuperar(Long id) {
        ArrayList<Paciente> pacientes = this.listar();
        Paciente resultado = null;

        for(Paciente pa: pacientes) {
            if (pa.getId() == id)
                resultado = pa;
        }

        return resultado;
    }

    @Override
    public Paciente recuperarByUserName(String userName) {
        ArrayList<Paciente> pacientes = this.listar();
        Paciente resultado = null;

        for(Paciente pa: pacientes) {
            System.out.println("UserM: " + userName);
            if (pa.getUsuario().getUsuario().equals(userName))
                resultado = pa;

        }

        return resultado;
    }


}
