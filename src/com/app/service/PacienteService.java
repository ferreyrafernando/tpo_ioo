package com.app.service;

import com.app.dao.IPacienteDAO;
import com.app.dao.PacienteDAO;
import com.app.negocio.Paciente;

public class PacienteService {

    private IPacienteDAO pacienteDAO;

    public PacienteService() {
        pacienteDAO = new PacienteDAO();
    }
    public void guardar(Paciente paciente){
        pacienteDAO.guardar(paciente);
    }
    public void eliminar(long id){
        pacienteDAO.eliminar(id);
    }
    public ArrayList<Paciente> listar() {
        return pacienteDAO.listar();
    }
    public Paciente recuperar(long id){
        return pacienteDAO.recuperar(id);
    }



}
