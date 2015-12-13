import java.util.ArrayList;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {

		Gestor g = new Gestor();
		TreeMap v = new TreeMap();
		ArrayList<Distribuidor> a = new ArrayList();
		String msj;
		g.inicializarPrograma();
		int[] listaMuebles= new int[4];
				listaMuebles[0]=1;
				listaMuebles[1]=2;
				listaMuebles[2]=3;
				listaMuebles[3]=4;
		System.out.println(g.armarJuego(listaMuebles, 1));
		
		
		
	}

}
