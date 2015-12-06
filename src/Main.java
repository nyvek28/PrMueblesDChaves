import java.util.ArrayList;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {

		Gestor g = new Gestor();
		TreeMap v = new TreeMap();
		ArrayList a = new ArrayList();
		String msj;
		g.inicializarPrograma();
		
		v = g.consultarMontador("kevin");

		System.out.println("Nombre: "+v.get("nombre")+" "+v.get("apellido")+"\n");
	}

}
