package com.app.ui;

import com.app.negocio.Odontologo;
import com.app.service.OdontologoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFormularioOdontologo extends JPanel {

    private PanelManager panelManager;
    private Character accion; //Para controlar las acciones de Alta (A) o Modificacion (M)

    //Componentes
    private JLabel lblID;
    private JTextField txtID;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblApellido;
    private JTextField txtApellido;
    private JLabel lblMatricula;
    private JTextField txtMatricula;
    private JPanel panelComponentes;

    //Botonera
    private JButton btnGuardar;
    private JButton btnCancelar;
    private JPanel panelBotonera;

    public void armarPanelFormularioOdontologo(PanelManager panelManager){

        this.panelManager = panelManager;
        setLayout(new BorderLayout());

        lblID = new JLabel("ID:");
        lblNombre = new JLabel("Nombre:");
        lblApellido = new JLabel("Apellido:");
        lblMatricula = new JLabel("Matricula:");
        txtID = new JTextField("", 3);
        txtNombre = new JTextField("", 10);
        txtApellido = new JTextField("", 10);
        txtMatricula =new JTextField("", 5);
        panelComponentes = new JPanel();
        panelComponentes.add(lblID);
        panelComponentes.add(txtID);
        panelComponentes.add(lblNombre);
        panelComponentes.add(txtNombre);
        panelComponentes.add(lblApellido);
        panelComponentes.add(txtApellido);
        panelComponentes.add(lblMatricula);
        panelComponentes.add(txtMatricula);

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
                panelManager.mostrarListadoOdontologo(false);
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OdontologoService odontologoService = new OdontologoService();
                Odontologo odontologo = new Odontologo();

                //Si la accion es una modificacion, le debo enviar el ID del odontolog, de lo contrario va un 0
                if (accion == 'M'){
                    odontologo.setId(Long.parseLong(txtID.getText()));
                }else{
                    odontologo.setId(0);
                }
                odontologo.setNombre(txtNombre.getText());
                odontologo.setApellido(txtApellido.getText());
                odontologo.setMatricula(Integer.parseInt(txtMatricula.getText()));

                odontologoService.guardar(odontologo);
                panelManager.mostrarListadoOdontologo(true);

            }
        });

    }

    public void cargarDatos(Odontologo odontologo){
        accion = 'M';
        lblID.setVisible(true);
        txtID.setVisible(true);
        txtID.setEnabled(false);
        txtID.setText(Long.toString(odontologo.getId()));
        txtApellido.setText(odontologo.getApellido());
        txtNombre.setText(odontologo.getNombre());
        txtMatricula.setText(Integer.toString(odontologo.getMatricula()));
    }

    public void limpiarControles(){
        accion = 'A';
        txtID.setText("");
        lblID.setVisible(false);
        txtID.setVisible(false);
        txtApellido.setText("");
        txtNombre.setText("");
        txtMatricula.setText("");
    }


}
