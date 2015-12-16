/*
	Autor: Daniel Chaves
	Descripcion: Clase MultiVenta
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:
	 */

import java.text.SimpleDateFormat;
import java.util.*;

public class MultiVenta {

	public Venta crear(int idDistribuidor,int idJuego, int idCliente)throws Exception{
		Venta  venta=null;
		String sql;
		venta = new Venta(idDistribuidor,idJuego, idCliente);
		sql="INSERT INTO TbVenta (id, fecha, idCliente, idDistribuidor, idJuego, consecutivo, switCh, monto) " +
		" VALUES (" + venta.getId() + ","
				+ "'" + (new SimpleDateFormat()).format(venta.getFecha()) +"',"
				+ venta.getIdCliente()+","
				+ venta.getIdDistribuidor() +"," 
				+ venta.getIdJuego() + ","
				+ Venta.getConsecutivo() + "," 
				+ venta.getSwitCh() +","
				+ venta.getMonto()+")";
		try {
			Conector.getConector().ejecutarSQL(sql);
			
		}
		catch (Exception e) {
			venta = null;
			e.printStackTrace();
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
		sql = "SELECT * "+
		"FROM TbVenta "+
		"WHERE id = "+idVenta+""; 
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			venta = new Venta(
				rs.getInt("id"),
				(new SimpleDateFormat()).parse(rs.getString("fecha")),
				rs.getInt("idCliente"),
				rs.getInt("idDistribuidor"),
				rs.getInt("idJuego"),
				rs.getInt("consecutivo"),
				rs.getInt("switCh"),
				rs.getDouble("monto")
				);
		} else {
			venta = null;
		}
		rs.close();
		return venta; 
	}
}
