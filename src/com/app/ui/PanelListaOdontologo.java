package com.app.ui;

import com.app.negocio.Odontologo;
import com.app.service.OdontologoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelListaOdontologo extends JPanel {

    private PanelManager panelManager;

    //Grilla
    private JTable jtable;
    private DefaultTableModel contenidoTable;
    private JScrollPane scrollPane;

    //Botonera
    private JButton btnNuevo;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnCancelar;

    private JPanel panelBotonera;



    public void armarPanelListaOdontologo(PanelManager panelManager){
        this.setLayout(new BorderLayout());

        //Creacion Botonera
        btnNuevo = new JButton("Nuevo");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        btnCancelar = new JButton("Cancelar");

        panelBotonera = new JPanel();
        panelBotonera.add(btnNuevo);
        panelBotonera.add(btnModificar);
        panelBotonera.add(btnEliminar);
        panelBotonera.add(btnCancelar);

        //Listado - Grilla - Tabla de Odontologos

        contenidoTable = new DefaultTableModel();
        jtable = new JTable(contenidoTable);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(jtable);

        contenidoTable.addColumn("ID");
        contenidoTable.addColumn("Apellido");
        contenidoTable.addColumn("Matricula");

        OdontologoService service = new OdontologoService();
        ArrayList<Odontologo> lista = service.listar();

        for(Odontologo od:lista){
            Object [] row = new Object[3];
            row[0] = od.getId();
            row[1] = od.getApellido();
            row[2] = od.getMatricula();
            contenidoTable.addRow(row);
        }

        add(panelBotonera, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);

        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrarFormularioOdontologo();
            }
        });

    }
}
