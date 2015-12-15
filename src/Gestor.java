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
		
		fabricantes = (new MultiFabricante()).listar();
		distribuidores = (new MultiDistribuidor()).listar();
		muebles = (new MultiMueble()).listar();
		if(fabricantes != null && distribuidores != null && muebles != null){
			
			Fabricante.setConsecutivo(fabricantes.get(fabricantes.size()-1).getId());
			Distribuidor.setConsecutivo(distribuidores.get(distribuidores.size()-1).getId());
			Mueble.setConsecutivo(muebles.get((muebles.size()-1)).getId());
			
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
			datos=this.muebleToTreeMap(m);
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
		
		m = Empresa.consultarMontador(id);
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
		datos = this.clienteToTreeMap(c);
		
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
			datos = this.clienteToTreeMap(c);
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
			datos = this.clienteToTreeMap(c);
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
			datos = this.clienteToTreeMap(c);
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo que convierte un cliente en un treemap
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	private TreeMap<String, String> clienteToTreeMap(Cliente c){
		
		TreeMap<String,String> datos = new TreeMap<String,String>();
		
		datos.put("id", String.valueOf(c.getId()));
		datos.put("nombre", c.getNombre());
		datos.put("apellido", c.getApellido());
		datos.put("telefono", String.valueOf(c.getTelefono()));
		datos.put("direccion", c.getDireccion());
		datos.put("trabajo", c.getTrabajo());
		datos.put("telTrabajo", String.valueOf(c.getTelTrabajo()));
		
		return datos;
		
	}
	/*
	Autor: Emilio Montero
	Descripcion: Metodo que arma juego
	Version: v.1.0
	Fecha: Dic 09, 2015
	Ediciones:

	*/
	public TreeMap<String,String> armarJuego(int pidMuebles[],int pidMontador)throws SQLException, Exception{
		
		TreeMap<String,String> datos = new TreeMap<String,String>();
		Montador m;
		m = Empresa.consultarMontador(pidMontador);
		Juego juego=m.crearJuego(m.getId());
		for(int i=0;i<= pidMuebles.length; i++){
			m.agregarMuebleAJuego(juego.getId(), pidMuebles[i]);
		}
		datos=this.juegoToTreeMap(juego);
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
		datosMueble.put("id", String.valueOf(mueble.getId()));
		datosMueble.put("linea", String.valueOf(mueble.getLinea()));
		datosMueble.put("color", String.valueOf(mueble.getColor()));
		datosMueble.put("dimensiones", String.valueOf(mueble.getDimensiones()));
		datosMueble.put("categoria", String.valueOf(mueble.getCategoria()));
		
		return datosMueble;
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
		m=f.fabricarMueble(pcolor, ancho, alto, largo, pcategoria, precio);
		datos=this.muebleToTreeMap(m);
		
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
		datosJuego.put("id", String.valueOf(juego.getId()));
		datosJuego.put("montador", String.valueOf(juego.getIdMontador()));
		datosJuego.put("informacion muebles", info);
		
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
		montador.modificarJuego(idJuego, idMueble, idmuebleEliminar);
		
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
			datos = this.distribuidorToTreeMap(d);
		}else{
			datos = null;
		}
		
		return datos;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para convertir un distribuidor en un treemap
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	private TreeMap<String, String> distribuidorToTreeMap(Distribuidor d){
		
		TreeMap<String,String> datos = new TreeMap<String,String>();
		
		datos.put("id", String.valueOf(d.getId()));
		datos.put("nombre", d.getNombre());
		datos.put("telefono", String.valueOf(d.getTelefono()));
		datos.put("direccion", d.getDireccion());
		datos.put("porcentaje", String.valueOf(d.getPorcentaje()));
		
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
			datos = this.distribuidorToTreeMap(d);
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
			datos = this.distribuidorToTreeMap(d);
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
			datos = this.distribuidorToTreeMap(d);
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
	public TreeMap<String,String> venderJuego(int idDistribuidor, int idJuego, int idCliente, String fecha)throws Exception{
		Venta venta=Empresa.registrarVenta(idDistribuidor, idJuego, idCliente, fecha);
		TreeMap<String, String> infoVenta=this.ventaToTreeMap(venta);
		return infoVenta;
		
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
		TreeMap<String, String> infoVenta=this.ventaToTreeMap(venta);
		return infoVenta;
	}
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que convierte los datos de venta en treemap
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:
	 */
	private TreeMap<String, String> ventaToTreeMap(Venta venta){
		
		TreeMap<String,String> datos = new TreeMap<String,String>();
		
		datos.put("idCliente", String.valueOf(venta.getIdCliente()));
		datos.put("idJuego", String.valueOf(venta.getIdJuego()));
		datos.put("Muebles", venta.getInfoMuebles());
		
		return datos;
		
		
	}
	
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
			
			datos = this.fabricanteToTreeMap((new MultiFabricante()).listar().get(i));
			fabricantes.add(datos);
			
		}
		
		return fabricantes;
		
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
			
			datos = this.montadorToTreeMap((new MultiMontador()).listar().get(i));
			montadores.add(datos);
			
		}
		
		return montadores;
		
	}
	
}
