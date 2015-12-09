import java.util.ArrayList;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {

		Gestor g = new Gestor();
		TreeMap v = new TreeMap();
		ArrayList<Distribuidor> a = new ArrayList();
		String msj;
		g.inicializarPrograma();
		
		Fabricante f = (new MultiFabricante()).buscar(1);
		Mueble m = f.fabricarMueble("Rosado", 2, 4, 2, 0, 23);
		
	}

}
