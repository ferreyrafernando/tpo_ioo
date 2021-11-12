package com.app.dao;

import com.app.negocio.Turno;
import java.util.ArrayList;

public interface ITurnoDAO {

    public void guardar(Turno turno);

    public Turno recuperar(Long id);

    public ArrayList<Turno> listar ();

}
