package com.app.paciente;

public interface IPacienteDAO {

    public void guardar(Paciente paciente);

    public void eliminar(int id);

    public void recuperar(int id);



}
