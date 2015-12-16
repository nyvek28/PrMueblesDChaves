import java.util.ArrayList;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {

		(new Gestor()).inicializarPrograma();
		TreeMap datos;
		ArrayList<Integer> ids = new ArrayList<Integer>();
		for(int i = 6; i <= 9; i++){
			ids.add(i);
		}
		
//		datos = (new Gestor()).venderJuego(1, 26, 9);
//		if(datos != null){
//			System.out.println(datos.get("idJuego"));
//			System.out.println(datos.get("cliente"));
//			System.out.println(datos.get("distribuidor"));
//			System.out.println(datos.get("monto"));
//		}else{
//			System.out.println("Error");
//		}
		
		
		//System.out.println((new MultiDistribuidor()).buscar(1).calcularCostoJuego((new MultiJuego()).buscarid(Integer.parseInt((String) datos.get("id")))));
		
//		datos = (new Gestor()).registrarMueble(1, "Blanco", 23, 12, 45, 1, 32900, 12);
//		System.out.println(datos.get("id"));
//		datos = (new Gestor()).registrarMueble(1, "Verde", 56, 76, 123, 2, 100500, 1, 12);
//		System.out.println(datos.get("id"));
		
		
	}

}
