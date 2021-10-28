package com.app.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelManager {

    private PanelListaOdontologo panelListaOdontologo;
    private PanelListaPacientes panelListaPacientes;
    private PanelListaTurnos panelListaTurnos;
    private PanelFormularioOdontologo panelFormularioOdontologo;
    private PanelLogin PanelLogin;
    private PanelMenuPrincipal PanelMenuPrincipal;
    private JFrame jframe;

    public void showFrame(){
        jframe.setVisible(true);
    }

    public void armarManager(){

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

        panelFormularioOdontologo = new PanelFormularioOdontologo();
        panelFormularioOdontologo.armarPanelFormularioOdontologo(this);

        PanelLogin=new PanelLogin();
        PanelLogin.armarPanelLogin(this);

        PanelMenuPrincipal=new PanelMenuPrincipal();
        PanelMenuPrincipal.armarPanelMenuPrincipal(this);

        panelListaOdontologo = new PanelListaOdontologo();
        panelListaOdontologo.armarPanelListaOdontologo(this);

        panelListaPacientes=new PanelListaPacientes();
        panelListaPacientes.armarPanelListaPacientes(this);

        panelListaTurnos=new PanelListaTurnos();
        panelListaTurnos.armarPanelListaTurnos(this);

    }

    public void mostrarFormularioOdontologo(){
        jframe.getContentPane().removeAll();
        jframe.getContentPane().add(panelFormularioOdontologo);
        jframe.getContentPane().validate();
        jframe.getContentPane().repaint();
    }

    public void mostrarListadoOdontologo(){
        jframe.getContentPane().removeAll();
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

    public void mostrarListadoPacientes(){
        jframe.getContentPane().removeAll();
        jframe.getContentPane().add(panelListaPacientes);
        jframe.getContentPane().validate();
        jframe.getContentPane().repaint();
    }

    public void mostrarPantallaLogin(){
        jframe.getContentPane().removeAll();
        jframe.getContentPane().add(PanelLogin);
        jframe.getContentPane().validate();
        jframe.getContentPane().repaint();
    }

    public void mostrarPantallaMenuPrincipal(){
        jframe.getContentPane().removeAll();
        jframe.getContentPane().add(PanelMenuPrincipal);
        jframe.getContentPane().validate();
        jframe.getContentPane().repaint();
    }


}
