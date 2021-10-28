package com.app.ui;

import com.app.negocio.Odontologo;
import com.app.service.OdontologoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelListaTurnos extends JPanel {

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

    public void armarPanelListaTurnos(PanelManager panelManager){
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

        //Listado - Grilla - Tabla de Odontologos

        contenidoTable = new DefaultTableModel();
        jtable = new JTable(contenidoTable);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(jtable);

        contenidoTable.addColumn("Día");
        contenidoTable.addColumn("Horario");
        contenidoTable.addColumn("Odontólogo");
        contenidoTable.addColumn("Paciente");

/* Esto lo dejo comentado porque falta implementar
        TurnoService service = new TurnoService();
        ArrayList<Turno> lista = service.listar();

        for(Turno tu:lista){
            Object [] row = new Object[4];
            row[0] = tu.getDia();
            row[1] = tu.getHorario();
            row[2] = tu.getOdontologo();
            row[3] = tu.getPaciente();
            contenidoTable.addRow(row);
        }
 */
        add(panelBotonera, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);

        //Action listeners

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrarPantallaMenuPrincipal();
            }
        });

    }
}
