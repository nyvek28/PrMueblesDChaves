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
	private static int id=0;
	private String msj;
	private int idCliente;
	
	public static int getId() {
		return id;
	}
	public static void setId() {
		id=id+1;
	}
	public Venta(int pidJuego,int pidCliente ){
		this.setIdCliente(pidCliente);
		this.setIdJuego(pidJuego);
		this.setId();
		
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
