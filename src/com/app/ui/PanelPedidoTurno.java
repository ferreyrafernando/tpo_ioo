package com.app.ui;

import com.app.negocio.Odontologo;
import com.app.negocio.Paciente;
import com.app.negocio.Usuario;
import com.app.service.OdontologoService;
import com.app.service.PacienteService;
import com.app.service.UsuarioService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelPedidoTurno extends JPanel {

    private PanelManager panelManager;

    //Componentes
    private JLabel lblOdontologo;
    private JComboBox cboOdontologo;
    private JLabel lblFechaTurno;
    private JComboBox cboTurnoOdontologo;
    private JPanel panelComponentes;

    //Botonera
    private JButton btnAceptar;
    private JButton btnCancelar;

    private JPanel panelBotonera;

    public void armarPanelPedidoTurno(PanelManager panelManager, Usuario userLogged){
        this.panelManager=panelManager;
        this.setLayout(new BorderLayout());


        Odontologo odontologo = new Odontologo();
        UsuarioService us_service = new UsuarioService();
        PacienteService pa_service = new PacienteService();
        Paciente paciente = pa_service.recuperarByUserName(userLogged.getUsuario());
        System.out.println(userLogged.getId());

        lblOdontologo = new JLabel("Odontologo:");
        lblFechaTurno = new JLabel("Fecha y Hora:");

        cboOdontologo = new JComboBox();
        llenaCboOdontologo();
        cboTurnoOdontologo = new JComboBox();

        panelComponentes = new JPanel();
        panelComponentes.add(lblOdontologo);
        panelComponentes.add(cboOdontologo);
        panelComponentes.add(lblFechaTurno);
        panelComponentes.add(cboTurnoOdontologo);

        //Creacion Botonera
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");

        panelBotonera = new JPanel();
        panelBotonera.add(btnAceptar);
        panelBotonera.add(btnCancelar);

        //Listado - Grilla - Tabla de Odontologos
        if (paciente != null){
            System.out.println(paciente.getNombre());
        }

        add(panelComponentes, BorderLayout.CENTER);
        add(panelBotonera, BorderLayout.SOUTH);

        //Action listeners

        cboOdontologo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                llenaCboTurnos ((Odontologo) cboOdontologo.getSelectedItem());
            }


        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrarPantallaMenuPrincipal();
            }
        });

        cboOdontologo.setRenderer( new DefaultListCellRenderer(){

            @Override
            public Component getListCellRendererComponent(
                    JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus)
            {
                super.getListCellRendererComponent(list, value, index,
                        isSelected, cellHasFocus);

                if(value != null){
                    Odontologo odontologo = (Odontologo)value;
                    setText( odontologo.getNombre() + " " + odontologo.getApellido());
                }
                return this;
            }
        });


    }



    private void llenaCboOdontologo(){
       OdontologoService od_service = new OdontologoService();
       ArrayList<Odontologo> lista = od_service.listar();

        for(Odontologo od:lista){
           cboOdontologo.addItem(od);
        }
    }

    private void llenaCboTurnos(Odontologo selectedItem) {
        System.out.println(selectedItem.getNombre());
    }
}
