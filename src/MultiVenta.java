/*
	Autor: Daniel Chaves
	Descripcion: Clase MultiVenta
	Version: v.1.0
	Fecha: Dic 5, 2015
	Ediciones:
	 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MultiVenta {

	public Venta crear(Distribuidor d, Juego j, Cliente c)throws Exception{
		Venta  venta=null;
		String sql;
		venta = new Venta(d,j, c);
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
	
	public ArrayList<Venta> buscarD(int idDistribuidor) throws SQLException, Exception{
		
		ArrayList<Venta> ventas = new ArrayList<Venta>();
		ResultSet rs;
		String sql;
		
		sql = "SELECT * "
			+ "FROM TbVenta "
			+ "WHERE idDistribuidor = " + idDistribuidor;
		rs = Conector.getConector().ejecutarSQL(sql, true);
		while(rs.next()){
			ventas.add(this.buscar(rs.getInt("id")));
		}
		if(ventas.isEmpty()){
			ventas = null;
		}
		
		return ventas;
		
	}
	
}
