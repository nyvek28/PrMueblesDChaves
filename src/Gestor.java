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
		ArrayList<Distribuidor> distribuidores;
		ArrayList<Mueble> muebles;
		ArrayList<Juego> juegos;
		ArrayList<Venta> ventas;
		
		fabricantes = (new MultiFabricante()).listar();
		distribuidores = (new MultiDistribuidor()).listar();
		muebles = (new MultiMueble()).listar();
		juegos = (new MultiJuego()).listar();
		ventas = (new MultiVenta()).listar();

		if(fabricantes != null && distribuidores != null && muebles != null){
			
			Fabricante.setConsecutivo(fabricantes.get(fabricantes.size()-1).getId());
			Distribuidor.setConsecutivo(distribuidores.get(distribuidores.size()-1).getId());
			Mueble.setConsecutivo(muebles.get((muebles.size()-1)).getId());
			Juego.setConsecutivo(juegos.get((juegos.size()-1)).getId());
			Venta.setConsecutivo(ventas.get((ventas.size()-1)).getId());
			
		}else{
			System.out.println("No se inicio correctamente el sistema");
		}
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para registrar un Fabricante
	Version: v.1.0
	Fecha: Dic 4, 2015
	Ediciones:

	*/
	public TreeMap<String,String> registrarFabricante(String pNombre, String pApellido, int pTelefono, String pDireccion,
			int linea, int annos){
		
		TreeMap<String,String> datos;
		Fabricante f;
		
		f = Empresa.registrarFabricante(pNombre, pApellido, pTelefono, pDireccion, linea, annos);
		datos = f.toTreeMap();
		
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
			datos = f.toTreeMap();
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
			datos = f.toTreeMap();
		}else{
			datos = null;
		}
		
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
			datos = (new MultiFabricante().buscar(id)).toTreeMap();
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que elimina un mueble
	Version: v.1.0
	Fecha: Dic 9, 2015
	Ediciones:

	*/
	public TreeMap<String, String>eliminarMueble(int idMueble) throws Exception{
		TreeMap<String, String> datos;
		Mueble m;
		m= (new MultiMueble().buscarid(idMueble));
		if(m!=null){
			m=(new MultiMueble().eliminar(m));
		}
		if(m!=null){
			datos=m.toTreeMap();
		}
		else{
			datos=null;
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
	public TreeMap<String,String> registrarMontador(int id, String pNombre, String pApellido, int pTelefono, String pDireccion){
		
		TreeMap<String,String> datos;
		Montador m;
		
		m = Empresa.registrarMontador(id, pNombre, pApellido, pTelefono, pDireccion);
		datos = m.toTreeMap();
		
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
		
		m = Empresa.consultarMontador(id);
		if(m != null){
			datos = m.toTreeMap();
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
			datos = m.toTreeMap();
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
			datos = m.toTreeMap();
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo para eliminar un Montador por su id
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public TreeMap<String, String> eliminarMontador(int id) throws SQLException, Exception{
		
		TreeMap<String, String> datos;
		Montador m;
		
		m = Empresa.eliminarMontador(id);
		if(m != null){
			datos = (new MultiMontador().buscar(id)).toTreeMap();
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	
	/*
	
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo para registrar un Cliente
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public TreeMap<String,String> registrarCliente(int id, String pNombre, String pApellido, int pTelefono, String pDireccion, String trabajo, int telTrabajo){
		
		TreeMap<String,String> datos;
		Cliente c;
		
		c = Empresa.registrarCliente(id, pNombre, pApellido, pTelefono, pDireccion,trabajo,telTrabajo);
		datos = c.toTreeMap();
		
		return datos;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo para consultar un Cliente por su id
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	public TreeMap<String, String> consultarCliente(int id) throws SQLException, Exception{
		
		TreeMap<String, String> datos;
		Cliente c;
		
		c = (new MultiCliente()).buscar(id);
		if(c != null){
			datos = c.toTreeMap();
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
	public TreeMap<String, String> modificarCliente(int id, String nombre, String apellido, int telefono, String direccion, String trabajo, int telTrabajo) throws SQLException, Exception{
		
		TreeMap<String, String> datos;
		Cliente c;
		
		c = Empresa.modificarCliente(id, nombre, apellido, telefono, direccion,trabajo,telTrabajo);
		if(c != null){
			datos = c.toTreeMap();
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo para eliminar un Montador por su id
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public TreeMap<String, String> eliminarCliente(int id) throws SQLException, Exception{
		
		TreeMap<String, String> datos;
		Cliente c;
		
		c = Empresa.eliminarCliente(id);
		if(c != null){
			datos = (new MultiCliente().buscar(id)).toTreeMap();
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo que arma juego
	Version: v.1.0
	Fecha: Dic 09, 2015
	Ediciones:

	*/
	public TreeMap<String,String> armarJuego(ArrayList<Integer> pidMuebles,int pidMontador, int idDistribuidor)throws SQLException, Exception{
		
		TreeMap<String,String> datos = new TreeMap<String,String>();
		Montador m;
		m = Empresa.consultarMontador(pidMontador);
			if(m != null){
			Juego juego = m.crearJuego(idDistribuidor);
			if(juego != null){
				for(int i=0;i < pidMuebles.size(); i++){
					m.agregarMuebleAJuego(juego.getId(), pidMuebles.get(i));
				}
				datos=juego.toTreeMap();
			}else{
				System.out.println("Error: El juego viene null");
			}
		}else{
			System.out.println("Error: El montador viene null");
		}
		
		return datos;
	}
	
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que registra un mueble
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	
	public TreeMap<String,String>  registrarMueble(int idFabricante, String pcolor, double ancho, double alto, double largo, int pcategoria, double precio)throws Exception{
		Fabricante f;
		Mueble m;
		TreeMap<String, String> datos;
		
		f=(new MultiFabricante()).buscar(idFabricante);
		m=f.fabricarMueble(pcolor, ancho, alto, largo, precio);
		datos=m.toTreeMap();
		
		return datos;
		
		
	}
	
	public TreeMap<String,String>  registrarMueble(int idFabricante, String pcolor, double ancho, double alto, double largo, int pcategoria, double precio,double alturaSobreSuelo)throws Exception{
		Fabricante f;
		Mueble m;
		TreeMap<String, String> datos;
		
		f=(new MultiFabricante()).buscar(idFabricante);
		m=f.fabricarMueble(pcolor, ancho, alto, largo, precio,alturaSobreSuelo);
		datos=m.toTreeMap();
		
		return datos;
		
		
	}
	
	public TreeMap<String,String>  registrarMueble(int idFabricante, String pcolor, double ancho, double alto, double largo, int pcategoria, double precio, int tipo,
			double espesor)throws Exception{
		Fabricante f;
		Mueble m;
		TreeMap<String, String> datos;
		
		f=(new MultiFabricante()).buscar(idFabricante);
		m=f.fabricarMueble(pcolor, ancho, alto, largo, precio,tipo,espesor);
		datos=m.toTreeMap();
		
		return datos;
		
		
	}
	
	public TreeMap<String,String>  registrarMueble(int idFabricante, String pcolor, double ancho, double alto, double largo, int pcategoria, double precio, int acabado)throws Exception{
		Fabricante f;
		Mueble m;
		TreeMap<String, String> datos;
		
		f=(new MultiFabricante()).buscar(idFabricante);
		m=f.fabricarMueble(pcolor, ancho, alto, largo, precio, acabado);
		datos=m.toTreeMap();
		
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
		Mueble mueble=(new MultiMueble().buscarid(idMueble));
		TreeMap<String,String> datosMueble = new TreeMap<String,String>();
		datosMueble=mueble.toTreeMap();
		
		return datosMueble;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que consulta muebles por su distribuidor
	Version: v.1.0
	Fecha: Dic 19, 2015
	Ediciones:

	*/
	public ArrayList<TreeMap<String, String>> consultarMueblePorDistribuidor(int idDistribuidor)throws Exception{
		
		ArrayList<TreeMap<String, String>> info = new ArrayList<TreeMap<String, String>>();
		ArrayList<Mueble> muebles = (new MultiMueble()).buscarD(idDistribuidor);
		
		if(muebles != null){
			for(int i = 0; i < muebles.size(); i++){
				info.add(muebles.get(i).toTreeMap());
			}
		}else{
			info = null;
		}
		
		return info;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que consulta muebles por su juego
	Version: v.1.0
	Fecha: Dic 19, 2015
	Ediciones:

	*/
	public ArrayList<TreeMap<String, String>> consultarMueblePorJuego(int idJuego)throws Exception{
		
		ArrayList<TreeMap<String, String>> info = new ArrayList<TreeMap<String, String>>();
		ArrayList<Mueble> muebles = (new MultiMueble()).buscaridJ(idJuego);
		
		if(muebles != null){
			for(int i = 0; i < muebles.size(); i++){
				info.add(muebles.get(i).toTreeMap());
			}
		}else{
			info = null;
		}
		
		return info;
		
	}
	
	
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que consulta un Juego
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	 */


	public TreeMap<String, String> consultarJuego(int idJuego, int idDistribuidor)throws Exception{
		Juego j;
		Distribuidor d;
		TreeMap datos = new TreeMap();
		
		d = (new MultiDistribuidor()).buscar(idDistribuidor);
		if(d != null){
			j = d.buscarJuego(idJuego);
			if(j != null){
				datos = j.toTreeMap();
			}else{
				datos = null;
			}
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que registra un Juego
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:
	 */
	public TreeMap<String, String> registrarJuego(int idMontador)throws Exception{
		Juego j=Empresa.crearJuego(idMontador);
		
		TreeMap<String,String> datosJuego = new TreeMap<String,String>();
		datosJuego.put("id", String.valueOf(j.getId()));
		datosJuego.put("idMontador", String.valueOf(j.getIdMontador()));
		
		return datosJuego;
		
	}
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que modifica un juego a gusto del usuario
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:
	 */
	public void modificarJuego(int idMontador,int idJuego, int idMueble,int idmuebleEliminar)throws Exception{
		Juego juego=Empresa.consultarJuego(idJuego);
		Montador montador=(new MultiMontador().buscar(idMontador));
		//montador.modificarJuego(idJuego, idMueble, idmuebleEliminar);
		
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
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para registrar un distribuidor
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public TreeMap<String, String> registrarDistribuidor(String nombre, String direccion, int telefono, double porcentaje){
		
		TreeMap<String, String> datos;
		Distribuidor d;
		
		d = Empresa.registrarDistribuidor(nombre, direccion, telefono, porcentaje);
		if(d != null){
			datos = d.toTreeMap();
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para consultar un distribuidor
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public TreeMap<String, String> consultarDistribuidor(int id) throws SQLException, Exception{
		
		TreeMap<String, String> datos;
		Distribuidor d;
		
		d = Empresa.consultarDistribuidor(id);
		if(d != null){
			datos = (new MultiDistribuidor().buscar(id)).toTreeMap();
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para modificar un distribuidor
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public TreeMap<String, String> modificarDistribuidor(int id, String nombre, String direccion, int telefono, double porcentaje) throws SQLException, Exception{
		
		Distribuidor d;
		TreeMap<String, String> datos;
		
		d = Empresa.modificarDistribuidor(id, nombre, direccion, telefono, porcentaje);
		if(d != null){
			datos = (new MultiDistribuidor().buscar(id)).toTreeMap();
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para eliminar un distribuidor
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public TreeMap<String, String> eliminarDistribuidor(int id) throws SQLException, Exception{
		
		Distribuidor d;
		TreeMap<String, String> datos;
		
		d = Empresa.eliminarDistribuidor(id);
		if(d != null){
			datos = (new MultiDistribuidor().buscar(id)).toTreeMap();
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que registra una venta
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:
	 */
	public TreeMap<String,String> venderJuego(int idDistribuidor, int idJuego, int idCliente)throws Exception{
		Venta v;
		TreeMap<String, String> info;
		
		if((new MultiDistribuidor()).buscar(idDistribuidor) != null){
				if((new MultiCliente()).buscar(idCliente) != null){
				v = (new MultiDistribuidor()).buscar(idDistribuidor).registrarVenta(idJuego, idCliente);
				info = (new MultiVenta().buscar(v.getId())).toTreeMap();
			}else{
				info = null;
			}
		}else{
			info = null;
		}
		
		return info;
		
	}
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que consultar venta
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:
	 */
	public TreeMap<String, String> consultarVenta(int idVenta)throws Exception{
		Venta venta = (new MultiVenta().buscar(idVenta));
		TreeMap<String, String> infoVenta=(new MultiVenta().buscar(idVenta)).toTreeMap();
		return infoVenta;
	}
	/*
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que lista a los fabricantes de la base de datos
	Version: v.1.0
	Fecha: Dic 11, 2015
	Ediciones:

	*/
	
	public ArrayList<TreeMap<String, String>> listarFabricantes() throws Exception{
		
		ArrayList<TreeMap<String, String>> fabricantes = new ArrayList<TreeMap<String,String>>();
		TreeMap datos;
		
		for(int i = 0; i < (new MultiFabricante()).listar().size(); i++){
			
			datos = (new MultiFabricante()).listar().get(i).toTreeMap();
			fabricantes.add(datos);
			
		}
		
		return fabricantes;
		
	}
	public String darMuebles(ArrayList<Integer> indices,int idDistribuidor, int idFabricante) throws SQLException, Exception{
		Fabricante f;
		Distribuidor d;
		String result="";
		
		
		for(int i=0; i<= indices.size();i++){
			if((d= (new MultiDistribuidor().buscar(idDistribuidor)))!=null){
				if((f= (new MultiFabricante().buscar(idFabricante)))!=null){
					d.agregarMueble(f.buscarMueble(indices.get(i)));
					result="Mueble agregado";
				}else{
					result="Fabricante no existe";
				}	
			}else{
				result="Distribuidor no existe";
			}
		}
		return result;
		
	}
	
	public ArrayList<TreeMap<String, String>> listarMuebles(int plinea) throws Exception{
		
		ArrayList<TreeMap<String, String>> muebles = new ArrayList<TreeMap<String,String>>();
		TreeMap datos;
		
		for(int i = 0; i < (new MultiMueble()).listar(plinea).size(); i++){
			
			datos = (new MultiMueble()).listar(plinea).get(i).toTreeMap();
			muebles.add(datos);
			
		}
		return muebles;
		
	}
	public ArrayList<TreeMap<String, String>> listarMuebles() throws Exception{
		
		ArrayList<TreeMap<String, String>> muebles = new ArrayList<TreeMap<String,String>>();
		TreeMap datos;
		
		for(int i = 0; i < (new MultiMueble()).listar().size(); i++){
			
			datos = (new MultiMueble()).listar().get(i).toTreeMap();
			muebles.add(datos);
			
		}
		return muebles;
	}
	
	
	
	
	
	
	public ArrayList<TreeMap<String, String>> listarJuegos() throws Exception{
		
		ArrayList<TreeMap<String, String>> juegos = new ArrayList<TreeMap<String,String>>();
		TreeMap datos;
		
		for(int i = 0; i < (new MultiFabricante()).listar().size(); i++){
			
			datos = (new MultiJuego()).listar().get(i).toTreeMap();
			juegos.add(datos);
			
		}
		
		return juegos;
		
	}
	
	
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo que lista a los montadores de la base de datos
	Version: v.1.0
	Fecha: Dic 13, 2015
	Ediciones:

	*/
	
	public ArrayList<TreeMap<String, String>> listarMontadores() throws Exception{
		
		ArrayList<TreeMap<String, String>> montadores = new ArrayList<TreeMap<String,String>>();
		TreeMap datos;
		
		for(int i = 0; i < (new MultiMontador()).listar().size(); i++){
			
			datos = (new MultiMontador()).listar().get(i).toTreeMap();
			montadores.add(datos);
			
		}
		
		return montadores;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo que lista a los clientes de la base de datos
	Version: v.1.0
	Fecha: Dic 15, 2015
	Ediciones:

	*/
	
	public ArrayList<TreeMap<String, String>> listarClientes() throws Exception{
		
		ArrayList<TreeMap<String, String>> clientes = new ArrayList<TreeMap<String,String>>();
		TreeMap datos;
		
		for(int i = 0; i < (new MultiCliente()).listar().size(); i++){
			
			datos = (new MultiCliente()).listar().get(i).toTreeMap();
			clientes.add(datos);
			
		}
		
		return clientes;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que lista a los distribuidores de la base de datos
	Version: v.1.0
	Fecha: Dic 15, 2015
	Ediciones:

	*/
	
	public ArrayList<TreeMap<String, String>> listarDistribuidores() throws Exception{
		
		ArrayList<TreeMap<String, String>> distribuidores = new ArrayList<TreeMap<String,String>>();
		TreeMap datos;
		
		for(int i = 0; i < (new MultiDistribuidor()).listar().size(); i++){
			
			datos = (new MultiDistribuidor()).listar().get(i).toTreeMap();
			distribuidores.add(datos);
			
		}
		
		return distribuidores;
		
	}
	
	public double calcularCosto(int idDistribuidor, int idJuego) throws SQLException, Exception{
		
		Distribuidor d;
		Juego j;
		double costo;
		
		d = Empresa.consultarDistribuidor(idDistribuidor);
		if(d != null){
			j = (new MultiJuego()).buscarid(idJuego);
			if(j != null){
				costo = d.calcularCostoJuego(idJuego);
			}else{
				costo = -1;
			}
		}else{
			costo = -1;
		}
		
		return costo;
		
	}
	
}
