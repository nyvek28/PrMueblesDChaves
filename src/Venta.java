/*
	Autor: Daniel Chaves
	Descripcion: Clase venta
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:
	 */



import java.util.*;
public class Venta {
	
	private int idJuego;
	private String fecha;
	private static int id=0;
	private static int consecutivo = 0;
	private String msj;
	private int idCliente;
	private int switCh;
	private int IdDistribuidor;
	private double monto;
	
	
	
	
	public Venta(int pidJuego,int pidCliente, String pfecha, double pmonto ){
		this.setIdCliente(pidCliente);
		this.setIdJuego(pidJuego);
		this.setFecha(pfecha);
		this.setId();
		this.setConsecutivo(consecutivo++);
		this.setSwitCh(1);
		this.setMonto(pmonto);
		
	}
	public Venta ( int pid,String pfecha, int pidCliente,int pidDistribuidor, int pidJuego, int pconsecutivo, int pswitch ){
		this.setId(pid);
		this.setFecha(pfecha);
		this.setIdCliente(pidCliente);
		this.setIdDistribuidor(pidDistribuidor);
		this.setIdJuego(pidJuego);
		this.setConsecutivo(pconsecutivo);
		this.setSwitCh(pswitch);
		
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public int getIdDistribuidor() {
		return IdDistribuidor;
	}
	public void setIdDistribuidor(int idDistribuidor) {
		IdDistribuidor = idDistribuidor;
	}
	public int getSwitCh() {
		return switCh;
	}

	public void setSwitCh(int switCh) {
		this.switCh = switCh;
	}
	public static int getConsecutivo() {
		return consecutivo;
	}

	public static void setConsecutivo(int pconsecutivo) {
		consecutivo = pconsecutivo;
	}
	public static int getId() {
		return id;
	}
	public static void setId(int pid){
		id=pid;
	}
	public static void setId() {
		id=id+1;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getInfoMuebles() {
		return msj;
	}
	public void setMsj(String msj) {
		this.msj = msj;
	}
	public int getIdJuego() {
		return idJuego;
	}


	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public void info() throws Exception{
		msj="";
		String info="";
		Cliente cliente=(new MultiCliente().buscar(idCliente));
		Juego juego= (new MultiJuego().buscarid(idJuego));
		msj+="Cliente: "+cliente.getNombre()+" "+cliente.getApellido();
		ArrayList<Mueble> listaMuebles=(new MultiJuego().buscarMuebleddeJuego(idJuego));
		for(int i=0;i<listaMuebles.size();i++){
			Mueble m=listaMuebles.get(i);
			msj+="\n Mueble"+i+": "+ m.toString();
				
		}
		
		
	}

}
