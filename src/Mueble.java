
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
	private int categoria;// 0 = alto, 1 = bajo, 2 = encimera, 4 = panel
	private int switCh;
	private int idJuego;
	private static int consecutivo = 0;
	
	/*
	Autor: Daniel Chaves
	Descripcion: Constructor inicial de Mueble
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:
		-Kevyn Quiros, Dic 7,2015

	*/
	public Mueble(int plinea, String pcolor, double ancho, double alto, double largo, int pcategoria){
		Mueble.setConsecutivo(Mueble.getConsecutivo()+1);
		this.setId(Mueble.getConsecutivo());
		this.setLinea(plinea);
		this.setColor(pcolor);
		this.setDimensiones(ancho, alto, largo);
		this.setCategoria(pcategoria);
		this.setIdJuego(-1);
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor absoluto de Mueble
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public Mueble(int id, int linea, String color, double ancho, double alto, double largo, int categoria, int switCh, int idJuego){
		
		this.setId(id);
		this.setLinea(linea);
		this.setColor(color);
		this.setDimensiones(ancho, largo, alto);
		this.setCategoria(categoria);
		this.setSwitCh(switCh);
		this.setIdJuego(idJuego);
		
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
		dimensiones[0]=alto;
		dimensiones[1]=largo;
		dimensiones[2]=alto;
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
}
