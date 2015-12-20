import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public class Fabricante extends Persona {

	private int linea;
	private int annosExp;
	private static int consecutivo =  0;
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
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para fabricar un mueble alto
	Version: v.1.0
	Fecha: Dic 3, 2015
	Ediciones:

	*/
	public Mueble fabricarMueble(String pcolor, double ancho, double alto, double largo, double precio)throws Exception{
		Mueble mueble;
		mueble=(new MultiMueble()).crear(this, pcolor, ancho, alto, largo, precio);
		return mueble;
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para fabricar un mueble bajo
	Version: v.1.0
	Fecha: Dic 3, 2015
	Ediciones:

	*/
	public Mueble fabricarMueble(String pcolor, double ancho, double alto, double largo, double precio,double alturaSobreSuelo)throws Exception{
		Mueble mueble;
		mueble=(new MultiMueble()).crear(this, pcolor, ancho, alto, largo, precio, alturaSobreSuelo);
		return mueble;
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para fabricar un mueble encimera
	Version: v.1.0
	Fecha: Dic 3, 2015
	Ediciones:

	*/
	public Mueble fabricarMueble(String pcolor, double ancho, double alto, double largo, double precio, int tipo,
			double espesor)throws Exception{
		Mueble mueble;
		mueble=(new MultiMueble()).crear(this, pcolor, ancho, alto, largo, precio, tipo, espesor);
		return mueble;
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para fabricar un mueble panel
	Version: v.1.0
	Fecha: Dic 3, 2015
	Ediciones:

	*/
	public Mueble fabricarMueble(String pcolor, double ancho, double alto, double largo, double precio, int acabado)throws Exception{
		Mueble mueble;
		mueble=(new MultiMueble()).crear(this, pcolor, ancho, alto, largo, precio, acabado);
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
	public ArrayList<Mueble> getMuebles() throws SQLException, Exception {
		ArrayList<Mueble> m;
		
		m = (new MultiMueble()).buscarF(this.getLinea());
		
		return m;
	}
	public void setMuebles(ArrayList<Mueble> muebles) {
		this.muebles = muebles;
	}
	
	/*
	Autor: Kevyn Quiros y Daniel Chaves
	Descripcion: Metodo que convierte un fabricante en un treemap
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	public TreeMap<String, String> toTreeMap(){
		
		TreeMap<String,String> datos = new TreeMap<String,String>();
		
		datos.put("id", String.valueOf(this.getId()));
		datos.put("nombre", this.getNombre());
		datos.put("apellido", this.getApellido());
		datos.put("telefono", String.valueOf(this.getTelefono()));
		datos.put("direccion", this.getDireccion());
		datos.put("linea", String.valueOf(this.getLinea()));
		datos.put("annosExp", String.valueOf(this.getAnnosExp()));
		
		return datos;
		
	}
	
}
