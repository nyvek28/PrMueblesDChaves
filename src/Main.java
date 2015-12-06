import java.util.ArrayList;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {

		Gestor g = new Gestor();
		TreeMap v = new TreeMap();
		ArrayList a = new ArrayList();
		String msj;
		g.inicializarPrograma();
		
		v = g.modificarFabricante(1, "Marco", "Odueuber", 3344, "San Jose", 3, 40);
		if(v != null){
			msj = "Nombre: "+v.get("nombre")+" "+v.get("apellido")+"\n"
				+ "Id: "+v.get("id")+"\n"
				+ "Annos de Experiencia: "+v.get("annosExp")+"\n";
		}else{
			msj = "No se encontro el fabricante que busca";
		}
		
		System.out.println(msj);
	}

}
