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
	
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que consulta los datos de una venta
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:
	 */
	public Venta buscar(int idVenta)throws Exception{
		Venta venta;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT id,idCliente,idDistribuidor"+
		"FROM TVenta "+
		"WHERE Id = '"+idVenta+"'";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			venta = new Venta(
				rs.getInt("idCLiente"),
				rs.getInt("idJuego"));
		} else {
			venta = null;
		}
		rs.close();
		return venta; 
	}
}
