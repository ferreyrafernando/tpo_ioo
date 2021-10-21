import com.app.odontologo.Odontologo;
import com.app.odontologo.OdontologoService;

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




    }

}
