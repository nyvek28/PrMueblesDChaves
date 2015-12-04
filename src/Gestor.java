import java.util.TreeMap;

public class Gestor {

	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para registrar un Fabricante
	Version: v.1.0
	Fecha: Dic 4, 2015
	Ediciones:

	*/
	public TreeMap<String,String> RegistrarFabricante(String pNombre, String pApellido, int pTelefono, String pDireccion,
			int linea, int annos){
		
		TreeMap<String,String> datosFabricante = new TreeMap<String,String>();
		Fabricante f;
		
		f = Empresa.registrarFabricante(pNombre, pApellido, pTelefono, pDireccion, linea, annos);
		datosFabricante.put("id", String.valueOf(f.getId()));
		datosFabricante.put("nombre", f.getNombre());
		datosFabricante.put("apellido", f.getApellido());
		datosFabricante.put("telefono", String.valueOf(f.getTelefono()));
		datosFabricante.put("direccion", f.getDireccion());
		datosFabricante.put("linea", String.valueOf(f.getLinea()));
		datosFabricante.put("annosExp", String.valueOf(f.getAnnosExp()));
		
		return datosFabricante;
		
	}
	
}
