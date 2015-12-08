
public class Bajo extends Mueble{

	private double alturaSobreSuelo;
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor inicial de Mueble Bajo
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public Bajo(int plinea, String pcolor, double ancho, double alto, double largo, int pcategoria, double precio,double alturaSobreSuelo) {
		super(plinea, pcolor, ancho, alto, largo, pcategoria, precio);
		this.setAlturaSobreSuelo(alturaSobreSuelo);
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor absoluto de Mueble Bajo
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public Bajo(int id, int linea, String color, double ancho, double alto, double largo, int categoria, double precio, 
			int switCh, int idJuego, double alturaSobreSuelo){
		super(id,linea,color,ancho,alto,largo,categoria,precio,switCh,idJuego);
		this.setAlturaSobreSuelo(alturaSobreSuelo); 
	}

	public double getAlturaSobreSuelo() {
		return alturaSobreSuelo;
	}

	public void setAlturaSobreSuelo(double alturaSobreSuelo) {
		this.alturaSobreSuelo = alturaSobreSuelo;
	}
	
}
