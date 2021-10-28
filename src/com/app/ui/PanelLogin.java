package com.app.ui;

import com.app.negocio.Usuario;
import com.app.service.UsuarioService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class PanelLogin extends JPanel implements ActionListener {

    private PanelManager panelManager;
    private JPanel principal;
    private JPanel iconoTitulo;
    private JPanel subFormulario;
    private JPanel panelnorte;
    private JLabel titulo;
    private JLabel subtitulo;
    private JPanel titulos;
    private JPanel panelsur;
    private JPanel usuario;
    private JLabel usrtxt;
    private JPanel contraseña;
    private JLabel contratxt;
    private JButton logeo;
    private JTextField formulariousuario;
    private JPasswordField formulariocontraseña;
    private JPanel logeoYMensaje;
    private JLabel mensaje;

    public void armarPanelLogin(PanelManager panelManager){
        //Seteamos el panel manager y el layout
        this.panelManager=panelManager;
        setLayout(new BorderLayout());

        //Armamos la pantalla principal
        principal=new JPanel();
        principal.setLayout(new BorderLayout());

        //Creamos las 2 sub pantallas
        iconoTitulo=new JPanel();
        subFormulario=new JPanel();

        //Una va arriba, la otra abajo
        principal.add(iconoTitulo,BorderLayout.NORTH);
        principal.add(subFormulario,BorderLayout.SOUTH);

        //Arrancamos armando el panel para la seccion norte
        panelnorte=new JPanel();
        panelnorte.setLayout(new BorderLayout());


        //Aca vamos a poner el icono, subtitulo y el titulo, por lo que los creamos
        titulo=new JLabel("Login", SwingConstants.CENTER);
        titulo.setFont(new Font("Raleway",Font.BOLD,60));
        subtitulo=new JLabel("Bienvenido al sistema de turnos");
        subtitulo.setFont(new Font("Raleway",Font.PLAIN,20));

        titulos=new JPanel();
        titulos.setLayout(new BorderLayout());
        titulos.add(titulo,BorderLayout.NORTH);
        titulos.add(subtitulo,BorderLayout.SOUTH);

        try {
            BufferedImage imagen=ImageIO.read(new File("./resources/icono.png"));
            JLabel icono= new JLabel(new ImageIcon(imagen));
            //Hecho esto, agregamos las cosas al panel y el panel al panel principal
            panelnorte.add(icono,BorderLayout.NORTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        panelnorte.add(titulos,BorderLayout.CENTER);
        iconoTitulo.add(panelnorte,BorderLayout.NORTH);

        //Arrancamos con el panel sur para el formulario

        panelsur=new JPanel();
        panelsur.setLayout(new BorderLayout());


        //Adentro va a tener tres partes, primero el usuario y el campo con la foto
        usuario=new JPanel();
        usuario.setLayout(new BorderLayout());

        usrtxt=new JLabel("Usuario:");
        usrtxt.setFont(new Font("Raleway",Font.PLAIN,20));
        usuario.add(usrtxt,BorderLayout.NORTH);

        try {
            BufferedImage imagenusr=ImageIO.read(new File("./resources/iconuser.jpg"));
            JLabel iconousr=new JLabel(new ImageIcon(imagenusr));
            usuario.add(iconousr,BorderLayout.WEST);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        formulariousuario=new JTextField();
        formulariousuario.addActionListener(this);
        usuario.add(formulariousuario,BorderLayout.CENTER);

        //ahora vamos con el de la contraseña
        contraseña=new JPanel();
        contraseña.setLayout(new BorderLayout());

        contratxt=new JLabel("Contraseña");
        contratxt.setFont(new Font("Raleway",Font.PLAIN,20));
        contraseña.add(contratxt,BorderLayout.NORTH);

        try {
            BufferedImage imagencontra=ImageIO.read(new File("./resources/iconopass.jpg"));
            JLabel iconocontra=new JLabel(new ImageIcon(imagencontra));
            contraseña.add(iconocontra,BorderLayout.WEST);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        formulariocontraseña=new JPasswordField();
        formulariocontraseña.addActionListener(this);

        contraseña.add(formulariocontraseña,BorderLayout.CENTER);

        //Armamos el boton para logear
        logeo=new JButton("Login");
        logeo.setBackground(new Color(78,200,207));
        logeo.setOpaque(true);
        logeo.addActionListener(this);

        //Hacemos el espacio para el mensaje de error
        mensaje=new JLabel("");
        mensaje.setFont(new Font("Raleway",Font.PLAIN,12));

        //Un ultimo panel para mostrar el mensaje de error y el boton
        logeoYMensaje=new JPanel();
        logeoYMensaje.setLayout(new BorderLayout());
        logeoYMensaje.add(logeo,BorderLayout.SOUTH);
        logeoYMensaje.add(mensaje,BorderLayout.NORTH);


        //Finalmente añadimos todos al panel sur y el sur al principal
        panelsur.add(usuario,BorderLayout.NORTH);
        panelsur.add(contraseña,BorderLayout.CENTER);
        panelsur.add(logeoYMensaje,BorderLayout.SOUTH);


        principal.add(panelsur,BorderLayout.SOUTH);

        //Añadimos la pantalla al principal para terminar y la hacemos visible
        add(principal);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        String txtUsuario=formulariousuario.getText();
        String txtPassword=formulariocontraseña.getText();
        System.out.println("Usuario: "+txtUsuario+" Contraseña: "+txtPassword);

        UsuarioService userService = new UsuarioService();

        Usuario usuario = new Usuario();
        usuario = userService.recuperar(txtUsuario);
        System.out.println(usuario);
        if (usuario != null){
            if (usuario.getPassword().equals(txtPassword)){
                System.out.println("Acceso concedido");
                mensaje.setForeground(Color.black);
                mensaje.setText("Acceso concedido");
                // Redirect to Menu Principal
               panelManager.mostrarPantallaMenuPrincipal();
            }else{
                System.out.println("Acceso denegado");
                mensaje.setForeground(Color.red);
                mensaje.setText("Usuario y/o contraseña incorrectos");
            }
        }else{
            System.out.println("Acceso denegado");
            mensaje.setForeground(Color.red);
            mensaje.setText("Usuario Inexistente");
        }
        /*
        if(usuario.equals("Pepe")&&contraseña.equals("contraseña")) {
            System.out.println("Acceso concedido");
            mensaje.setForeground(Color.black);
            mensaje.setText("Acceso concedido");
        }
        else {
            System.out.println("Acceso denegado");
            mensaje.setForeground(Color.red);
            mensaje.setText("Usuario y/o contraseña incorrectos");
        }
        */
    }

}