package com.app.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelManager {

    private PanelListaOdontologo panelListaOdontologo;
    private PanelFormularioOdontologo panelFormularioOdontologo;
    private PanelLogin PanelLogin;
    private JFrame jframe;

    public void showFrame(){
        jframe.setVisible(true);
    }

    public void armarManager(){

        jframe = new JFrame();
        jframe.setBounds(200,200,800,600);
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

        panelListaOdontologo = new PanelListaOdontologo();
        panelListaOdontologo.armarPanelListaOdontologo(this);

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

    public void mostrarPantallaLogin(){
        jframe.getContentPane().removeAll();
        jframe.getContentPane().add(PanelLogin);
        jframe.getContentPane().validate();
        jframe.getContentPane().repaint();
    }


}
