/*
	Autor: Daniel Chaves
	Descripcion: Clase venta
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:
	 */



import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Venta {
	
	private int idJuego;
	private Date fecha;
	private int id=0;
	private static int consecutivo = 0;
	private String msj;
	private int idCliente;
	private int switCh;
	private int IdDistribuidor;
	private double monto;
	
	
	
	
	public Venta(int pidDistribuidor,int pidJuego,int pidCliente ) throws SQLException, Exception{
		this.setIdCliente(pidCliente);
		this.setIdDistribuidor(pidDistribuidor);
		this.setIdJuego(pidJuego);
		this.setFecha((new SimpleDateFormat()).parse((new SimpleDateFormat()).format(new Date())));
		Venta.setConsecutivo(consecutivo++);
		this.setId(Venta.getConsecutivo());
		this.setMonto((new MultiDistribuidor()).buscar(pidDistribuidor).calcularCostoJuego((new MultiJuego()).buscarid(pidJuego)));
		this.setSwitCh(1);
		
	}
	public Venta ( int pid,Date pfecha, int pidCliente,int pidDistribuidor, int pidJuego, int pconsecutivo, int pswitch, double monto ){
		this.setId(pid);
		this.setFecha(pfecha);
		this.setIdCliente(pidCliente);
		this.setIdDistribuidor(pidDistribuidor);
		this.setIdJuego(pidJuego);
		this.setConsecutivo(pconsecutivo);
		this.setSwitCh(pswitch);
		this.setMonto(monto);
		
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
	public int getId() {
		return id;
	}
	public void setId(int pid){
		id=pid;
	}
	public void setId() {
		id=id+1;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
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
	
	/*Autor: Daniel Chaves
	Descripcion: Metodo que convierte los datos de venta en treemap
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:
	 */
	public TreeMap<String, String> toTreeMap() throws SQLException, Exception{
		
		TreeMap<String,String> datos = new TreeMap<String,String>();
		
		datos.put("cliente", (new MultiCliente()).buscar(this.getIdCliente()).getNombre()+" "+(new MultiCliente()).buscar(this.getIdCliente()).getApellido());
		datos.put("idJuego", String.valueOf(this.getIdJuego()));
		datos.put("distribuidor", (new MultiDistribuidor().buscar(this.getIdDistribuidor()).getNombre()));
		datos.put("monto", String.valueOf(this.getMonto()));
		datos.put("monto", String.valueOf(this.getMonto()));
		
		return datos;
		
		
	}
	
//	public void info() throws Exception{
//		msj="";
//		String info="";
//		Cliente cliente=(new MultiCliente().buscar(idCliente));
//		Juego juego= (new MultiJuego().buscarid(idJuego));
//		msj+="Cliente: "+cliente.getNombre()+" "+cliente.getApellido();
//		ArrayList<Mueble> listaMuebles=(new MultiJuego().buscarMuebleddeJuego(idJuego));
//		for(int i=0;i<listaMuebles.size();i++){
//			Mueble m=listaMuebles.get(i);
//			msj+="\n Mueble"+i+": "+ m.toString();
//				
//		}
//		
//		
//	}

}
