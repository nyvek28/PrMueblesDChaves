import java.util.ArrayList;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {

		Gestor g = new Gestor();
		TreeMap v = new TreeMap();
		ArrayList a = new ArrayList();
		String msj;
		g.inicializarPrograma();
		
		v = g.RegistrarMontador(3,"Master", "Chief", 2345, "por ahi");

		System.out.println("Nombre: "+v.get("nombre")+" "+v.get("apellido")+"\n");
	
	}

}
