package com.app.odontologo;

import com.app.persona.Persona;

public class Odontologo extends Persona {

    private int matricula;


    public Odontologo() {
        //Constructor
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int guardarRegistro(Odontologo odontologo){

        return 1;
    }

}
