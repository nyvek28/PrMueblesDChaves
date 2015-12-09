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
		
		v = g.registrarMueble(1, "Rojo", 50, 60, 70, 0, 27000);
		System.out.println("id: "+v.get("id")+"\n linea: "+v.get("linea")+"\n"
				+"color: "+v.get("color")+"\n"+"\n");
		
		
		
		
	}

}
