
public class Encimera extends Mueble{

	private int tipo;
	private double espesor;
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor inicial de Mueble Encimera
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public Encimera(int idFabricante ,int plinea, String pcolor, double ancho, double alto, double largo, double precio, int tipo,
			double espesor) {
		super(idFabricante, plinea, pcolor, ancho, alto, largo, 2, precio);
		this.setTipo(tipo);
		this.setEspesor(espesor);
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor absoluto de Mueble Encimera
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public Encimera(int id, int idFabricante, int linea, String color, double ancho, double alto, double largo, int categoria, double precio, int switCh, int idJuego,
			int idDistribuidor, int vendido, int tipo, double espesor){
		super(id,idFabricante,linea,color,ancho,alto,largo,categoria,precio,switCh,idJuego,idDistribuidor,vendido);
		this.setTipo(tipo);
		this.setEspesor(espesor);
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que interpreta el tipo de la clase
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public String tipoToString(){
		
		String tipo;
		String[] tipos = {"Marmol","Aglomerado"};
		
		tipo = tipos[this.getTipo()];
		
		return tipo;
		
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public double getEspesor() {
		return espesor;
	}
	
	public void setEspesor(double espesor) {
		this.espesor = espesor;
	}
	
}
