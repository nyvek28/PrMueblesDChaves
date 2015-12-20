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
	
	public double calcularCosto() throws SQLException, Exception{
		
		double costoTotal = 0;
		ArrayList<Mueble> muebles = this.getListaMuebles();
		
		if(muebles != null){
			for(int i = 0; i < muebles.size(); i++){
				
				costoTotal += muebles.get(i).calcularCosto();
				
			}
		}else{
			costoTotal = -1;
		}
		
		return costoTotal;
		
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
	
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que convierte info de Juego en TreeMap
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	public TreeMap<String, String> juegoToTreeMap()throws Exception{
		
		TreeMap<String,String> datosJuego = new TreeMap<String,String>();
		
		String info="";
		ArrayList<Mueble> listaMuebles=(new MultiMueble().buscaridJ(this.getId()));
		for(int i=0;i<listaMuebles.size();i++){
			Mueble m=listaMuebles.get(i);
			info+="\n Mueble"+i+": "+ m.toString();
		}
		datosJuego.put("id", String.valueOf(this.getId()));
		datosJuego.put("montador", String.valueOf(this.getIdMontador()));
		datosJuego.put("info", info);
		
		return datosJuego;
	}
}
