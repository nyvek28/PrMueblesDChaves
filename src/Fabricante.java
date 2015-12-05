import java.util.ArrayList;

public class Fabricante extends Persona {

	private int linea;
	private int annosExp;
	private static int consecutivo =  ;
	private ArrayList<Mueble> muebles;
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor inicial de la clase Fabricante
	Version: v.1.0
	Fecha: Dic 3, 2015
	Ediciones:

	*/
	public Fabricante(String pNombre, String pApellido, int pTelefono, String pDireccion,
			int linea, int annos){
		
		super((Fabricante.getConsecutivo()+1),pNombre,pApellido,pTelefono,pDireccion);
		this.setLinea(linea);
		this.setAnnosExp(annos);
		this.setMuebles(null);
		Fabricante.setConsecutivo(getConsecutivo()+1);
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor absoluto de la clase Fabricante
	Version: v.1.0
	Fecha: Dic 3, 2015
	Ediciones:

	*/
	public Fabricante(int pId, String pNombre, String pApellido, int pTelefono, String pDireccion,
			int switCh, int linea, int annos){
		
		super(pId,pNombre,pApellido,pTelefono,pDireccion,switCh);
		this.setLinea(linea);
		this.setAnnosExp(annos);
		this.setMuebles(null);
		
	}
	public Mueble fabricarMueble(int pid,int plinea, String pcolor, double ancho, double alto, double largo, String pcategoria)throws Exception{
		Mueble mueble;
		mueble=(new MultiMueble()).crear(pid, plinea, pcolor, ancho, alto, largo, pcategoria);
		return mueble;
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
