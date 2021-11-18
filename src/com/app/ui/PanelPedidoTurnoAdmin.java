package com.app.ui;

import com.app.negocio.Odontologo;
import com.app.negocio.Paciente;
import com.app.negocio.Turno;
import com.app.service.PacienteService;
import com.app.service.TurnoService;
import com.app.service.UsuarioService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PanelPedidoTurnoAdmin extends JPanel {

    private PanelManager panelManager;

    private Turno turno_turno;

    //Componentes
    private JLabel lblPaciente;
    private JComboBox cboPaciente;
    private JLabel lblOdontologo;
    private JTextField txtOdontologo;
    private JLabel lblFechaTurno;
    private JTextField txtTurnoOdontologo;
    private JPanel panelComponentes;

    //Botonera
    private JButton btnGuardar;
    private JButton btnCancelar;

    private JPanel panelBotonera;

    public void armarPanelPedidoTurnoAdmin(PanelManager panelManager){
        this.panelManager=panelManager;
        this.setLayout(new BorderLayout());


        Odontologo odontologo = new Odontologo();
        UsuarioService us_service = new UsuarioService();
        PacienteService pa_service = new PacienteService();


        lblFechaTurno = new JLabel("Fecha y Hora:");
        lblOdontologo = new JLabel("Odontologo:");
        lblPaciente = new JLabel("Paciente:");

        cboPaciente = new JComboBox();
        txtOdontologo = new JTextField();
        txtTurnoOdontologo = new JTextField();

        panelComponentes = new JPanel();

        panelComponentes.add(lblFechaTurno);
        panelComponentes.add(txtTurnoOdontologo);
        panelComponentes.add(lblOdontologo);
        panelComponentes.add(txtOdontologo);
        panelComponentes.add(lblPaciente);
        panelComponentes.add(cboPaciente);


        //Creacion Botonera
        btnGuardar = new JButton("Guardar");
        btnGuardar.setEnabled(false);
        btnCancelar = new JButton("Cancelar");

        panelBotonera = new JPanel();
        panelBotonera.add(btnGuardar);
        panelBotonera.add(btnCancelar);

        //Listado - Grilla - Tabla de Odontologos

        add(panelComponentes, BorderLayout.CENTER);
        add(panelBotonera, BorderLayout.SOUTH);

        //Action listeners

        cboPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btnGuardar.setEnabled(cboPaciente.getSelectedItem() != null);
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TurnoService turnoService = new TurnoService();

                Turno tur1 = new Turno();
                tur1.setId(turno_turno.getId());
                tur1.setFechaHora(turno_turno.getFechaHora());
                tur1.setPaciente((Paciente) cboPaciente.getSelectedItem());
                tur1.setEstadoTurno("R");
                tur1.setOdontologo(turno_turno.getOdontologo());

                turnoService.guardar(tur1);

                limpiarControles();
                panelManager.mostrarListadoTurnos(true);

            }
        });


        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrarListadoTurnos(false);
            }
        });

        cboPaciente.setRenderer( new DefaultListCellRenderer(){

            @Override
            public Component getListCellRendererComponent(
                    JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus)
            {
                super.getListCellRendererComponent(list, value, index,
                        isSelected, cellHasFocus);

                if(value != null){
                    Paciente paciente = (Paciente)value;
                    setText( paciente.getNombre() + " " + paciente.getApellido());
                }
                return this;
            }
        });

    }

    private void llenaCboPaciente(){
        PacienteService pa_service = new PacienteService();
        ArrayList<Paciente> lista = pa_service.listar();
        for(Paciente pa:lista){
            cboPaciente.addItem(pa);
        }
    }

    public void llenarControles(Turno turno){
        this.turno_turno = turno;
        this.llenaCboPaciente();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String strDate= formatter.format(turno.getFechaHora());

        txtTurnoOdontologo.setText(strDate);
        txtTurnoOdontologo.setEnabled(false);
        txtOdontologo.setText(turno.getOdontologo().getNombre() + " " + turno.getOdontologo().getApellido());
        txtOdontologo.setEnabled(false);
        if (turno.getEstadoTurno().equals("R")){
            cboPaciente.setSelectedItem(turno.getPaciente());
            cboPaciente.setEnabled(false);
        }else{
            cboPaciente.setEnabled(true);
        }


    }


    public void limpiarControles(){

       txtTurnoOdontologo.setText("");
       txtOdontologo.setText("");
       cboPaciente.removeAll();
       cboPaciente.setEnabled(true);

    }


}
