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
	private int idCliente;
	private int switCh;
	private int IdDistribuidor;
	private double monto;
	private Juego juego;
	private Cliente cliente;
	private Distribuidor distribuidor;
	
	
	
	public Venta(Distribuidor d, Juego j, Cliente c ) throws SQLException, Exception{
		
		this.setIdCliente(c.getId());
		this.setIdDistribuidor(d.getId());
		this.setIdJuego(j.getId());
		this.setFecha((new SimpleDateFormat()).parse((new SimpleDateFormat()).format(new Date())));
		Venta.setConsecutivo(consecutivo++);
		this.setId(Venta.getConsecutivo());
		this.setMonto(d.calcularCostoJuego(this.getIdJuego()));
		this.setSwitCh(1);
		this.setCliente(null);
		this.setDistribuidor(null);
		this.setJuego(null);
		
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
		this.setCliente(null);
		this.setDistribuidor(null);
		this.setJuego(null);
		
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
	
	public Juego getJuego() throws SQLException, Exception {
		Juego j;
		
		j = (new MultiJuego()).buscarid(this.getIdJuego());
		
		return j;
	}
	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	public Cliente getCliente() throws SQLException, Exception {
		Cliente c;
		
		c = (new MultiCliente()).buscar(this.getIdCliente());
		
		return c;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Distribuidor getDistribuidor() throws SQLException, Exception {
		Distribuidor d;
		
		d = (new MultiDistribuidor()).buscar(this.getIdDistribuidor());
		
		return d;
	}
	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
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
