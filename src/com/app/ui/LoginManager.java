package com.app.ui;

import com.app.negocio.Usuario;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoginManager {
    private PanelLogin panelLogin;
    private JFrame jframeLogin;
    public void showFrame(){
        jframeLogin.setVisible(true);
    }

    public void armarLoginManager(){

        jframeLogin = new JFrame();
        jframeLogin.setBounds(500,250,800,600);
        jframeLogin.setDefaultCloseOperation(jframeLogin.EXIT_ON_CLOSE);
        try{
            BufferedImage icono= ImageIO.read(new File("./resources/iconexe.png"));
            jframeLogin.setIconImage(icono);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        panelLogin=new PanelLogin();
        panelLogin.armarPanelLogin(this);

    }

    public void mostrarPantallaMenuPrincipal(Usuario usuario){
        PanelManager panelMgr = new PanelManager();
        panelMgr.setUserLogged(usuario);
        panelMgr.armarManager(usuario.getRol());
        jframeLogin.setVisible(false);
        panelMgr.showFrame();
        panelMgr.mostrarPantallaMenuPrincipal();

    }
    public void mostrarPantallaLogin(){

        jframeLogin.getContentPane().removeAll();
        jframeLogin.getContentPane().add(panelLogin);
        jframeLogin.getContentPane().validate();
        jframeLogin.getContentPane().repaint();
    }

}
