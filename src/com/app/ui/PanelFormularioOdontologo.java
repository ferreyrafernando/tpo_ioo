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

        lblID = new JLabel("ID:",SwingConstants.CENTER);
        lblNombre = new JLabel("Nombre:",SwingConstants.CENTER);
        lblApellido = new JLabel("Apellido:",SwingConstants.CENTER);
        lblMatricula = new JLabel("Matricula:",SwingConstants.CENTER);
        txtID = new JTextField("", 3);
        txtNombre = new JTextField("", 10);
        txtApellido = new JTextField("", 10);
        txtMatricula =new JTextField("", 5);
        Font a=new Font("Raleway",Font.PLAIN,18);




        JLabel titulo=new JLabel("Ingrese los datos",SwingConstants.CENTER);

        titulo.setFont(new Font("Raleway",Font.BOLD,26));


        lblID.setFont(a);
        lblNombre.setFont(a);
        lblApellido.setFont(a);
        lblMatricula.setFont(a);

        panelComponentes = new JPanel();
        panelComponentes.setLayout(new GridBagLayout());

        GridBagConstraints textos=new GridBagConstraints();
        GridBagConstraints formularios=new GridBagConstraints();
        formularios.fill = GridBagConstraints.HORIZONTAL;
        formularios.ipady = 40;
        formularios.weightx = 2;
        formularios.gridx=1;
        formularios.gridwidth = 3;
        formularios.gridheight=2;
        textos.fill = GridBagConstraints.HORIZONTAL;
        textos.weightx = 0.5;
        textos.gridx=0;
        textos.gridheight=2;
        textos.gridwidth=1;

        panelComponentes.add(lblID,textos);
        panelComponentes.add(txtID,formularios);
        panelComponentes.add(lblNombre,textos);
        panelComponentes.add(txtNombre,formularios);
        panelComponentes.add(lblApellido,textos);
        panelComponentes.add(txtApellido,formularios);
        panelComponentes.add(lblMatricula,textos);
        panelComponentes.add(txtMatricula,formularios);


        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        panelBotonera = new JPanel();
        panelBotonera.add(btnGuardar);
        panelBotonera.add(btnCancelar);

        add(panelComponentes, BorderLayout.CENTER);
        add(panelBotonera, BorderLayout.SOUTH);
        add(titulo,BorderLayout.NORTH);
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
