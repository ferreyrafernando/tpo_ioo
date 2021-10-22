package com.app.service;

import com.app.dao.IOdontologoDAO;
import com.app.dao.OdontologoDAO;
import com.app.negocio.Odontologo;

import java.util.ArrayList;

public class OdontologoService {

    private IOdontologoDAO odontologoDAO;

    public OdontologoService(){
        odontologoDAO = new OdontologoDAO();
    }

    public void guardar(Odontologo odontologo){
        odontologoDAO.guardar(odontologo);
    }

    public Odontologo recuperar(long id){
        return odontologoDAO.recuperar(id);
    }

    public void eliminar(long id){
        odontologoDAO.eliminar(id);
    }

    public ArrayList<Odontologo> listar() {
        return odontologoDAO.listar();
    }

}
