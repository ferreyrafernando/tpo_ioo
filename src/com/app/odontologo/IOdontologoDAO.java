package com.app.odontologo;


public interface IOdontologoDAO {

    public void guardar(Odontologo odontologo);

    public void eliminar(int id);

    public void recuperar(int id);
}
