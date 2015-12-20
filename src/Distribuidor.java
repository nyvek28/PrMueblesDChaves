import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

public class Distribuidor {

	private int id;
	private String nombre;
	private String direccion;
	private int telefono;
	private double porcentaje;
	private static int consecutivo = 0;
	private int switCh;
	private ArrayList<Fabricante> fabricantes;
	private ArrayList<Juego> juegos;
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor inicial de la clase Distribuidor
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public Distribuidor (String nombre, String direccion, int telefono, double porcentaje){
		
		Distribuidor.setConsecutivo(Distribuidor.getConsecutivo()+1);
		this.setId(Distribuidor.getConsecutivo());
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
		this.setPorcentaje(porcentaje);
		this.setSwitCh(1);
		this.setFabricantes(null);
		this.setJuegos(null);
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor absoluto de la clase Distribuidor
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public Distribuidor (int id, String nombre, String direccion, int telefono, double porcentaje, int switCh){
		
		this.setId(id);
		this.setNombre(nombre);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
		this.setPorcentaje(porcentaje);
		this.setSwitCh(switCh);
		this.setFabricantes(null);
		this.setJuegos(null);
		
	}
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que registra una venta
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:
	 */
	
	
	public Venta registrarVenta(int idJuego, int idCliente)throws Exception{
		
		Juego juego =(new MultiJuego().buscarid(idJuego));
		
		Venta venta =(new MultiVenta().crear(this.getId(),idJuego, idCliente));
		venta.setMonto(this.calcularCostoJuego(idJuego));
		return venta;
	}
	
	public double calcularCostoJuego(int idJuego) throws SQLException, Exception{
		
		double costoTotal = 0;
		Juego j;
		
		j = this.buscarJuego(idJuego);
		costoTotal = j.calcularCosto();
		if(costoTotal != -1){
			costoTotal += costoTotal * this.getPorcentaje() / 100;
		}
		
		return costoTotal;
		
	}
	
	public Juego buscarJuego(int idJuego){
		
		ArrayList<Juego> lista;
		Juego j = null;
		
		lista = this.getJuegos();
		if(lista != null){
			for(int i = 0; i < lista.size(); i++){
				if(lista.get(i).getId() == idJuego){
					j = lista.get(i);
				}
			}
		}
		
		return j;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

	public static int getConsecutivo() {
		return consecutivo;
	}

	public static void setConsecutivo(int consecutivo) {
		Distribuidor.consecutivo = consecutivo;
	}

	public int getSwitCh() {
		return switCh;
	}

	public void setSwitCh(int switCh) {
		this.switCh = switCh;
	}

	public ArrayList<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(ArrayList<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public ArrayList<Juego> getJuegos() {
		return juegos;
	}

	public void setJuegos(ArrayList<Juego> juegos) {
		this.juegos = juegos;
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para convertir un distribuidor en un treemap
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public TreeMap<String, String>toTreeMap(){
		
		TreeMap<String,String> datos = new TreeMap<String,String>();
		
		datos.put("id", String.valueOf(this.getId()));
		datos.put("nombre", this.getNombre());
		datos.put("telefono", String.valueOf(this.getTelefono()));
		datos.put("direccion", this.getDireccion());
		datos.put("porcentaje", String.valueOf(this.getPorcentaje()));
		
		return datos;
		
	}
	
}
