/*
	Autor: Daniel Chaves
	Descripcion: Clase MultiVenta
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:
	 */



public class MultiVenta {

	public Venta crear(int idJuego, int idCliente, String fecha)throws Exception{
		Venta  venta=null;
		String sql;
		venta = new Venta(idJuego, idCliente, fecha);
		sql="INSERT INTO TbVenta "+
		"VALUES ('"+venta.getId()+"','"+fecha+"','"+idCliente+"','"
				+venta.getIdDistribuidor()
				+"','"+idJuego+"','"
				+venta.getConsecutivo()
				+"','"+venta.getSwitCh()+"');";
		try {
			Conector.getConector().ejecutarSQL(sql);
			
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
		sql = "SELECT id,fecha,idCliente,idDistribuidor, idJuego, consecutivo, switCh "+
		"FROM TbVenta "+
		"WHERE id = "+idVenta+""; 
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			venta = new Venta(
				rs.getInt("id"),
				rs.getString("fecha"),
				rs.getInt("idCliente"),
				rs.getInt("idDistribuidor"),
				rs.getInt("idJuego"),
				rs.getInt("consecutivo"),
				rs.getInt("switCh"));
		} else {
			venta = null;
		}
		rs.close();
		return venta; 
	}
}
