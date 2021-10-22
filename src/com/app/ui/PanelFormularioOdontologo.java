package com.app.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFormularioOdontologo extends JPanel {

    private PanelManager panelManager;

    //Componentes
    private JLabel lblID;
    private JTextField txtID;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblApellido;
    private JTextField txtApellido;
    private JLabel lblMatricula;
    private JTextField txtMatricula;
    private JPanel panelComponentes;

    //Botonera
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JPanel panelBotonera;

    public void armarPanelFormularioOdontologo(PanelManager panelManager){

        this.panelManager = panelManager;
        setLayout(new BorderLayout());

        lblID = new JLabel("ID:");
        lblNombre = new JLabel("Nombre:");
        lblApellido = new JLabel("Apellido:");
        lblMatricula = new JLabel("Matricula:");
        txtID = new JFormattedTextField(5);
        txtNombre = new JFormattedTextField(20);
        txtApellido = new JFormattedTextField(20);
        txtMatricula = new JFormattedTextField(5);
        panelComponentes = new JPanel();
        panelComponentes.add(lblID);
        panelComponentes.add(txtID);
        panelComponentes.add(lblNombre);
        panelComponentes.add(txtNombre);
        panelComponentes.add(lblApellido);
        panelComponentes.add(txtApellido);
        panelComponentes.add(lblMatricula);
        panelComponentes.add(txtMatricula);

        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        panelBotonera = new JPanel();
        panelBotonera.add(btnGuardar);
        panelBotonera.add(btnCancelar);

        add(panelComponentes, BorderLayout.CENTER);
        add(panelBotonera, BorderLayout.SOUTH);

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrarListadoOdontologo();
            }
        });
    }
}
