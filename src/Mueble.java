
/*
 * author: Daniel Chaves
 * Descripcion: Clase mueble y sus accesores
 * Version 1.0
 * Fecha: Dic 4, 2015
	Ediciones:
 */


public class Mueble {

	public int id;
	
	public int linea;
	public String color;
	public double[] dimensiones;
	public String categoria;
	public int switCh;
	
	public Mueble(int pid,int plinea, String pcolor, double ancho, double alto, double largo, String pcategoria){
		this.setId(pid);
		this.setLinea(plinea);
		this.setColor(pcolor);
		this.setDimensiones(ancho, alto, largo);
		this.setCategoria(pcategoria);
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getSwitCh() {
		return switCh;
	}
	public void setSwitCh(int switCh) {
		this.switCh = switCh;
	}
}
