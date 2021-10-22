package com.app.dao;

import com.app.negocio.Paciente;

public interface IPacienteDAO {

    public void guardar(Paciente paciente);

    public void eliminar(int id);

    public void recuperar(int id);



}
