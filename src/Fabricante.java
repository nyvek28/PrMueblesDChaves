import java.util.ArrayList;

public class Fabricante extends Persona {

	private int linea;
	private int annosExp;
	private int id;
	private static int consecutivo = 0;
	private ArrayList<Mueble> muebles;
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor inicial de la clase Fabricante
	Version: v.1.0
	Fecha: Dic 3, 2015
	Ediciones:

	*/
	public Fabricante(int pId, String pNombre, String pApellido, int pTelefono, String pDireccion,
			int linea, int annos){
		
		super(pId,pNombre,pApellido,pTelefono,pDireccion);
		this.setLinea(linea);
		this.setAnnosExp(annos);
		this.setId(Fabricante.getConsecutivo()+1);
		this.setMuebles(null);
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor absoluto de la clase Fabricante
	Version: v.1.0
	Fecha: Dic 3, 2015
	Ediciones:

	*/
	public Fabricante(int pId, String pNombre, String pApellido, int pTelefono, String pDireccion,
			int switCh, int linea, int annos, int id){
		
		super(pId,pNombre,pApellido,pTelefono,pDireccion,switCh);
		this.setLinea(linea);
		this.setAnnosExp(annos);
		this.setId(id);
		this.setMuebles(null);
		
	}
	
	public int getLinea() {
		return linea;
	}
	public void setLinea(int linea) {
		this.linea = linea;
	}
	public int getAnnosExp() {
		return annosExp;
	}
	public void setAnnosExp(int annosExp) {
		this.annosExp = annosExp;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getConsecutivo() {
		return consecutivo;
	}
	public static void setConsecutivo(int consecutivo) {
		Fabricante.consecutivo = consecutivo;
	}
	public ArrayList<Mueble> getMuebles() {
		ArrayList<Mueble> m;
		
		m = (new MultiMueble()).buscarF(this.getId());
		
		return muebles;
	}
	public void setMuebles(ArrayList<Mueble> muebles) {
		this.muebles = muebles;
	}
	
}