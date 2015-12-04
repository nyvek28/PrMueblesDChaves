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
		
	public Mueble crear(int pid,int plinea, String pcolor, double ancho, double alto, double largo, String pcategoria)throws Exception{
		Mueble mueble=null;
		String sql;
		sql="INSERT INTO TLibro "+
		"VALUES ('"+pid+"','"+plinea+"', '"+pcolor+"','"+ancho+"','"+alto+"','"+largo+"''"+pcategoria+"');";
		try {
			Conector.getConector().ejecutarSQL(sql);
			mueble = new Mueble(pid,plinea,pcolor, ancho, alto, largo, pcategoria);
		}
		catch (Exception e) {
			throw new Exception (".");
		}
		return mueble;
	}
	public  Mueble buscarid(int pid) throws java.sql.SQLException,Exception{
		
		Mueble mueble;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT id,linea,color,ancho,alto,largo,categoria "+
		"FROM TLibro "+
		"WHERE Isbn = '"+pid+"'";
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
public ArrayList<Mueble> buscarM(int idJuego) throws SQLException, Exception{
	
	ResultSet rs;
	String sql;
	ArrayList<Mueble> muebles = new ArrayList<Mueble>();
	
	sql = "SELECT * "
		+ "FROM TbJuego "
		+ "WHERE idJuego = "+idJuego;
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


