package com.app.odontologo;

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
