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
		
		//v=g.consultarVenta(1);
		//System.out.println("id: "+v.get("id"));
		
		(new VentanaRegistrarFabricante()).main(null);
		
		(new VentanaRegistrarFabricante()).main(null);
		
		(new VentanaRegistrarFabricante()).main(null);
		
		
		
	}

}
