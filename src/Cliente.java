import java.util.ArrayList;
import java.util.TreeMap;

public class Cliente extends Persona{
	
	
	private String trabajo;
	private int telTrabajo;
	
	/*
	Autor: Emilio Montero
	Descripcion: Constructor inicial de la clase cliente
	Version: v.1.0
	Fecha: Dic 4, 2015
	Ediciones:

	*/


	public Cliente(int pId, String pNombre, String pApellido, int pTelefono, String pDireccion,String trabajo, int telTrabajo){
		
		super(pId, pNombre, pApellido, pTelefono, pDireccion);
		this.setTrabajo(trabajo);
		this.setTelTrabajo(telTrabajo);
		
	}
	
	public Cliente(int pId, String pNombre, String pApellido, int pTelefono, String pDireccion,int switCh,String trabajo, int telTrabajo){
		
		super(pId, pNombre, pApellido, pTelefono, pDireccion,switCh);
		this.setTrabajo(trabajo);
		this.setTelTrabajo(telTrabajo);
		
	}

	
	/**
	 * @return the trabajo
	 */
	public String getTrabajo() {
		return trabajo;
	}

	/**
	 * @param trabajo the trabajo to set
	 */
	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}
	
	/**
	 * @return the telTrabajo
	 */
	public int getTelTrabajo() {
		return telTrabajo;
	}


	/**
	 * @param telTrabajo the telTrabajo to set
	 */
	public void setTelTrabajo(int telTrabajo) {
		this.telTrabajo = telTrabajo;
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo que convierte un cliente en un treemap
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public TreeMap<String, String> toTreeMap(){
		
		TreeMap<String,String> datos = new TreeMap<String,String>();
		
		datos.put("id", String.valueOf(this.getId()));
		datos.put("nombre", this.getNombre());
		datos.put("apellido", this.getApellido());
		datos.put("telefono", String.valueOf(this.getTelefono()));
		datos.put("direccion", this.getDireccion());
		datos.put("trabajo", this.getTrabajo());
		datos.put("telTrabajo", String.valueOf(this.getTelTrabajo()));
		
		return datos;
		
	}
}
