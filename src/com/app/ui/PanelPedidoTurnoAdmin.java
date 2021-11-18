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
        panelComponentes.setLayout(new GridBagLayout());

        GridBagConstraints textos=new GridBagConstraints();
        GridBagConstraints formularios=new GridBagConstraints();
        formularios.ipady = 40;
        formularios.weightx = 2;
        formularios.gridx=2;
        formularios.gridwidth = 3;
        formularios.gridheight=2;
        formularios.insets=new Insets(0,0,0,50);
        formularios.anchor= GridBagConstraints.WEST;
        formularios.fill=GridBagConstraints.BOTH;

        textos.anchor=GridBagConstraints.EAST;
        textos.insets=new Insets(0,50,0,0);
        textos.weightx = 0.5;
        textos.gridx=1;
        textos.gridheight=2;
        textos.gridwidth=1;
        textos.fill=GridBagConstraints.BOTH;

        panelComponentes.add(lblFechaTurno,textos);
        panelComponentes.add(txtTurnoOdontologo,formularios);
        panelComponentes.add(lblOdontologo,textos);
        panelComponentes.add(txtOdontologo,formularios);
        panelComponentes.add(lblPaciente,textos);
        panelComponentes.add(cboPaciente,formularios);


        //Creacion Botonera
        btnGuardar = new JButton("Guardar");
        btnGuardar.setEnabled(false);
        btnCancelar = new JButton("Cancelar");

        panelBotonera = new JPanel();


        panelBotonera.setLayout(new GridBagLayout());

        Dimension botones=new Dimension(150,45);

        GridBagConstraints b1=new GridBagConstraints();
        b1.gridx=1;
        b1.insets=new Insets(0,0,0,20);
        b1.fill=GridBagConstraints.BOTH;
        btnGuardar.setPreferredSize(botones);

        GridBagConstraints b2=new GridBagConstraints();
        b2.gridx=2;
        b2.fill=GridBagConstraints.BOTH;
        btnCancelar.setPreferredSize(botones);

        panelBotonera.add(btnGuardar,b1);
        panelBotonera.add(btnCancelar,b2);



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
