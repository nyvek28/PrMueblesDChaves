import java.util.TreeMap;

public class Bajo extends Mueble{

	private double alturaSobreSuelo;
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor inicial de Mueble Bajo
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public Bajo(int idFabricante, int plinea, String pcolor, double ancho, double alto, double largo, double precio,double alturaSobreSuelo) {
		super(idFabricante,plinea, pcolor, ancho, alto, largo, 1, precio);
		this.setAlturaSobreSuelo(alturaSobreSuelo);
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor absoluto de Mueble Bajo
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public Bajo(int id, int idFabricante, int linea, String color, double ancho, double alto, double largo, int categoria, double precio, int switCh, int idJuego,
			int idDistribuidor, int vendido, double alturaSobreSuelo){
		super(id,idFabricante,linea,color,ancho,alto,largo,categoria,precio,switCh,idJuego,idDistribuidor,vendido);
		this.setAlturaSobreSuelo(alturaSobreSuelo); 
	}
	
	public TreeMap<String,String> toTreeMap(){
		
		TreeMap<String,String> datos;
		
		datos = super.toTreeMap();
		datos.put("alturaSobreSuelo", String.valueOf(this.getAlturaSobreSuelo()));
		
		return datos;
		
	}
	
	public double calcularCosto(){
		
		double total;
		
		total = this.getPrecio() + (this.getAlturaSobreSuelo() * 2.3 / 100);
		
		return total;
		
	}

	public double getAlturaSobreSuelo() {
		return alturaSobreSuelo;
	}

	public void setAlturaSobreSuelo(double alturaSobreSuelo) {
		this.alturaSobreSuelo = alturaSobreSuelo;
	}
	
}
