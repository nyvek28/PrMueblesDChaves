import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {

		Gestor g = new Gestor();
		TreeMap v = new TreeMap();
		
		g.inicializarPrograma();
		v = g.RegistrarFabricante("Emilio", "Garro", 666, "Los yoses", 
				2, 20);

		System.out.println("Nombre: "+v.get("nombre")+" "+v.get("apellido")+"\n"
						+"Identificacion: "+v.get("id")+"\n"
						+"Anos de experiencia: "+v.get("annosExp")+"\n");
		
	}

}
