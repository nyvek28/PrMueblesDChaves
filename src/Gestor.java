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
	public TreeMap<String, String> registrarMueble(int idFabricante,int pid,int plinea, String pcolor, double ancho, double alto, double largo, String pcategoria)throws Exception{
		Fabricante f;
		f=(new MultiFabricante()).buscar(idFabricante);
		Mueble mueble=f.fabricarMueble(pid, plinea, pcolor, ancho, alto, largo, pcategoria);
		TreeMap<String,String> datosMueble = new TreeMap<String,String>();
		datosMueble.put("ID", String.valueOf(mueble.getId()));
		datosMueble.put("Linea", String.valueOf(mueble.getLinea()));
		datosMueble.put("Color", String.valueOf(mueble.getColor()));
		datosMueble.put("Dimensiones", String.valueOf(mueble.getDimensiones()));
		datosMueble.put("Categoria", String.valueOf(mueble.getCategoria()));
		
		return datosMueble;
		
	}
	public TreeMap<String, String> consultarMueble(int idMueble)throws Exception{
		Mueble mueble=Empresa.consultarMueble(idMueble);
		TreeMap<String,String> datosMueble = new TreeMap<String,String>();
		datosMueble.put("ID", String.valueOf(mueble.getId()));
		datosMueble.put("Linea", String.valueOf(mueble.getLinea()));
		datosMueble.put("Color", String.valueOf(mueble.getColor()));
		datosMueble.put("Dimensiones", String.valueOf(mueble.getDimensiones()));
		datosMueble.put("Categoria", String.valueOf(mueble.getCategoria()));
		
		return datosMueble;
		
	}
	public TreeMap<String, String> consultarJuego(int idJuego)throws Exception{
		Juego juego=Empresa.consultarJuego(idJuego);
		TreeMap<String,String> datosJuego = new TreeMap<String,String>();
		datosJuego.put("ID", String.valueOf(juego.getId()));
		datosJuego.put("Montador", String.valueOf(juego.getIdMontador()));
		
		
		
		return datosJuego;
	}
	public TreeMap<String, String> registrarJuego(int idMontador, int id)throws Exception{
		Juego j=Empresa.crearJuego(idMontador, id);
		
		TreeMap<String,String> datosJuego = new TreeMap<String,String>();
		datosJuego.put("ID", String.valueOf(j.getId()));
		datosJuego.put("Montador", String.valueOf(j.getIdMontador()));
		
		
		return datosJuego;
		
	}
}
