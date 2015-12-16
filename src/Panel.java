
public class Panel extends Mueble{

	private int acabado;

	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor inicial de Mueble Panel
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public Panel(int plinea, String pcolor, double ancho, double alto, double largo, int pcategoria, double precio, int acabado) {
		super(plinea, pcolor, ancho, alto, largo, pcategoria, precio);
		this.setAcabado(acabado);
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Constructor absoluto de Mueble Panel
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:

	*/
	public Panel(int id, int linea, String color, double ancho, double alto, double largo, int categoria, double precio, 
			int acabado, int switCh, int idJuego){
		super(id,linea,color,ancho,alto,largo,categoria,precio,switCh,idJuego);
		this.setAcabado(acabado);
	}
	
	public String acabadoToString(){
		
		String acabado;
		String[] acabados = {"Regular","Normal","Fino","Muy Fino"};
		
		acabado = acabados[this.getAcabado()];
		
		return acabado;
		
	}
	
	public int getAcabado() {
		return acabado;
	}

	public void setAcabado(int acabado) {
		this.acabado = acabado;
	}
		
}
