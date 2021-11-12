package com.app.dao;

import com.app.negocio.Paciente;
import java.util.ArrayList;

public interface IPacienteDAO {

    public void guardar(Paciente paciente);

    public void eliminar(Long id);

    public Paciente recuperar(Long id);

    public ArrayList<Paciente> listar ();


    Paciente recuperarByUserName(String userName);
}
