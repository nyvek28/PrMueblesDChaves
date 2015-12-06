import java.util.ArrayList;

public class Cliente extends Persona{
	
	
	private String trabajo;
	private int telTrabajo;
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor inicial de la clase montador
	Version: v.1.0
	Fecha: Dic 4, 2015
	Ediciones:

	*/


	public Cliente(int pId, String pNombre, String pApellido, int pTelefono, String pDireccion,String trabajo, int telTrabajo){
		
		super(pId, pNombre, pApellido, pTelefono, pDireccion);
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
}
