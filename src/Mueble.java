import java.util.TreeMap;

/*
 * author: Daniel Chaves
 * Descripcion: Clase mueble y sus accesores
 * Version 1.0
 * Fecha: Dic 4, 2015
	Ediciones:
 */


public class Mueble {

	private int id;
	private int linea;
	private String color;
	private double[] dimensiones;
	private int categoria;// 0 = alto, 1 = bajo, 2 = encimera, 3 = panel
	private int switCh;
	private int idJuego;
	private double precio;
	private static int consecutivo = 0;
	private int idDistribuidor;
	private int idFabricante;
	private int vendido;
	
	/*
	Autor: Daniel Chaves
	Descripcion: Constructor inicial de Mueble
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:
		-Kevyn Quiros, Dic 7,2015

	*/
	public Mueble(int idFabricante ,int plinea, String pcolor, double ancho, double alto, double largo, int pcategoria, double precio){
		
		Mueble.setConsecutivo(Mueble.getConsecutivo()+1);
		this.setId(Mueble.getConsecutivo());
		this.setLinea(plinea);
		this.setColor(pcolor);
		this.setDimensiones(ancho, alto, largo);
		this.setCategoria(pcategoria);
		this.setPrecio(precio);
		this.setIdJuego(-1);
		this.setSwitCh(1);
		this.setIdDistribuidor(-1);
		this.setIdFabricante(idFabricante);
		this.setVendido(0);
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor absoluto de Mueble
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public Mueble(int id, int idFabricante, int linea, String color, double ancho, double alto, double largo, int categoria, double precio, int switCh, int idJuego,
			int idDistribuidor, int vendido){
		
		this.setId(id);
		this.setIdFabricante(idFabricante);
		this.setLinea(linea);
		this.setColor(color);
		this.setDimensiones(ancho, largo, alto);
		this.setCategoria(categoria);
		this.setPrecio(precio);
		this.setSwitCh(switCh);
		this.setIdJuego(idJuego);
		this.setIdDistribuidor(idDistribuidor);
		this.setVendido(vendido);
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que interpreta la categoria del mueble
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public String categoriaToString(){
		
		String categoria;
		String[] categorias = {"Alto","Bajo","Encimera","Panel"};
		
		categoria = categorias[this.getCategoria()];
		
		return categoria;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que clacula el precio del mueble
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public double calcularCosto(){
		
		return this.getPrecio();
		
	}
	
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que convierte un mueble en un treemap
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:

	*/
	public TreeMap<String, String> toTreeMap(){
		
		TreeMap<String,String> datosMueble = new TreeMap<String,String>();
		
		datosMueble.put("id", String.valueOf(this.getId()));
		datosMueble.put("linea", String.valueOf(this.getLinea()));
		datosMueble.put("color", String.valueOf(this.getColor()));
		datosMueble.put("ancho", String.valueOf(this.getDimensiones()[0]));
		datosMueble.put("alto", String.valueOf(this.getDimensiones()[2]));
		datosMueble.put("largo", String.valueOf(this.getDimensiones()[1]));
		datosMueble.put("categoria", String.valueOf(this.getCategoria()));
		datosMueble.put("idJuego", String.valueOf(this.getIdJuego()));
		datosMueble.put("idDistribuidor", String.valueOf(this.getIdDistribuidor()));
		datosMueble.put("idFabricante", String.valueOf(this.getIdFabricante()));
		
		return datosMueble;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLinea() {
		return linea;
	}
	public void setLinea(int linea) {
		this.linea = linea;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double[] getDimensiones() {
		return dimensiones;
	}
	public void setDimensiones(double ancho, double largo, double alto) {
		double[] a = {ancho,alto,largo};
		this.dimensiones = a;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
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



	public static void setConsecutivo(int consecutivo) {
		Mueble.consecutivo = consecutivo;
	}



	public int getIdJuego() {
		return idJuego;
	}



	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}



	public void setDimensiones(double[] dimensiones) {
		this.dimensiones = dimensiones;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getIdDistribuidor() {
		return idDistribuidor;
	}

	public void setIdDistribuidor(int idDistribuidor) {
		this.idDistribuidor = idDistribuidor;
	}

	public int getVendido() {
		return vendido;
	}

	public void setVendido(int vendido) {
		this.vendido = vendido;
	}

	public int getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(int idFabricante) {
		this.idFabricante = idFabricante;
	}
}
