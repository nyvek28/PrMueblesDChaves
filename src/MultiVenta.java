/*
	Autor: Daniel Chaves
	Descripcion: Clase MultiVenta
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:
	 */



public class MultiVenta {

	public Venta crear(int idJuego, int idCliente)throws Exception{
		Venta  venta=null;
		String sql;
		sql="INSERT INTO TVenta "+
		"VALUES ('"+idJuego+"','"+idCliente+"');";
		try {
			Conector.getConector().ejecutarSQL(sql);
			venta = new Venta(idJuego, idCliente);
		}
		catch (Exception e) {
			throw new Exception (".");
		}
		return venta;
	
	
	
	}
}
