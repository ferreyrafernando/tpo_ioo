import com.app.negocio.Odontologo;
import com.app.negocio.Paciente;
import com.app.negocio.Persona;
import com.app.service.OdontologoService;
import com.app.negocio.Usuario;
import com.app.service.PacienteService;
import com.app.service.UsuarioService;
import com.app.ui.LoginManager;
import com.app.ui.PanelFormularioOdontologo;
import com.app.ui.PanelListaOdontologo;
import com.app.ui.PanelManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Main {


    public static void main(String[] args) {
        System.out.println("DAO");

        UsuarioService usservice = new UsuarioService();

        PacienteService pservice = new PacienteService();



        /*
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        */
/*
        Date fechaHoy = new Date();

        Paciente usuario2 = new Paciente();
        Usuario user2 = new Usuario();

        usuario2.setId(0);
        usuario2.setDni("17567890");
        usuario2.setNombre("Paul");
        usuario2.setApellido("Barrett");
        usuario2.setDomicilio("Charlone 1978");
        usuario2.setFechaDeAlta(fechaHoy);
        user2.setId(0);
        user2.setUsuario("pbarrett");
        user2.setPassword("1234");
        user2.setRol('P');
        usuario2.setUsuario(user2);

        pservice.guardar(usuario2);
        usservice.guardar(user2);


        Paciente usuario3 = new Paciente();
        Usuario user3 = new Usuario();
        usuario3.setId(0);
        usuario3.setDni("12345678");
        usuario3.setNombre("Franco");
        usuario3.setApellido("Neville");
        usuario3.setDomicilio("De Los Fortines 260");
        usuario3.setFechaDeAlta(fechaHoy);
        user3.setId(0);
        user3.setUsuario("fneville");
        user3.setPassword("1234");
        user3.setRol('P');
        usuario3.setUsuario(user3);

        pservice.guardar(usuario3);
        usservice.guardar(user3);


        Paciente usuario4 = new Paciente();
        Usuario user4 = new Usuario();

        usuario4.setId(0);
        usuario4.setDni("40124367");
        usuario4.setNombre("Heather");
        usuario4.setApellido("Morgan");
        usuario4.setDomicilio("America 3092");
        usuario4.setFechaDeAlta(fechaHoy);
        user4.setId(0);
        user4.setUsuario("hmorgan");
        user4.setPassword("1234");
        user4.setRol('P');
        usuario4.setUsuario(user4);


        pservice.guardar(usuario4);
        usservice.guardar(user4);


 */


/*
        OdontologoService serviceod = new OdontologoService();

        Odontologo usuario = new Odontologo();
        Usuario user = new Usuario();

        usuario.setId(0);
        usuario.setMatricula(1234);
        usuario.setNombre("Cristian");
        usuario.setApellido("Martinez");

        user.setId(0);
        user.setUsuario("pagranatti");
        user.setPassword("1234");
        user.setRol('O');
        usuario.setUsuario(user);

        usservice.guardar(user);
        serviceod.guardar(usuario);

        Odontologo usuario2 = new Odontologo();
        Usuario user2 = new Usuario();
        Persona pers2 = new Persona();

        usuario2.setId(0);
        usuario2.setMatricula(4321);
        usuario2.setNombre("Patricia");
        usuario2.setApellido("Agranatti");

        user2.setId(0);
        user2.setUsuario("pagranatti");
        user2.setPassword("1234");
        user2.setRol('O');
        usuario2.setUsuario(user2);

        usservice.guardar(user2);
        serviceod.guardar(usuario2);

        Odontologo usuario3 = new Odontologo();
        Usuario user3 = new Usuario();

        usuario3.setId(0);
        usuario3.setMatricula(4561);
        usuario3.setNombre("Silvio");
        usuario3.setApellido("Lovera");

        user3.setId(0);
        user3.setUsuario("slovera");
        user3.setPassword("1234");
        user3.setRol('O');
        usuario3.setUsuario(user3);

        usservice.guardar(user3);
        serviceod.guardar(usuario3);

        Odontologo usuario4 = new Odontologo();
        Usuario user4 = new Usuario();

        usuario4.setId(0);
        usuario4.setMatricula(7894);
        usuario4.setNombre("Romina");
        usuario4.setApellido("Aromando");

        user4.setId(0);
        user4.setUsuario("raromando");
        user4.setPassword("1234");
        user4.setRol('O');
        usuario4.setUsuario(user4);

        usservice.guardar(user4);
        serviceod.guardar(usuario4);

*/



/*
        Usuario usuario = new Usuario();
        usuario.setId(0);
        usuario.setUsuario("admin");
        usuario.setPassword("1234");
        usuario.setRol('A');

        usservice.guardar(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.setId(0);
        usuario2.setUsuario("slovera");
        usuario2.setPassword("1234");
        usuario.setRol('O');

        usservice.guardar(usuario2);



        ArrayList<Usuario> lista = service.listar();

        for(Usuario us:lista)
            System.out.println(us.getId() + " " + us.getUsuario());
*/


        LoginManager loginManager = new LoginManager();
        loginManager.armarLoginManager();
        loginManager.showFrame();
        loginManager.mostrarPantallaLogin();

    }



}
