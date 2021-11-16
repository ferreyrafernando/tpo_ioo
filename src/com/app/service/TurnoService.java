package com.app.service;

import com.app.dao.ITurnoDAO;
import com.app.dao.TurnoDAO;
import com.app.negocio.Turno;

import java.util.ArrayList;

public class TurnoService {

    private ITurnoDAO turnoDAO;

    public TurnoService() {
        turnoDAO = new TurnoDAO();
    }

    public void guardar(Turno turno){
        turnoDAO.guardar(turno);
    }
    public ArrayList<Turno> listar() {
        return turnoDAO.listar();
    }
    public ArrayList<Turno> recuperarTurnoLibreByOdontologo(long idOdontologo) {
        return turnoDAO.recuperarTurnoLibreByOdontologo(idOdontologo);
    }
    public Turno recuperar(long id){
        return turnoDAO.recuperar(id);
    }



}
