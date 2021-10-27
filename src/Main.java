import com.app.negocio.Odontologo;
import com.app.service.OdontologoService;
import com.app.negocio.Usuario;
import com.app.service.UsuarioService;
import com.app.ui.PanelFormularioOdontologo;
import com.app.ui.PanelListaOdontologo;
import com.app.ui.PanelManager;

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

        UsuarioService service = new UsuarioService();
/*
        Usuario usuario = new Usuario();
        usuario.setId(0);
        usuario.setUsuario("admin");
        usuario.setPassword("1234");

        service.guardar(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.setId(0);
        usuario2.setUsuario("facundo");
        usuario2.setPassword("1234");

        service.guardar(usuario2);



        ArrayList<Usuario> lista = service.listar();

        for(Usuario us:lista)
            System.out.println(us.getId() + " " + us.getUsuario());
*/
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

        PanelManager panelManager = new PanelManager();
        panelManager.armarManager();
        panelManager.showFrame();
        panelManager.mostrarPantallaLogin();
    }



}
