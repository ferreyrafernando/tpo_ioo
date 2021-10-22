package com.app.dao;


import com.app.negocio.Odontologo;

import java.util.ArrayList;

public interface IOdontologoDAO {

    public void guardar(Odontologo odontologo);
    public Odontologo recuperar(Long id);
    public void eliminar(Long id);
    public ArrayList<Odontologo> listar();

}
