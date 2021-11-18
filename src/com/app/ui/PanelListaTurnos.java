package com.app.ui;

import com.app.negocio.Turno;
import com.app.service.TurnoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

public class PanelListaTurnos extends JPanel {

    private PanelManager panelManager;

    //Grilla
    private JTable jtable;
    private DefaultTableModel contenidoTable;
    private JScrollPane scrollPane;

    //Botonera
    private JButton btnModificar;
    private JButton btnCancelar;

    private JPanel panelBotonera;

    public void getListaTurnos(){
        contenidoTable.setRowCount(0);
        TurnoService service = new TurnoService();
        ArrayList<Turno> lista = service.listar();

        for(Turno tu:lista){
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String strDate= formatter.format(tu.getFechaHora());

            Object [] row = new Object[4];
            row[0] = strDate;
            row[1] = tu.getOdontologo().getApellido() + ", " + tu.getOdontologo().getNombre();
            if (tu.getEstadoTurno().equals("R")){
                row[2] = tu.getPaciente().getApellido() + ", " + tu.getPaciente().getNombre();
            }else{
                row[2] = "LIBRE";
            }
            row[3] = tu;
            jtable.getColumnModel().getColumn(3).setMinWidth(0);
            jtable.getColumnModel().getColumn(3).setMaxWidth(0);

            contenidoTable.addRow(row);
        }
    }

    public void armarPanelListaTurnos(PanelManager panelManager){
        this.panelManager=panelManager;
        this.setLayout(new BorderLayout());

        //Creacion Botonera
        btnModificar = new JButton("Modificar");
        btnCancelar = new JButton("Cancelar");

        panelBotonera = new JPanel();
        panelBotonera.add(btnModificar);
        btnModificar.setEnabled(false);
        panelBotonera.add(btnCancelar);

        //Listado - Grilla - Tabla de Odontologos

        contenidoTable = new DefaultTableModel();
        jtable = new JTable(contenidoTable);
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(jtable);

        contenidoTable.addColumn("Dia/Horario");
        contenidoTable.addColumn("Odontólogo");
        contenidoTable.addColumn("Paciente");
        contenidoTable.addColumn("ObjTurno");

        this.getListaTurnos();


        add(panelBotonera, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);

        //Action listeners
        jtable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtable.getSelectedRow() != -1){
                    btnModificar.setEnabled(true);
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

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Turno tu_selected = new Turno();
                Vector row = (Vector) contenidoTable.getDataVector().elementAt(jtable.getSelectedRow());

                tu_selected = (Turno) row.get(3);
                if (tu_selected.getEstadoTurno().equals("L")){
                    panelManager.mostrarPedidoTurnoAdmin(tu_selected);
                }else{
                    JFrame f = new JFrame();
                    JOptionPane.showConfirmDialog(f,"No se puede modificar un turno reservado", "Atención", JOptionPane.DEFAULT_OPTION);
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
