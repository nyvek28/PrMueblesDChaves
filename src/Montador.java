import java.util.ArrayList;

public class Montador extends Persona{
	
	private ArrayList<Juego> juegos;

	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor inicial de la clase montador
	Version: v.1.0
	Fecha: Dic 4, 2015
	Ediciones:

	*/
	public Montador(int pId, String pNombre, String pApellido, int pTelefono, String pDireccion){
		
		super(pId, pNombre, pApellido, pTelefono, pDireccion);
		this.setJuegos(null);
		
	}
	public void modificarJuego(int idJuego, int idMueble,int idmuebleEliminar)throws Exception{
		Juego juego=(new MultiJuego().buscarid(idJuego));
		
		
		
	}

	public ArrayList<Juego> getJuegos(){
		ArrayList<Juego> j;
		
		try {
			j = (new MultiJuego()).buscarM(this.getId());
		} catch (Exception e) {
			j = null;
		}
		
		return j;
	}

	public void setJuegos(ArrayList<Juego> juegos) {
		this.juegos = juegos;
	}
	
	//Daniel Chaves
	public Juego crearJuego(int pid)throws Exception{
		
		Juego juego=(new MultiJuego()).crear(pid, super.getId());
		
		return juego;
	}
	
}
