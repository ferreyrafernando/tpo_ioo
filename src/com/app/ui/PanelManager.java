package com.app.ui;

import javax.swing.*;

public class PanelManager {

    private PanelListaOdontologo panelListaOdontologo;
    private PanelFormularioOdontologo panelFormularioOdontologo;
    private JFrame jframe;

    public void showFrame(){
        jframe.setVisible(true);
    }

    public void armarManager(){

        jframe = new JFrame();
        jframe.setBounds(200,200,500,500);

        panelFormularioOdontologo = new PanelFormularioOdontologo();
        panelFormularioOdontologo.armarPanelFormularioOdontologo(this);

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
}
