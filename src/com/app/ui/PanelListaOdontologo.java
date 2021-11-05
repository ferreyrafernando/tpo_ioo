package com.app.ui;

import com.app.negocio.Odontologo;
import com.app.service.OdontologoService;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;

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



    public void getListaOdontologos(){
        contenidoTable.setRowCount(0);
        OdontologoService service = new OdontologoService();
        ArrayList<Odontologo> lista = service.listar();

        for(Odontologo od:lista){
            System.out.println(od.getApellido());
            Object [] row = new Object[4];
            row[0] = od.getId();
            row[1] = od.getNombre();
            row[2] = od.getApellido();
            row[3] = od.getMatricula();
            contenidoTable.addRow(row);
        }
    }

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

        //Deshabilito Ciertos botones
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);

        //Listado - Grilla - Tabla de Odontologos
        contenidoTable = new DefaultTableModel();
        jtable = new JTable(contenidoTable);

        scrollPane = new JScrollPane();
        scrollPane.setViewportView(jtable);

        contenidoTable.addColumn("ID");
        contenidoTable.addColumn("Nombre");
        contenidoTable.addColumn("Apellido");
        contenidoTable.addColumn("Matricula");

        getListaOdontologos();

        add(panelBotonera, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);


        //Action listeners

        jtable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtable.getSelectedRow() != -1){
                    btnModificar.setEnabled(true);
                    btnEliminar.setEnabled(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrarFormularioOdontologo(null);
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Odontologo od_selected = new Odontologo();
                Vector row = (Vector) contenidoTable.getDataVector().elementAt(jtable.getSelectedRow());

                od_selected.setId((Long)row.get(0));
                od_selected.setNombre(row.get(1).toString());
                od_selected.setApellido(row.get(2).toString());
                od_selected.setMatricula((Integer) row.get(3));

                panelManager.mostrarFormularioOdontologo(od_selected);

            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector row = (Vector) contenidoTable.getDataVector().elementAt(jtable.getSelectedRow());
                String odontologoFullName = row.get(1).toString() + " " + row.get(2).toString() ;
                JFrame f = new JFrame();

                Integer respuesta = JOptionPane.showConfirmDialog(f,"¿Desea Eliminar el registro de " + odontologoFullName +"?", "Atención", JOptionPane.YES_NO_CANCEL_OPTION);
                // SI - 0
                // NO - 1
                // CANCELAR - 2
                if (respuesta == 0){
                    OdontologoService odservice = new OdontologoService();
                    odservice.eliminar((Long)row.get(0));
                    getListaOdontologos();
                }

            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrarPantallaMenuPrincipal();
            }
        });
    }
}
