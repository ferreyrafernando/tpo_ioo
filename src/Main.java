import com.app.negocio.*;
import com.app.service.OdontologoService;
import com.app.service.PacienteService;
import com.app.service.TurnoService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Main {


    public static void main(String[] args) throws ParseException {
        System.out.println("DAO");
/*
        UsuarioService usservice = new UsuarioService();

        PacienteService pservice = new PacienteService();
        OdontologoService odservice = new OdontologoService();
        TurnoService tuservice = new TurnoService();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String dateInString1 = "22/11/2021 10:00:00";
        Date date1 = sdf.parse(dateInString1);

        String dateInString2 = "22/11/2021 10:30:00";
        Date date2 = sdf.parse(dateInString2);

        String dateInString3 = "22/11/2021 11:00:00";
        Date date3 = sdf.parse(dateInString3);

        String dateInString4 = "22/11/2021 11:30:00";
        Date date4 = sdf.parse(dateInString4);

        String dateInString12 = "23/11/2021 10:00:00";
        Date date12 = sdf.parse(dateInString12);

        String dateInString22 = "23/11/2021 10:30:00";
        Date date22 = sdf.parse(dateInString22);

        String dateInString32 = "23/11/2021 11:00:00";
        Date date32 = sdf.parse(dateInString32);

        String dateInString42 = "23/11/2021 11:30:00";
        Date date42 = sdf.parse(dateInString42);

        //System.out.println(date1);

        Odontologo od1 = new Odontologo();
        od1 = odservice.recuperar(1);

        Odontologo od2 = new Odontologo();
        od2 = odservice.recuperar(2);

        Odontologo od3 = new Odontologo();
        od3 = odservice.recuperar(3);

        Odontologo od4 = new Odontologo();
        od4 = odservice.recuperar(4);

        Odontologo od5 = new Odontologo();
        od4 = odservice.recuperar(5);


        Turno tur1 = new Turno();
        tur1.setId(0);
        tur1.setFechaHora(date1);
        tur1.setPaciente(null);
        tur1.setEstadoTurno("L");
        tur1.setOdontologo(od1);

        tuservice.guardar(tur1);

        Turno tur2 = new Turno();
        tur2.setId(0);
        tur2.setFechaHora(date2);
        tur2.setPaciente(null);
        tur2.setEstadoTurno("L");
        tur2.setOdontologo(od1);

        tuservice.guardar(tur2);

        Turno tur3 = new Turno();
        tur3.setId(0);
        tur3.setFechaHora(date3);
        tur3.setPaciente(null);
        tur3.setEstadoTurno("L");
        tur3.setOdontologo(od1);

        tuservice.guardar(tur3);

        Turno tur4 = new Turno();
        tur4.setId(0);
        tur4.setFechaHora(date4);
        tur4.setPaciente(null);
        tur4.setEstadoTurno("L");
        tur4.setOdontologo(od1);

        tuservice.guardar(tur4);

        Turno tur11 = new Turno();
        tur11.setId(0);
        tur11.setFechaHora(date12);
        tur11.setPaciente(null);
        tur11.setEstadoTurno("L");
        tur11.setOdontologo(od1);

        tuservice.guardar(tur11);

        Turno tur21 = new Turno();
        tur21.setId(0);
        tur21.setFechaHora(date22);
        tur21.setPaciente(null);
        tur21.setEstadoTurno("L");
        tur21.setOdontologo(od1);

        tuservice.guardar(tur21);

        Turno tur31 = new Turno();
        tur31.setId(0);
        tur31.setFechaHora(date32);
        tur31.setPaciente(null);
        tur31.setEstadoTurno("L");
        tur31.setOdontologo(od1);

        tuservice.guardar(tur31);

        Turno tur41 = new Turno();
        tur41.setId(0);
        tur41.setFechaHora(date42);
        tur41.setPaciente(null);
        tur41.setEstadoTurno("L");
        tur41.setOdontologo(od1);

        tuservice.guardar(tur41);

*/



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
        user2.setRol("P");
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
        user3.setRol("P");
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
        user4.setRol("P");
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
        user.setRol("O");
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
        user2.setRol("O");
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
        user3.setRol("O");
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
        user4.setRol("O");
        usuario4.setUsuario(user4);

        usservice.guardar(user4);
        serviceod.guardar(usuario4);
*/


        /*
        Usuario usuario = new Usuario();
        usuario.setId(0);
        usuario.setUsuario("admin");
        usuario.setPassword("1234");
        usuario.setRol("A");

        usservice.guardar(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.setId(0);
        usuario2.setUsuario("slovera");
        usuario2.setPassword("1234");
        usuario2.setRol("O");

        usservice.guardar(usuario2);

        Usuario usuario3 = new Usuario();
        usuario3.setId(0);
        usuario3.setUsuario("pperez");
        usuario3.setPassword("1234");
        usuario3.setRol("P");

        usservice.guardar(usuario3);

        ArrayList<Usuario> lista = usservice.listar();

        for(Usuario us:lista)
            System.out.println(us.getId() + " " + us.getUsuario());


         */


        LoginManager loginManager = new LoginManager();
        loginManager.armarLoginManager();
        loginManager.showFrame();
        loginManager.mostrarPantallaLogin();

    }



}
