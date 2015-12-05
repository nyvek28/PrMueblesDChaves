import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {

		Gestor g = new Gestor();
		TreeMap v = new TreeMap();
		
		v = g.RegistrarFabricante("Manuel", "Ortunio", 22366336, "Del palo de mango 100 este", 
				2, 19);

		System.out.println(v.get("Nombre"));
		
	}

}
