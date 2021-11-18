package com.app.ui;

import com.app.negocio.Odontologo;
import com.app.service.OdontologoService;
import sun.invoke.empty.Empty;

import javax.swing.*;
import javax.swing.border.Border;
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

        lblID = new JLabel("ID:",SwingConstants.LEFT);
        lblNombre = new JLabel("Nombre:",SwingConstants.LEFT);
        lblApellido = new JLabel("Apellido:",SwingConstants.LEFT);
        lblMatricula = new JLabel("Matricula:",SwingConstants.LEFT);
        txtID = new JTextField("", 3);
        txtNombre = new JTextField("", 10);
        txtApellido = new JTextField("", 10);
        txtMatricula =new JTextField("", 5);
        Font a=new Font("Raleway",Font.PLAIN,18);


        lblID.setFont(a);
        lblNombre.setFont(a);
        lblApellido.setFont(a);
        lblMatricula.setFont(a);

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
        btnCancelar.setFont(new Font("Raleway",Font.PLAIN,15));
        btnGuardar.setFont(new Font("Raleway",Font.PLAIN,15));

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
