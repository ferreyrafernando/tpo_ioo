package com.app.ui;

import com.app.negocio.Odontologo;
import com.app.negocio.Paciente;
import com.app.service.OdontologoService;
import com.app.service.PacienteService;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelListaPacientes extends JPanel{

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

    public void armarPanelListaPacientes(PanelManager panelManager){
        this.panelManager=panelManager;
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

        //ActionListeners

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrarPantallaMenuPrincipal();
            }
        });

        //Listado - Grilla - Tabla de Odontologos

        contenidoTable = new DefaultTableModel();
        jtable = new JTable(contenidoTable);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(jtable);

        contenidoTable.addColumn("ID");
        contenidoTable.addColumn("Nombre");
        contenidoTable.addColumn("Apellido");
        contenidoTable.addColumn("DNI");
        contenidoTable.addColumn("Fecha de alta");
        contenidoTable.addColumn("Domicilio");

        /* Esto lo dejo comentado porque falta implementar
        PacienteService service = new PacienteService();
        ArrayList<Paciente> lista = service.listar();

        for(Paciente pa:lista){
            Object [] row = new Object[6];
            row[0] = pa.getId();
            row[1] = pa.getNombre();
            row[2] = pa.getApellido();
            row[3] = pa.getDNI();
            row[4] = pa.getFechaAlta();
            row[5] = pa.getDomicilio();
            contenidoTable.addRow(row);
        }
        */
        add(panelBotonera, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);
    }
}
