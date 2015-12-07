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
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo que modifica un Montador
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public static Montador modificarMontador(int id, String nombre, String apellido, int telefono, String direccion) throws SQLException, Exception{
		
		Montador m;
		
		m = (new MultiMontador()).buscar(id);
		if(m != null){
			m.setNombre(nombre);
			m.setApellido(apellido);
			m.setTelefono(telefono);
			m.setDireccion(direccion);
			m = (new MultiMontador()).modificar(m);
		}
		
		return m;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo que elimina a un montador
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public static Montador eliminarMontador(int id) throws SQLException, Exception{
		
		Montador m;
		
		m = (new MultiMontador()).buscar(id);
		if(m != null){
			m = (new MultiMontador()).eliminar(m);
		}
		
		return m;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo para que la empresa registre un Cliente
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public static Cliente registrarCliente(int id, String pNombre, String pApellido, int pTelefono, String pDireccion,String ptrabajo,int ptelTrabajo){
		
		Cliente c;
		
		c = (new MultiCliente()).crear(id,pNombre, pApellido, pTelefono, pDireccion,ptrabajo,ptelTrabajo);
		
		return c;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo que modifica un Cliente
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public static Cliente modificarCliente(int id, String pNombre, String pApellido, int pTelefono, String pDireccion,String ptrabajo,int ptelTrabajo) throws SQLException, Exception{
		
		Cliente c;
		
		c = (new MultiCliente()).buscar(id);
		if(c != null){
			c.setNombre(pNombre);
			c.setApellido(pApellido);
			c.setTelefono(pTelefono);
			c.setDireccion(pDireccion);
			c.setTrabajo(ptrabajo);
			c.setTelTrabajo(ptelTrabajo);;
			c = (new MultiCliente()).modificar(c);
		}
		
		return c;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo que elimina a un cliente
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public static Cliente eliminarCliente(int id) throws SQLException, Exception{
		
		Cliente c;
		
		c = (new MultiCliente()).buscar(id);
		if(c != null){
			c = (new MultiCliente()).eliminar(c);
		}
		
		return c;
		
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
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para que la empresa registre un Distribuidor
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public static Distribuidor registrarDistribuidor(String nombre, String direccion, int telefono, double porcentaje){
		
		Distribuidor d;
		
		d = (new MultiDistribuidor()).crear(nombre, direccion, telefono, porcentaje);
		
		return d;

	}
	
}
