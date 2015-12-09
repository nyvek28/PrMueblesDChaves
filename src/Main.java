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
		TreeMap<String, String>q=g.registrarMueble(1, "Rojo", 50, 60, 70, 2, 27000);
		System.out.println("id: "+v.get(0)+"\n linea: "+v.get(1)+"\n"
				+"color: "+v.get(2)+"\n"
				+"dimensiones:"   
				+v.get(3)
				+v.get(4)+"\n");
		
		
		
		
	}

}
