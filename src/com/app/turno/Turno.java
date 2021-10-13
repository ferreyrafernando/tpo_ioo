package com.app.turno;

import com.app.odontologo.Odontologo;
import com.app.paciente.Paciente;
import java.util.Date;

public class Turno {
    private Date fecha;
    private Date hora;
    private Paciente paciente;
    private Odontologo odontologo;
    private String estadoTurno; //L - Libre, R - Reservado, T - Tomado

    public Turno() {
        //Constructor
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public String getEstadoTurno() {
        return estadoTurno;
    }

    public void setEstadoTurno(String estadoTurno) {
        this.estadoTurno = estadoTurno;
    }

    public int reservarTurno(Turno turno){

        return 1;
    }
}
