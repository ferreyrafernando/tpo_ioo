package com.app.odontologo;

import java.io.Serializable;
import com.app.persona.Persona;

public class Odontologo extends Persona implements Serializable {
    // private static final long serialVersionUID = 6529685098267757690L;

    private int matricula;
    private long id;
/*
    public Odontologo() {
        //Constructor
    }
*/
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
