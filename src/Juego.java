import java.util.*;


/*
 * author: Daniel Chaves
 * Descripcion: crea un objeto Juego y sus accesores
 * Version 1.0
 * Fecha: Dic 4, 2015
	Ediciones:
 */


public class Juego {

	private int id;
	private ArrayList<Mueble> listaMuebles;
	
	private int idMontador;
	private static int consecutivo=0;
	private int switCh;
	
	public Juego(int pid, int pidMontador)throws Exception{
		this.setId(pid);
		this.setIdMontador(pidMontador);
		consecutivo++;
		this.setSwitCh(1);
		this.setListaMuebles();
	}
	
	public ArrayList<Mueble> getListaMuebles() {
		return listaMuebles;
	}
	public void setListaMuebles()throws Exception {
		
		listaMuebles.add((new MultiMueble()).buscarid(id1));
	
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdMontador() {
		return idMontador;
	}
	public void setIdMontador(int idMontador) {
		this.idMontador = idMontador;
	}
	public static int getConsecutivo() {
		return consecutivo;
	}
	public static void setConsecutivo(int consecutivo) {
		Juego.consecutivo = consecutivo;
	}
	public int getSwitCh() {
		return switCh;
	}
	public void setSwitCh(int switCh) {
		this.switCh = switCh;
	}
}
