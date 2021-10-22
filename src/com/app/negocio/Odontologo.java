package com.app.negocio;

import java.io.Serializable;

public class Odontologo extends Persona implements Serializable {

    private int matricula;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }


}
