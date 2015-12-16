import java.util.ArrayList;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {

		(new Gestor()).inicializarPrograma();
		TreeMap datos;
		ArrayList<Integer> ids = new ArrayList<Integer>();
		for(int i = 1; i <= 5; i++){
			ids.add(i);
		}
		
		datos = (new Gestor()).armarJuego(ids, 666);
		if(datos != null){
			System.out.println(datos.get("info"));
		}else{
			System.out.println("Error");
		}
		
		
		
	}

}
