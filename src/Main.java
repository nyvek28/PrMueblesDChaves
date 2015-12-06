import java.util.ArrayList;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {

		Gestor g = new Gestor();
		TreeMap v = new TreeMap();
		ArrayList a = new ArrayList();
		String msj;
		g.inicializarPrograma();
		
		v = g.RegistrarCliente(3,"Master", "Chief", 2345, "por ahi", "Ingeniero de software", 22323);

		System.out.println("Nombre: "+v.get("nombre")+" "+v.get("apellido")+"\n" + "Trabajo: "+v.get("trabajo") + "\n");
		
	v = g.consultarCliente(3);

	System.out.println("Nombre: "+v.get("nombre")+" "+v.get("apellido")+"\n" + "Trabajo: "+v.get("trabajo") + "\n" + "Telefono Trabajo: "+v.get("telTrabajo")+"\n");

	}

}
