import java.sql.SQLException;

public class Empresa {

	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para que la empresa registre un Fabricante
	Version: v.1.0
	Fecha: Dic 4, 2015
	Ediciones:

	*/
	public static Fabricante registrarFabricante(String pNombre, String pApellido, int pTelefono, String pDireccion,
			int linea, int annos){
		
		Fabricante f;
		
		f = (new MultiFabricante()).crear(pNombre, pApellido, pTelefono, pDireccion, linea, annos);
		
		return f;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que busca un fabricante por su id
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	public static Fabricante consultarFabricante(int id) throws SQLException, Exception{
		
		Fabricante f;
		
		f = (new MultiFabricante()).buscar(id);
		
		return f;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que modifica un fabricante
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	public static Fabricante modificarFabricante(int id, String nombre, String apellido, int telefono, String direccion,
			int linea, int annos) throws SQLException, Exception{
		
		Fabricante f;
		
		f = (new MultiFabricante()).buscar(id);
		if(f != null){
			f.setNombre(nombre);
			f.setApellido(apellido);
			f.setTelefono(telefono);
			f.setDireccion(direccion);
			f.setLinea(linea);
			f.setAnnosExp(annos);
			f = (new MultiFabricante()).modificar(f);
		}
		
		return f;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que elimina a un fabricante
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	public static Fabricante eliminarFabricante(int id) throws SQLException, Exception{
		
		Fabricante f;
		
		f = (new MultiFabricante()).buscar(id);
		if(f != null){
			f = (new MultiFabricante()).eliminar(f);
		}
		
		return f;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo para que la empresa registre un Montador
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	public static Montador registrarMontador(int id, String pNombre, String pApellido, int pTelefono, String pDireccion){
		
		Montador m;
		
		m = (new MultiMontador()).crear(id,pNombre, pApellido, pTelefono, pDireccion);
		
		return m;
		
	}
	
	public static Mueble consultarMueble(int idMueble)throws Exception{
		Mueble mueble;
		mueble=(new MultiMueble()).buscarid(idMueble);
		return mueble;
		
	}
	public static Juego consultarJuego(int idJuego)throws Exception{
		Juego juego;
		juego=(new MultiJuego()).buscarid(idJuego);
		return juego;
	
	}
	//Daniel Chaves
	public static Juego crearJuego(int idMontador,int id)throws Exception{
		Montador m=(new MultiMontador().buscar(idMontador));
		Juego juego=m.crearJuego(id);
		return juego;
		
	}
	//Daniel Chaves
	public static void eliminarJuego(int idJuego)throws Exception{
		Juego juego=(new MultiJuego().buscarid(idJuego));
		if(juego!=null){
			juego.eliminar();
		}
	}
}
