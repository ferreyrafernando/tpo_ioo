package com.app.odontologo;


import java.util.ArrayList;

public interface IOdontologoDAO {

    public void guardar(Odontologo odontologo);
    public Odontologo recuperar(Long id);
    public void eliminar(Long id);
    public ArrayList<Odontologo> listar();

}
