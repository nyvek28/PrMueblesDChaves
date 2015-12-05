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
	public static Juego crearJuego(int idMontador,int id){
		Montador m=(new MultiMontador().buscar(idMontador));
		Juego juego=m.crearJuego(id);
		return juego;
		
	}
}
