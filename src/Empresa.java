
public class Empresa {

	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para que la empresa registre un Fabricante
	Version: v.1.0
	Fecha: Dic 4, 2015
	Ediciones:

	*/
	public static Fabricante registrarFabricante(String pNombre, String pApellido, int pTelefono, String pDireccion,
			int linea, int annos){
		
		Fabricante f;
		
		f = (new MultiFabricante()).crear(pNombre, pApellido, pTelefono, pDireccion, linea, annos);
		
		return f;
		
	}
	public static Mueble consultarMueble(int idMueble)throws Exception{
		Mueble mueble;
		mueble=(new MultiMueble()).buscarid(idMueble);
		return mueble;
		
	}
	
}
