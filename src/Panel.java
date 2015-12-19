import java.util.TreeMap;

public class Panel extends Mueble{

	private int acabado;

	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor inicial de Mueble Panel
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public Panel(int idFabricante ,int plinea, String pcolor, double ancho, double alto, double largo, double precio, int acabado) {
		super(idFabricante, plinea, pcolor, ancho, alto, largo, 3, precio);
		this.setAcabado(acabado);
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor absoluto de Mueble Panel
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public Panel(int id, int idFabricante, int linea, String color, double ancho, double alto, double largo, int categoria, double precio, int switCh, int idJuego,
			int idDistribuidor, int vendido,int acabado){
		super(id,idFabricante,linea,color,ancho,alto,largo,categoria,precio,switCh,idJuego,idDistribuidor,vendido);
		this.setAcabado(acabado);
	}
	
	public String acabadoToString(){
		
		String acabado;
		String[] acabados = {"Regular","Normal","Fino","Muy Fino"};
		
		acabado = acabados[this.getAcabado()];
		
		return acabado;
		
	}
	
	public TreeMap<String,String> toTreeMap(){
		
		TreeMap<String,String> datos;
		
		datos = super.toTreeMap();
		datos.put("tipo", this.acabadoToString());
		
		return datos;
		
	}
	
	public double calcularCosto(){
		
		double total;
		
		if(this.getAcabado() == 0){
			total = this.getPrecio() + (this.getPrecio() * 1.2 / 100);
		}else if(this.getAcabado() == 1){
			total = this.getPrecio() + (this.getPrecio() * 2.3 / 100);
		}else if(this.getAcabado() == 2){
			total = this.getPrecio() + (this.getPrecio() * 3.4 / 100);
		}else{
			total = this.getPrecio() + (this.getPrecio() * 4.2 / 100);
		}
		
		return total;
		
	}
	
	public int getAcabado() {
		return acabado;
	}

	public void setAcabado(int acabado) {
		this.acabado = acabado;
	}
		
}
