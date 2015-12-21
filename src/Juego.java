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
	private Montador montador;
	private int idDistribuidor;
	
	public Juego(int pidMontador, int idDistribuidor)throws Exception{
		Juego.setConsecutivo(Juego.getConsecutivo()+1);
		this.setId(consecutivo);
		this.setIdMontador(pidMontador);
		this.setSwitCh(1);
		this.setVendido(0);
		this.setListaMuebles(null);
		this.setIdDistribuidor(idDistribuidor);
	}
	public Juego(int pid, int pidMontador, int pswitCh, int idDistribuidor){
		this.setId(pid);
		this.setIdMontador(pidMontador);
		this.setSwitCh(pswitCh);
		this.setIdDistribuidor(idDistribuidor);
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
	
	private String vendidoToString(){
		String estado;
		
		if(this.getVendido() != 0){
			estado = "Si";
		}else{
			estado = "No";
		}
		
		return estado;
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
	public Montador getMontador() throws SQLException, Exception {
		Montador m;
		
		m = (new MultiMontador()).buscar(this.getIdMontador());
		
		return m;
	}
	public void setMontador(Montador montador) {
		this.montador = montador;
	}
	public int getIdDistribuidor() {
		return idDistribuidor;
	}
	public void setIdDistribuidor(int idDistribuidor) {
		this.idDistribuidor = idDistribuidor;
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
	public TreeMap<String, String> toTreeMap()throws Exception{
		
		TreeMap<String,String> datosJuego = new TreeMap<String,String>();
		
		datosJuego.put("id", String.valueOf(this.getId()));
		datosJuego.put("montador", this.getMontador().getNombre() + " " + this.getMontador().getApellido());
		datosJuego.put("vendido", this.vendidoToString());
		
		return datosJuego;
	}
}
