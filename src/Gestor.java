import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public class Gestor {

	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que inicializa los contadores de las clases
	Version: v.1.0
	Fecha: Dic 4, 2015
	Ediciones:

	*/
	public void inicializarPrograma() throws Exception{
		
		ArrayList<Fabricante> fabricantes;
		
		fabricantes = (new MultiFabricante()).listar();
		if(fabricantes != null){
			
			Fabricante.setConsecutivo(fabricantes.get(fabricantes.size()-1).getId());
			
		}
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para registrar un Fabricante
	Version: v.1.0
	Fecha: Dic 4, 2015
	Ediciones:

	*/
	public TreeMap<String,String> RegistrarFabricante(String pNombre, String pApellido, int pTelefono, String pDireccion,
			int linea, int annos){
		
		TreeMap<String,String> datos;
		Fabricante f;
		
		f = Empresa.registrarFabricante(pNombre, pApellido, pTelefono, pDireccion, linea, annos);
		datos = this.fabricanteToTreeMap(f);
		
		return datos;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para consultar un Fabricante por su id
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	public TreeMap<String, String> consultarFabricante(int id) throws SQLException, Exception{
		
		TreeMap<String, String> datos;
		Fabricante f;
		
		f = (new MultiFabricante()).buscar(id);
		if(f != null){
			datos = this.fabricanteToTreeMap(f);
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que convierte un fabricante en un treemap
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	private TreeMap<String, String> fabricanteToTreeMap(Fabricante f){
		
		TreeMap<String,String> datos = new TreeMap<String,String>();
		
		datos.put("id", String.valueOf(f.getId()));
		datos.put("nombre", f.getNombre());
		datos.put("apellido", f.getApellido());
		datos.put("telefono", String.valueOf(f.getTelefono()));
		datos.put("direccion", f.getDireccion());
		datos.put("linea", String.valueOf(f.getLinea()));
		datos.put("annosExp", String.valueOf(f.getAnnosExp()));
		
		return datos;
		
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
