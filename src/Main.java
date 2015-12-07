import java.util.ArrayList;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception {

		Gestor g = new Gestor();
		TreeMap v = new TreeMap();
		ArrayList<Distribuidor> a = new ArrayList();
		String msj;
		g.inicializarPrograma();
		
		v = g.registrarDistribuidor("Carrion", "San Jose", 22375454, 12);
		if(v != null){
			msj = "Nombre: " + v.get("nombre") + "\n"
				+ "Direccion: " + v.get("direccion") + "\n"
				+ "Porcentaje: " + v.get("porcentaje") + "\n";
		}else{
			msj = "No se pudo registrar al distribuidor";
		}
		
		System.out.println(msj);
		
		a = (new MultiDistribuidor()).listar();
		
		for(int i = 0; i < a.size(); i++){
			System.out.println("id: "+a.get(i).getId()+"\n");
		}
		
	}

}
