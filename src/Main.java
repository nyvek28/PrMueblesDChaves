import java.util.ArrayList;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {

		Gestor g = new Gestor();
		TreeMap v = new TreeMap();
		ArrayList<Distribuidor> a = new ArrayList();
		String msj;
		g.inicializarPrograma();
		
		v = g.registrarDistribuidor("Muebleria Gonzales", "Aqui", 45098878, 13);
		if(v != null){
			msj = "Id: " + v.get("id") + "\n"
				+ "Nombre: " + v.get("nombre") + "\n"
				+ "Direccion: " + v.get("direccion") + "\n";
		}else{
			msj = "No se registro el distribuidor";
		}
		
		System.out.println(msj);
		
	}

}
