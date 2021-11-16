package com.app.ui;

import com.app.negocio.Odontologo;
import com.app.negocio.Paciente;
import com.app.negocio.Turno;
import com.app.negocio.Usuario;
import com.app.service.OdontologoService;
import com.app.service.PacienteService;
import com.app.service.TurnoService;
import com.app.service.UsuarioService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PanelPedidoTurno extends JPanel {

    private PanelManager panelManager;

    private Turno turno_turno;
    private Paciente paciente_turno;
    private Odontologo odontologo_turno;

    //Componentes
    private JLabel lblPaciente;
    private JTextField txtPaciente;
    private JLabel lblOdontologo;
    private JComboBox cboOdontologo;
 //   private static final String NOT_SELECTABLE_OPTION_OD = " - Seleccione un Odontologo - ";
    private JLabel lblFechaTurno;
    private JComboBox cboTurnoOdontologo;
  //  private static final String NOT_SELECTABLE_OPTION_TUR = " - Seleccione un Turno Disponible - ";
    private JPanel panelComponentes;

    //Botonera
    private JButton btnGuardar;
    private JButton btnCancelar;

    private JPanel panelBotonera;

    public void armarPanelPedidoTurno(PanelManager panelManager, Usuario userLogged){
        this.panelManager=panelManager;
        this.setLayout(new BorderLayout());


        Odontologo odontologo = new Odontologo();
        UsuarioService us_service = new UsuarioService();
        PacienteService pa_service = new PacienteService();

        System.out.println("user Log: " + userLogged.getUsuario());
        Paciente paciente = pa_service.recuperarByUserName(userLogged.getUsuario());
        System.out.println(paciente.getNombre());
        System.out.println(userLogged.getId());

        lblPaciente = new JLabel("Paciente:");
        lblOdontologo = new JLabel("Odontologo:");
        lblFechaTurno = new JLabel("Fecha y Hora:");

        txtPaciente = new JTextField();
        cboOdontologo = new JComboBox();
        this.llenaCboOdontologo();
        cboTurnoOdontologo = new JComboBox();

        panelComponentes = new JPanel();
        panelComponentes.add(lblPaciente);
        panelComponentes.add(txtPaciente);

        panelComponentes.add(lblOdontologo);
        panelComponentes.add(cboOdontologo);
        panelComponentes.add(lblFechaTurno);
        panelComponentes.add(cboTurnoOdontologo);

        //Creacion Botonera
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        panelBotonera = new JPanel();
        panelBotonera.add(btnGuardar);
        panelBotonera.add(btnCancelar);

        //Listado - Grilla - Tabla de Odontologos
        if (paciente != null){
            paciente_turno = paciente;
            txtPaciente.setText(paciente.getNombre() + " " + paciente.getApellido());
            txtPaciente.setEnabled(false);
        }

        add(panelComponentes, BorderLayout.CENTER);
        add(panelBotonera, BorderLayout.SOUTH);

        //Action listeners

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TurnoService turnoService = new TurnoService();

                Turno tur1 = new Turno();
                tur1.setId(turno_turno.getId());
                tur1.setFechaHora(turno_turno.getFechaHora());
                tur1.setPaciente(paciente_turno);
                tur1.setEstadoTurno("R");
                tur1.setOdontologo(odontologo_turno);

                turnoService.guardar(tur1);

                limpiarControles();
                panelManager.mostrarPantallaMenuPrincipal();

            }
        });


        cboOdontologo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                odontologo_turno = (Odontologo) cboOdontologo.getSelectedItem();
                llenaCboTurnos ((Odontologo) cboOdontologo.getSelectedItem());
            }
        });

        cboTurnoOdontologo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                turno_turno = (Turno) cboTurnoOdontologo.getSelectedItem();
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

        cboTurnoOdontologo.setRenderer( new DefaultListCellRenderer(){

            @Override
            public Component getListCellRendererComponent(
                    JList list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus)
            {
                super.getListCellRendererComponent(list, value, index,
                        isSelected, cellHasFocus);

                if(value != null){
                    Turno turno = (Turno)value;
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                    String strDate= formatter.format(turno.getFechaHora());
                    setText(strDate);
                }
                return this;
            }
        });


    }

    private void llenaCboOdontologo(){
       OdontologoService od_service = new OdontologoService();
       ArrayList<Odontologo> lista = od_service.listar();
    //    cboOdontologo.addItem(NOT_SELECTABLE_OPTION_OD);
        for(Odontologo od:lista){
           cboOdontologo.addItem(od);
        }
    }

    private void llenaCboTurnos(Odontologo selectedItem) {
        System.out.println(selectedItem.getNombre());
        TurnoService tu_service = new TurnoService();
        ArrayList<Turno> disponibles = tu_service.recuperarTurnoLibreByOdontologo(selectedItem.getId());
      //  cboTurnoOdontologo.addItem(NOT_SELECTABLE_OPTION_TUR);
        if (disponibles != null){
            for(Turno tu_d:disponibles){
                cboTurnoOdontologo.addItem(tu_d);
            }
        }
    }

    public void limpiarControles(){

       txtPaciente.setText("");
       cboOdontologo.removeAll();;
       cboTurnoOdontologo.removeAll();

    }


}
