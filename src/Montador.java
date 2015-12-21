import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public class Montador extends Persona{
	
	private ArrayList<Juego> juegos;

	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor inicial de la clase montador
	Version: v.1.0
	Fecha: Dic 4, 2015
	Ediciones:

	*/
	public Montador(int pId, String pNombre, String pApellido, int pTelefono, String pDireccion){
		
		super(pId, pNombre, pApellido, pTelefono, pDireccion);
		this.setJuegos(null);
		
	}
	
	public Montador(int pId, String pNombre, String pApellido, int pTelefono, String pDireccion,int switCh){
		
		super(pId, pNombre, pApellido, pTelefono, pDireccion, switCh);
		this.setJuegos(null);
		
	}

//	public void modificarJuego(int idJuego, int idMueble,int idmuebleEliminar)throws Exception{
//		Juego juego=(new MultiJuego().buscarid(idJuego));
//		
//		
//		
//	}
	
	public Mueble agregarMuebleAJuego(int idJuego, int idMueble) throws SQLException, Exception{
		
		Mueble m;
		
		m = (new MultiMueble()).buscarid(idMueble);
		if(m == null){
			System.out.println("Esta null");
		}
		System.out.println("id:" +m.getId() + "\n"
						+ "idJuego:" + m.getIdJuego() + "\n");
		m.setIdJuego((new MultiJuego()).buscarid(idJuego).getId());
		System.out.println("id:" +m.getId() + "\n"
				+ "idJuego:" + m.getIdJuego() + "\n");
		m = (new MultiMueble()).modificar(m);
		
		return m;
		
	}

	public ArrayList<Juego> getJuegos(){
		ArrayList<Juego> j;
		
		try {
			j = (new MultiJuego()).buscarM(this.getId());
		} catch (Exception e) {
			j = null;
		}
		
		return j;
	}

	public void setJuegos(ArrayList<Juego> juegos) {
		this.juegos = juegos;
	}
	
	//Daniel Chaves
	public Juego crearJuego(int idDistribuidor)throws Exception{
		
		Juego juego;
		
		juego = (new MultiJuego()).crear(this.getId(), idDistribuidor);
		if(juego == null){
			System.out.println("El juego esta null");
		}
		
		return juego;
	}
	
	public Juego armarJuego(int idMuebles[],int idMontador)throws SQLException, Exception{
		
		Juego j = this.crearJuego(idMontador);
		Mueble m;
		
		for(int indice = 0; indice < idMuebles.length;indice ++){
			
			m = this.agregarMuebleAJuego(j.getId(), idMuebles[indice]);
		}
		
		return j;
	}
	
	
	/*Autor: Emilio Montero
	Descripcion: Metodo que convierte un montador en un treemap
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	public TreeMap<String, String> toTreeMap(){
		
		TreeMap<String,String> datos = new TreeMap<String,String>();
		
		datos.put("id", String.valueOf(this.getId()));
		datos.put("nombre", this.getNombre());
		datos.put("apellido", this.getApellido());
		datos.put("telefono", String.valueOf(this.getTelefono()));
		datos.put("direccion", this.getDireccion());
		
		return datos;
		
	}
	
}
