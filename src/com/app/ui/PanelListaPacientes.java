package com.app.ui;


import com.app.negocio.Paciente;
import com.app.negocio.Usuario;
import com.app.service.PacienteService;
import com.app.service.UsuarioService;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

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

    public void getListaPacientes(){
        contenidoTable.setRowCount(0);
        PacienteService service = new PacienteService();
        ArrayList<Paciente> lista = service.listar();

        for(Paciente pa:lista){
            System.out.println(pa.getFechaDeAlta());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String strDate= formatter.format(pa.getFechaDeAlta());
            //LocalDateTime now = LocalDateTime.now();

            Object [] row = new Object[8];
            row[0] = pa.getId();
            row[1] = pa.getNombre();
            row[2] = pa.getApellido();
            row[3] = pa.getDni();
            row[4] = pa.getDomicilio();
            row[5] = strDate;
            row[6] = pa.getUsuario().getUsuario();
            row[7] = pa.getUsuario().getPassword();
            contenidoTable.addRow(row);
        }
    }

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
        contenidoTable.addColumn("DNI");
        contenidoTable.addColumn("Domicilio");
        contenidoTable.addColumn("Fecha de alta");
        contenidoTable.addColumn("Usuario");
        contenidoTable.addColumn("Clave");

        getListaPacientes();

        add(panelBotonera, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);


        //ActionListeners
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
                panelManager.mostrarFormularioPaciente(null);
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Paciente pa_selected = new Paciente();
                Usuario us_selected = new Usuario();
                Vector row = (Vector) contenidoTable.getDataVector().elementAt(jtable.getSelectedRow());

                pa_selected.setId((Long)row.get(0));
                pa_selected.setNombre(row.get(1).toString());
                pa_selected.setApellido(row.get(2).toString());
                pa_selected.setDni(row.get(3).toString());
                pa_selected.setDomicilio(row.get(4).toString());

                Date fechaAltaDate = null;
                try {
                    fechaAltaDate = new SimpleDateFormat("dd/MM/yyyy").parse(row.get(5).toString());
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                pa_selected.setFechaDeAlta(fechaAltaDate);

                us_selected.setUsuario(row.get(6).toString());
                us_selected.setPassword(row.get(7).toString());
                pa_selected.setUsuario(us_selected);

                panelManager.mostrarFormularioPaciente(pa_selected);

            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector row = (Vector) contenidoTable.getDataVector().elementAt(jtable.getSelectedRow());
                String pacienteFullName = row.get(1).toString() + " " + row.get(2).toString() ;
                JFrame f = new JFrame();

                Integer respuesta = JOptionPane.showConfirmDialog(f,"¿Desea Eliminar el registro de " + pacienteFullName +"?", "Atención", JOptionPane.YES_NO_CANCEL_OPTION);
                // SI - 0
                // NO - 1
                // CANCELAR - 2
                if (respuesta == 0){
                    PacienteService paservice = new PacienteService();
                    UsuarioService usservice = new UsuarioService();
                    paservice.eliminar((Long)row.get(0));
                    usservice.eliminar(row.get(6).toString());
                    getListaPacientes();
                }

            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrarPantallaMenuPrincipal();
            }
        });
    }
}
