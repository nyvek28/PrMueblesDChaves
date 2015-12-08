
public class Alto extends Mueble{

	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor inicial de Mueble Alto
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public Alto(int plinea, String pcolor, double ancho, double alto, double largo, int pcategoria, double precio) {
		super(plinea, pcolor, ancho, alto, largo, pcategoria, precio);
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor absoluto de Mueble Alto
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public Alto(int id, int linea, String color, double ancho, double alto, double largo, int categoria, double precio, 
			int switCh, int idJuego){
		super(id,linea,color,ancho,alto,largo,categoria,precio,switCh,idJuego);
	}

}
