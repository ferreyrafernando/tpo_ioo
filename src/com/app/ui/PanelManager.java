package com.app.ui;

import com.app.negocio.Odontologo;
import com.app.negocio.Paciente;
import com.app.negocio.Usuario;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelManager {

    private PanelListaOdontologo panelListaOdontologo;
    private PanelListaPacientes panelListaPacientes;
    private PanelListaTurnos panelListaTurnos;
    private PanelPedidoTurno panelPedidoTurno;
    private PanelFormularioOdontologo panelFormularioOdontologo;
    private PanelFormularioPaciente panelFormularioPaciente;

    private PanelMenuPrincipal panelMenuPrincipal;
    private JFrame jframe;

    private Usuario userLogged;

    public void showFrame(){
        jframe.setVisible(true);
    }

    public Usuario getUserLogged() {
        return userLogged;
    }

    public void setUserLogged(Usuario user) {
        this.userLogged = user;
    }

    public void armarManager(Character usarioRol){

        jframe = new JFrame();
        jframe.setBounds(500,250,800,600);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        try{
            BufferedImage icono= ImageIO.read(new File("./resources/iconexe.png"));
            jframe.setIconImage(icono);
        }
        catch(IOException e) {
            e.printStackTrace();
        }


        panelMenuPrincipal=new PanelMenuPrincipal();
        panelMenuPrincipal.armarPanelMenuPrincipal(this, usarioRol);

        if (usarioRol == 'P'){ // Si el usuario es de tipo Paciente, solo le armo el panel del menu principal y el de pedido de turno
            panelPedidoTurno=new PanelPedidoTurno();
            panelPedidoTurno.armarPanelPedidoTurno(this, this.getUserLogged());
        }else{
            panelListaTurnos=new PanelListaTurnos();
            panelListaTurnos.armarPanelListaTurnos(this);

            panelListaPacientes=new PanelListaPacientes();
            panelListaPacientes.armarPanelListaPacientes(this);

            panelFormularioPaciente = new PanelFormularioPaciente();
            panelFormularioPaciente.armarPanelFormularioPaciente(this);

            panelListaOdontologo = new PanelListaOdontologo();
            panelListaOdontologo.armarPanelListaOdontologo(this);

            panelFormularioOdontologo = new PanelFormularioOdontologo();
            panelFormularioOdontologo.armarPanelFormularioOdontologo(this);
        }

    }

    public void mostrarFormularioOdontologo(Odontologo odontologo){
        jframe.getContentPane().removeAll();
        jframe.getContentPane().add(panelFormularioOdontologo);
        if (odontologo != null){
            panelFormularioOdontologo.cargarDatos(odontologo);
        }else{
            panelFormularioOdontologo.limpiarControles();
        }
        jframe.getContentPane().validate();
        jframe.getContentPane().repaint();
    }

    public void mostrarListadoOdontologo(Boolean refresh){
        jframe.getContentPane().removeAll();
        if (refresh){
            panelListaOdontologo.getListaOdontologos();
        }
        jframe.getContentPane().add(panelListaOdontologo);

        jframe.getContentPane().validate();
        jframe.getContentPane().repaint();
    }

    public void mostrarListadoTurnos(){
        jframe.getContentPane().removeAll();
        jframe.getContentPane().add(panelListaTurnos);
        jframe.getContentPane().validate();
        jframe.getContentPane().repaint();
    }

    public void mostrarPedidoTurno(){
        jframe.getContentPane().removeAll();
        jframe.getContentPane().add(panelPedidoTurno);
        jframe.getContentPane().validate();
        jframe.getContentPane().repaint();
    }

    public void  mostrarFormularioPaciente(Paciente paciente){
        jframe.getContentPane().removeAll();
        jframe.getContentPane().add(panelFormularioPaciente);
        if (paciente != null){
            panelFormularioPaciente.cargarDatos(paciente);
        }else{
            panelFormularioPaciente.limpiarControles();
        }
        jframe.getContentPane().validate();
        jframe.getContentPane().repaint();
    }

    public void mostrarListadoPacientes(Boolean refresh){
        jframe.getContentPane().removeAll();
        if (refresh){
            panelListaPacientes.getListaPacientes();
        }
        jframe.getContentPane().add(panelListaPacientes);

        jframe.getContentPane().validate();
        jframe.getContentPane().repaint();
    }
/*
    public void mostrarPantallaLogin(){
        jframe.getContentPane().removeAll();
        jframe.getContentPane().add(panelLogin);
        jframe.getContentPane().validate();
        jframe.getContentPane().repaint();
    }


 */
    public void mostrarPantallaMenuPrincipal(){
        jframe.getContentPane().removeAll();
        jframe.getContentPane().add(panelMenuPrincipal);
        jframe.getContentPane().validate();
        jframe.getContentPane().repaint();
    }


}
