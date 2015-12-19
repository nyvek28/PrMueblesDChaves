
public class Alto extends Mueble{

	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor inicial de Mueble Alto
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public Alto(int idFabricante ,int plinea, String pcolor, double ancho, double alto, double largo, double precio) {
		super(idFabricante, plinea, pcolor, ancho, alto, largo, 0, precio);
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor absoluto de Mueble Alto
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public Alto(int id, int idFabricante, int linea, String color, double ancho, double alto, double largo, int categoria, double precio, int switCh, int idJuego,
			int idDistribuidor, int vendido){
		super(id,idFabricante,linea,color,ancho,alto,largo,categoria,precio,switCh,idJuego,idDistribuidor,vendido);
	}

}
