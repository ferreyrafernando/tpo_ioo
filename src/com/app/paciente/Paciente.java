package com.app.paciente;

import com.app.persona.Persona;
import com.app.usuario.Usuario;
import java.util.Date;

public class Paciente extends Persona {

    private String domicilio;
    private String dni;
    private Date fechaDeAlta;


    public Paciente() {
        // Constructor
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(Date fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public int guardarRegistro(Paciente paciente){

        return 1;
    }
}
