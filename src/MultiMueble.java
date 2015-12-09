import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * author: Daniel Chaves
 * Descripcion: crea un objeto mueble y lo guarda en base de datos
 * Version 1.0
 * Fecha: Dic 4, 2015
	Ediciones:
 */


import java.util.*;

public class MultiMueble {
		
	public Mueble crear(int plinea, String pcolor, double ancho, double alto, double largo, int pcategoria, double precio){
		Mueble m;
		String sql;
		
		m = new Alto(plinea,pcolor,ancho,alto,largo,pcategoria,precio);
		sql = "INSERT INTO TbMueble (id, linea, color, ancho, alto, largo, categoria, switch, idJuego, precio, consecutivo)"
			+ " VALUES( "
			+ m.getId() + ","
			+ m.getLinea() + ","
			+ "'" + m.getColor() + "',"
			+ m.getDimensiones()[0] + ","
			+ m.getDimensiones()[1] + ","
			+ m.getDimensiones()[2] + ","
			+ m.getCategoria() + ","
			+ m.getSwitCh() + ","
			+ m.getIdJuego() + ","
			+ m.getPrecio() + ","
			+ Mueble.getConsecutivo()
			+ " )";
		try {
			Conector.getConector().ejecutarSQL(sql);
		} catch (Exception e) {
			//m = null;
			e.printStackTrace();
		}
		
		return m;
	}
	
	
	
	public  Mueble buscarid(int pid) throws java.sql.SQLException,Exception{
		
		Mueble mueble;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT * "+
		"FROM TLibro "+
		"WHERE Isbn = '"+pid+"'";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			mueble = null;
		} else {
			mueble = null;
		}
		rs.close();
		return mueble; 
	}
	public  Mueble buscaridJ(int pid) throws java.sql.SQLException,Exception{
		
		Mueble mueble;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT id,idMontador,idMueble1,idMueble2,idMueble3,idMueble4 "+
		"FROM TMueble "+
		"WHERE IdJuego = '"+pid+"'";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			mueble = new Mueble(
				rs.getInt("id"),
				rs.getInt("linea"),
				rs.getString("color"),
				rs.getDouble("ancho"),
				rs.getDouble("alto"),
				rs.getDouble("largo"),
				rs.getString("categoria"));
		} else {
			mueble = null;
		}
		rs.close();
		return mueble; 
	}
	
	
	public ArrayList<Mueble> buscarF(int linea) throws SQLException, Exception{
		
		ResultSet rs;
		String sql;
		ArrayList<Mueble> muebles = new ArrayList<Mueble>();
		
		sql = "SELECT * "
			+ "FROM TbMueble "
			+ "WHERE linea = "+linea;
		rs = Conector.getConector().ejecutarSQL(sql, true);
		while(rs.next()){
			muebles.add(this.buscarid(rs.getInt("id")));
		}
		if(muebles.size() < 1){
			muebles = null;
		}
		
		return muebles;
		
	}
	
}


