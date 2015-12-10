import java.util.ArrayList;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {

		Gestor g = new Gestor();
		TreeMap v = new TreeMap();
		ArrayList<Distribuidor> a = new ArrayList();
		String msj;
		g.inicializarPrograma();
		//g.registrarMueble(idFabricante, pid, plinea, pcolor, ancho, alto, largo, pcategoria, precio);
		
		v=g.venderJuego(1, 1, 2, "18 noviembre 2015");
		System.out.println("id: "+v.get("id"));
		
		
		
		
	}

}
