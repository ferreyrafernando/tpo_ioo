import com.app.ActionListenerBotonAceptar;
import com.app.negocio.Odontologo;
import com.app.service.OdontologoService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("DAO");

        OdontologoService service = new OdontologoService();
  /*
        Odontologo odontologo = new Odontologo();
        odontologo.setId(0);
        odontologo.setMatricula(4321);

        service.guardar(odontologo);

        Odontologo odontologo2 = new Odontologo();
        odontologo2.setId(0);
        odontologo2.setMatricula(1234);

        service.guardar(odontologo2);
*/


        ArrayList<Odontologo> lista = service.listar();

        for(Odontologo od:lista)
            System.out.println(od.getId() + " " + od.getMatricula());

        service.eliminar(2);

        ArrayList<Odontologo> lista2 = service.listar();

        for(Odontologo od:lista2)
            System.out.println(od.getId() + " " + od.getMatricula());

/*
        JFrame frame = new JFrame();
        frame.setBounds(200,200,500,500);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        frame.add(panel);
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);

        JButton botonAceptar = new JButton( "Aceptar");
        JButton botonCancelar = new JButton( "Cancelar");
        JButton botonEliminar = new JButton( "Eliminar");
        panel.add(botonAceptar, BorderLayout.CENTER);
        panel.add(botonCancelar, BorderLayout.SOUTH);
        panel.add(botonEliminar, BorderLayout.NORTH);

        ActionListenerBotonAceptar actionListenerBotonAceptar = new ActionListenerBotonAceptar();
        botonAceptar.addActionListener(actionListenerBotonAceptar);

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click sobre el boton Eliminar");
            }
        });

        JTextField txtNombre = new JTextField(5);
        txtNombre.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        panel.add(txtNombre, BorderLayout.EAST);

     */
    }



}
