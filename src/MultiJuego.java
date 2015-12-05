<<<<<<< Updated upstream
/*
 * author: Daniel Chaves
 * Descripcion: crea un objeto Juego y sus accesores
 * Version 1.0
 * Fecha: Dic 4, 2015
	Ediciones:
 */
=======
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MultiJuego {
	
	public Juego crear(int pid, int pidMontador)throws Exception{
		
		Juego juego=null;
		String sql;
		sql="INSERT INTO TLibro "+
		"VALUES ('"+pid+"','"+pidMontador+"', );";
		try {
			Conector.getConector().ejecutarSQL(sql);
			juego = new Juego(pid,pidMontador);
		}
		catch (Exception e) {
			throw new Exception (".");
		}
		return juego;
	
	}
	public  Juego buscarid(int pid) throws java.sql.SQLException,Exception{
		
		Juego juego;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT id,idMontador,idMueble1,idMueble2,idMueble3,idMueble4 "+
		"FROM TJuego "+
		"WHERE Id = '"+pid+"'";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			juego = new Juego(
				rs.getInt("id"),
				rs.getInt("idMontador"));
		} else {
			juego = null;
		}
		rs.close();
		return juego; 
	}
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para buscar los juegos de un montador
	Version: v.1.0
	Fecha: Dic 4, 2015
	Ediciones:
	-Kevyn
		Dic 4, 2015
		Se arreglo el parametro de idJuego a idMontador

	*/
	public ArrayList<Juego> buscarM(int idMontador) throws SQLException, Exception{
		
		ResultSet rs;
		String sql;
		ArrayList<Juego> juegos = new ArrayList<Juego>();
		
		sql = "SELECT * "
			+ "FROM TbJuego "
			+ "WHERE idMontador = "+idMontador;
		rs = Conector.getConector().ejecutarSQL(sql, true);
		while(rs.next()){
			juegos.add(this.buscarid(rs.getInt("id")));
		}
		if(juegos.size() < 1){
			juegos = null;
		}
		
		return juegos;
		
		
	}


}
