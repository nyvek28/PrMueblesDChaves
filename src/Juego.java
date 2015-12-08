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
	private static int vendido;
	
	private int idMontador;
	private static int consecutivo=0;
	private int switCh;
	
	public Juego(int pid, int pidMontador)throws Exception{
		this.setId(pid);
		this.setIdMontador(pidMontador);
		consecutivo++;
		this.setSwitCh(1);
		listaMuebles=new ArrayList<Mueble>();
	}
	
	public ArrayList<Mueble> getListaMuebles() {
		return listaMuebles;
	}
	public void setListaMuebles(int id1)throws Exception {
		
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
	public void eliminar(){
		switCh=-1;
	}
}
