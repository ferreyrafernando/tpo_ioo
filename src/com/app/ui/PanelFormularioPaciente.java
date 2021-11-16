package com.app.ui;

import com.app.negocio.Paciente;
import com.app.negocio.Usuario;
import com.app.service.PacienteService;
import com.app.service.UsuarioService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PanelFormularioPaciente extends JPanel {

    private PanelManager panelManager;
    private Character accion; //Para controlar las acciones de Alta (A) o Modificacion (M)

    //Componentes
    private JLabel lblID;
    private JTextField txtID;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblApellido;
    private JTextField txtApellido;
    private JLabel lblDNI;
    private JTextField txtDNI;
    private JLabel lblDomicilio;
    private JTextField txtDomicilio;
    private JLabel lblFechaAlta;
    private JTextField txtFechaAlta;
    private JLabel lblUsuario;
    private JTextField txtUsuario;
    private JLabel lblClave;
    private JTextField txtClave;
    private JPanel panelComponentes;

    //Botonera
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JPanel panelBotonera;

    public void armarPanelFormularioPaciente(PanelManager panelManager){

        this.panelManager = panelManager;
        setLayout(new BorderLayout());

        lblID = new JLabel("ID:");
        lblNombre = new JLabel("Nombre:");
        lblApellido = new JLabel("Apellido:");
        lblDNI = new JLabel("Documento:");
        lblDomicilio = new JLabel("Domicilio:");
        lblFechaAlta = new JLabel("Fecha Alta:");
        lblUsuario = new JLabel("Usuario:");
        lblClave = new JLabel("Clave:");

        txtID = new JTextField("", 3);
        txtNombre = new JTextField("", 10);
        txtApellido = new JTextField("", 10);
        txtDNI =new JTextField("", 10);
        txtDomicilio = new JTextField("", 20);
        txtFechaAlta = new JTextField("", 8);
        txtUsuario= new JTextField("", 8);
        txtClave = new JTextField("", 8);


        panelComponentes = new JPanel();
        panelComponentes.add(lblID);
        panelComponentes.add(txtID);
        panelComponentes.add(lblNombre);
        panelComponentes.add(txtNombre);
        panelComponentes.add(lblApellido);
        panelComponentes.add(txtApellido);
        panelComponentes.add(lblDNI);
        panelComponentes.add(txtDNI);
        panelComponentes.add(lblDomicilio);
        panelComponentes.add(txtDomicilio);
        panelComponentes.add(lblFechaAlta);
        panelComponentes.add(txtFechaAlta);
        panelComponentes.add(lblUsuario);
        panelComponentes.add(txtUsuario);
        panelComponentes.add(lblClave);
        panelComponentes.add(txtClave);


        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        panelBotonera = new JPanel();
        panelBotonera.add(btnGuardar);
        panelBotonera.add(btnCancelar);

        add(panelComponentes, BorderLayout.CENTER);
        add(panelBotonera, BorderLayout.SOUTH);

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManager.mostrarListadoPacientes(false);
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PacienteService pacienteService = new PacienteService();
                UsuarioService usuarioService = new UsuarioService();

                Paciente paciente = new Paciente();
                Usuario usuario = new Usuario();

                //Si la accion es una modificacion, le debo enviar el ID del paciente, de lo contrario va un 0
                if (accion == 'M'){
                    paciente.setId(Long.parseLong(txtID.getText()));

                    Date fechaAltaDate = null;
                    try {
                        fechaAltaDate = new SimpleDateFormat("dd/MM/yyyy").parse(txtFechaAlta.getText());
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    paciente.setFechaDeAlta(fechaAltaDate);
                }else{
                    paciente.setId(0);
                    usuario.setId(0);
                    Date fechaHoy = new Date();
                    paciente.setFechaDeAlta(fechaHoy);
                }

                paciente.setNombre(txtNombre.getText());
                paciente.setApellido(txtApellido.getText());
                paciente.setDni(txtDNI.getText());
                paciente.setDomicilio(txtDomicilio.getText());
                paciente.setDomicilio(txtDomicilio.getText());


                usuario.setUsuario(txtUsuario.getText());
                usuario.setPassword(txtClave.getText());
                usuario.setRol("P");
                paciente.setUsuario(usuario);

                pacienteService.guardar(paciente);
                usuarioService.guardar(usuario);

                panelManager.mostrarListadoPacientes(true);

            }
        });

    }

    public void cargarDatos(Paciente paciente){
        accion = 'M';
        lblID.setVisible(true);
        txtID.setVisible(true);
        txtID.setEnabled(false);
        txtID.setText(Long.toString(paciente.getId()));
        txtApellido.setText(paciente.getApellido());
        txtNombre.setText(paciente.getNombre());
        txtDNI.setText(paciente.getDni());
        txtDomicilio.setText(paciente.getDomicilio());

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        txtFechaAlta.setText(formatter.format(paciente.getFechaDeAlta()));
        txtFechaAlta.setEnabled(false);

        txtUsuario.setText(paciente.getUsuario().getUsuario());
        txtUsuario.setEnabled(false);
        txtClave.setText(paciente.getUsuario().getPassword());
        txtClave.setEnabled(false);
    }

    public void limpiarControles(){
        accion = 'A';
        txtID.setText("");
        lblID.setVisible(false);
        txtID.setVisible(false);
        txtApellido.setText("");
        txtNombre.setText("");
        txtDNI.setText("");
        txtDomicilio.setText("");
        txtFechaAlta.setText("");
        lblFechaAlta.setVisible(false);
        txtFechaAlta.setVisible(false);
        txtUsuario.setText("");
        txtClave.setText("");
    }


}
