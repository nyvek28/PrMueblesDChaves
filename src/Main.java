import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {

		Gestor g = new Gestor();
		TreeMap v = new TreeMap();
		
		g.inicializarPrograma();
		v = g.RegistrarFabricante("Nicole", "Acosta", 22366336, "Del palo de mango 100 este", 
				2, 19);

		System.out.println(v.get("nombre"));
		
	}

}
