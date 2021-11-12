package com.app.ui;

import sun.font.EAttribute;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class PanelMenuPrincipal extends JPanel {

    private PanelManager panelManager;
    private JPanel panelTitulo;
    private JLabel titulo;
    private Font titu;
    private Map atributos;
    private JPanel panelBotones;
    private GridBagConstraints c;
    private Font fontBotones;
    private Color colorBotones;
    private JPanel panelBotonTurnos;
    private JButton botonTurnos;
    private JPanel panelBotonPacientes;
    private JButton botonPacientes;
    private JPanel panelBotonOdontologos;
    private JButton botonOdontologos;
    private JPanel panelBotonSalir;
    private JButton botonSalir;
    private Boolean userEsPaciente;


    public void vistaPaciente(Boolean vistaPaciente){
        this.userEsPaciente = vistaPaciente;
    }

    public void armarPanelMenuPrincipal(PanelManager panelManager, Character usarioRol){

        //Primero seteamos el manager y layout
        this.panelManager=panelManager;
        setLayout(new BorderLayout());

        /*Vamos a divir el frame en 3 paneles, uno para el titulo
        otro para las fotos y botones y el ultimo para el boton salir

        Arrancamos haciendo el panel para el titulo y el titulo*/

        panelTitulo=new JPanel();
        titulo=new JLabel("Menú principal");
        titu=new Font("Raleway",Font.PLAIN,48);
        atributos=titu.getAttributes();
        atributos.put(TextAttribute.UNDERLINE,TextAttribute.UNDERLINE_ON);
        titulo.setFont(titu.deriveFont(atributos));

        //Finalmente, agregamos ambas cosas
        panelTitulo.add(titulo);
        add(panelTitulo,BorderLayout.NORTH);

        //Ahora armamos el panel de los botones que tendra 3 paneles, uno para cada boton

        panelBotones=new JPanel();
        panelBotones.setLayout(new GridBagLayout());
        c=new GridBagConstraints();
        c.insets=new Insets(20,20,20,20);

        fontBotones=new Font("Raleway",Font.PLAIN,20);
        colorBotones=new Color(78,200,207);

        //Armamos el panel, boton e imagen de Turnos
        panelBotonTurnos=new JPanel();
        panelBotonTurnos.setLayout(new BorderLayout());

        botonTurnos=new JButton("Turnos");
        botonTurnos.setBackground(colorBotones);
        botonTurnos.setFont(fontBotones);
        botonTurnos.setOpaque(true);
        botonTurnos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se apretó el botón de Turnos");
                if (usarioRol != 'P'){
                    panelManager.mostrarListadoTurnos();
                }else {
                    panelManager.mostrarPedidoTurno();
                }

            }
        });


        try{
            BufferedImage imagenTurnos= ImageIO.read(new File("./resources/turnos.png"));
            JLabel iconoTurnos=new JLabel(new ImageIcon(imagenTurnos));
            panelBotonTurnos.add(iconoTurnos,BorderLayout.NORTH);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        panelBotonTurnos.add(botonTurnos,BorderLayout.SOUTH);
        panelBotones.add(panelBotonTurnos,c);

        if (usarioRol != 'P'){

            //Ahora repetimos para el de pacientes
            panelBotonPacientes=new JPanel();
            panelBotonPacientes.setLayout(new BorderLayout());

            botonPacientes=new JButton("Pacientes");
            botonPacientes.setBackground(colorBotones);
            botonPacientes.setFont(fontBotones);
            botonPacientes.setOpaque(true);
            botonPacientes.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Se apretó el botón de Pacientes");
                    panelManager.mostrarListadoPacientes(false);
                }
            });
            panelBotonPacientes.add(botonPacientes,BorderLayout.SOUTH);

            try{
                BufferedImage imagenPacientes= ImageIO.read(new File("./resources/pacientes.png"));
                JLabel iconoPacientes=new JLabel(new ImageIcon(imagenPacientes));
                panelBotonPacientes.add(iconoPacientes,BorderLayout.NORTH);
            }
            catch(IOException e){
                e.printStackTrace();
            }

            //Finalmente agregamos el de odontologos
            panelBotonOdontologos=new JPanel();
            panelBotonOdontologos.setLayout(new BorderLayout());

            botonOdontologos=new JButton("Odontologos");
            botonOdontologos.setBackground(colorBotones);
            botonOdontologos.setFont(fontBotones);
            botonOdontologos.setOpaque(true);
            botonOdontologos.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Se apretó el botón de Odontologos");
                    panelManager.mostrarListadoOdontologo(false);
                }
            });

            panelBotonOdontologos.add(botonOdontologos,BorderLayout.SOUTH);

            try{
                BufferedImage imagenOdontologos= ImageIO.read(new File("./resources/odontologos.png"));
                JLabel iconoOdontologos=new JLabel(new ImageIcon(imagenOdontologos));
                panelBotonOdontologos.add(iconoOdontologos,BorderLayout.NORTH);
            }
            catch(IOException e){
                e.printStackTrace();
            }

            //Finalmente, agregamos los 3 paneles y este al principal

            panelBotones.add(panelBotonPacientes,c);
            panelBotones.add(panelBotonOdontologos,c);
        }
        add(panelBotones,BorderLayout.CENTER);

        //Por ultimo, armamos el boton de Salir para cerrar sesión y volver al menú

        panelBotonSalir=new JPanel();
        panelBotonSalir.setLayout(new FlowLayout(FlowLayout.RIGHT));

        botonSalir=new JButton("Salir");
        botonSalir.setBackground(colorBotones);
        botonSalir.setFont(new Font("Raleway",Font.PLAIN,20));
        botonSalir.setOpaque(true);
        botonSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Se apretó el botón para salir");
                System.exit(0);
                //panelManager.mostrarPantallaLogin();
            }
        });

        //Y lo agregamos para terminar
        panelBotonSalir.add(botonSalir);
        add(panelBotonSalir,BorderLayout.SOUTH);


    }

}
