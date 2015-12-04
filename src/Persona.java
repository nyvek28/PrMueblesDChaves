
public abstract class Persona {

	private int id;
	private String nombre;
	private String apellido;
	private int telefono;
	private String direccion;
	private int switCh;
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor inicial de la clase persona
	Version: v.1.0
	Fecha: Dic 3, 2015
	Ediciones:

	*/
	public Persona(int pId, String pNombre, String pApellido, int pTelefono, String pDireccion){
		
		this.setId(pId);
		this.setNombre(pNombre);
		this.setApellido(pApellido);
		this.setTelefono(pTelefono);
		this.setDireccion(pDireccion);
		this.setSwitCh(1);
		
	}
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor absoluto de la clase persona
	Version: v.1.0
	Fecha: Dic 3, 2015
	Ediciones:

	*/
	public Persona(int pId, String pNombre, String pApellido, int pTelefono, String pDireccion, 
			int pSwitCh){
		
		this.setId(pId);
		this.setNombre(pNombre);
		this.setApellido(pApellido);
		this.setTelefono(pTelefono);
		this.setDireccion(pDireccion);
		this.setSwitCh(pSwitCh);
		
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getSwitCh() {
		return switCh;
	}

	public void setSwitCh(int switCh) {
		this.switCh = switCh;
	}
	
}
