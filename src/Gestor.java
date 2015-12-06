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
		
		f = Empresa.consultarFabricante(id);
		if(f != null){
			datos = this.fabricanteToTreeMap(f);
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que busca un fabricante por su id
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	public TreeMap<String, String> modificarFabricante(int id, String nombre, String apellido, int telefono, String direccion,
			int linea, int annos) throws SQLException, Exception{
		
		TreeMap<String, String> datos;
		Fabricante f;
		
		f = Empresa.modificarFabricante(id, nombre, apellido, telefono, direccion, linea, annos);
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
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para consultar un Fabricante por su id
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	public TreeMap<String, String> eliminarFabricante(int id) throws SQLException, Exception{
		
		TreeMap<String, String> datos;
		Fabricante f;
		
		f = Empresa.eliminarFabricante(id);
		if(f != null){
			datos = this.fabricanteToTreeMap(f);
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo para registrar un Montador
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	public TreeMap<String,String> RegistrarMontador(int id, String pNombre, String pApellido, int pTelefono, String pDireccion){
		
		TreeMap<String,String> datos;
		Montador m;
		
		m = Empresa.registrarMontador(id, pNombre, pApellido, pTelefono, pDireccion);
		datos = this.montadorToTreeMap(m);
		
		return datos;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo para consultar un Montador por su id
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	public TreeMap<String, String> consultarMontador(int id) throws SQLException, Exception{
		
		TreeMap<String, String> datos;
		Montador m;
		
		m = (new MultiMontador()).buscar(id);
		if(m != null){
			datos = this.montadorToTreeMap(m);
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo para consultar un Montador por su nombre
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	public TreeMap<String, String> consultarMontador(String nombre) throws SQLException, Exception{
		
		TreeMap<String, String> datos;
		Montador m;
		
		m = (new MultiMontador()).buscar(nombre);
		if(m != null){
			datos = this.montadorToTreeMap(m);
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo que busca un montador por su id
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public TreeMap<String, String> modificarMontador(int id, String nombre, String apellido, int telefono, String direccion) throws SQLException, Exception{
		
		TreeMap<String, String> datos;
		Montador m;
		
		m = Empresa.modificarMontador(id, nombre, apellido, telefono, direccion);
		if(m != null){
			datos = this.montadorToTreeMap(m);
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo que convierte un montador en un treemap
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	private TreeMap<String, String> montadorToTreeMap(Montador m){
		
		TreeMap<String,String> datos = new TreeMap<String,String>();
		
		datos.put("id", String.valueOf(m.getId()));
		datos.put("nombre", m.getNombre());
		datos.put("apellido", m.getApellido());
		datos.put("telefono", String.valueOf(m.getTelefono()));
		datos.put("direccion", m.getDireccion());
		
		return datos;
		
	}
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que convierte un mueble en un treemap
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	private TreeMap<String, String> muebleToTreeMap(Mueble mueble){
		
		TreeMap<String,String> datosMueble = new TreeMap<String,String>();
		datosMueble.put("ID", String.valueOf(mueble.getId()));
		datosMueble.put("Linea", String.valueOf(mueble.getLinea()));
		datosMueble.put("Color", String.valueOf(mueble.getColor()));
		datosMueble.put("Dimensiones", String.valueOf(mueble.getDimensiones()));
		datosMueble.put("Categoria", String.valueOf(mueble.getCategoria()));
		
		return datosMueble;
	}
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que registra un mueble
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	
	public TreeMap<String,String>  registrarMueble(int idFabricante,int pid,int plinea, String pcolor, double ancho, double alto, double largo, String pcategoria)throws Exception{
		Fabricante f;
		f=(new MultiFabricante()).buscar(idFabricante);
		Mueble mueble=f.fabricarMueble(pid, plinea, pcolor, ancho, alto, largo, pcategoria);
		TreeMap<String, String> datos;
		datos=this.muebleToTreeMap(mueble);
		return datos;
		
		
	}
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que consulta un mueble
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	public TreeMap<String, String> consultarMueble(int idMueble)throws Exception{
		Mueble mueble=Empresa.consultarMueble(idMueble);
		TreeMap<String,String> datosMueble = new TreeMap<String,String>();
		datosMueble=this.muebleToTreeMap(mueble);
		
		
		return datosMueble;
		
	}
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que convierte info de Juego en TreeMap
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
private TreeMap<String, String> juegoToTreeMap(Juego juego)throws Exception{
		
		TreeMap<String,String> datosJuego = new TreeMap<String,String>();
		
		String info="";
		ArrayList<Mueble> listaMuebles=(new MultiJuego().buscarMuebleddeJuego(juego.getId()));
		for(int i=0;i<listaMuebles.size();i++){
			Mueble m=listaMuebles.get(i);
			info+="\n Mueble"+i+": "+ m.toString();
				
		}
		datosJuego.put("ID", String.valueOf(juego.getId()));
		datosJuego.put("Montador", String.valueOf(juego.getIdMontador()));
		datosJuego.put("Informacion Muebles", info);
		
		return datosJuego;
	}
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que consulta un Juego
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	 */


	public TreeMap<String, String> consultarJuego(int idJuego)throws Exception{
		Juego juego=Empresa.consultarJuego(idJuego);
		TreeMap<String,String> datosJuego = new TreeMap<String,String>();
		datosJuego=this.juegoToTreeMap(juego);
		
		return datosJuego;
	}
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que registra un Juego
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:
	 */
	public TreeMap<String, String> registrarJuego(int idMontador, int id)throws Exception{
		Juego j=Empresa.crearJuego(idMontador, id);
		
		TreeMap<String,String> datosJuego = new TreeMap<String,String>();
		datosJuego.put("ID", String.valueOf(j.getId()));
		datosJuego.put("Montador", String.valueOf(j.getIdMontador()));
		
		return datosJuego;
		
	}
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que modifica un juego a gusto del usuario
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:
	 */
	public void modificarJuego(){
		
	}
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que elimina
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:
	 */
	public void eliminarJuego(int idJuego)throws Exception{
		Empresa.eliminarJuego(idJuego);
		
	}
}
