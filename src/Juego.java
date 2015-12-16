import java.sql.SQLException;
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
	private int vendido;
	private int idMontador;
	private static int consecutivo=0;
	private int switCh;
	
	public Juego(int pidMontador)throws Exception{
		Juego.setConsecutivo(Juego.getConsecutivo()+1);
		this.setId(consecutivo);
		this.setIdMontador(pidMontador);
		this.setSwitCh(1);
		this.setVendido(0);
		this.setListaMuebles(null);
	}
	public Juego(int pid, int pidMontador, int pswitCh){
		this.setId(pid);
		this.setIdMontador(pidMontador);
		this.setSwitCh(pswitCh);
		
	}
	public int getVendido() {
		return vendido;
	}

	public void setVendido(int pvendido) {
		vendido = pvendido;
	}
	
	public ArrayList<Mueble> getListaMuebles() throws SQLException, Exception {
		ArrayList<Mueble> l;
		
		l = (new MultiMueble()).buscaridJ(this.getId());
		
		return l;
	}
	public void setListaMuebles(ArrayList a)throws Exception {
		this.listaMuebles=a;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int pid) {
		this.id = pid;
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
