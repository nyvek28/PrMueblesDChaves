
/*
 * Autor: Daniel Chaves
 * Descripcion: crea un objeto Juego y sus accesores
 * Version 1.0
 * Fecha: Dic 4, 2015
	Ediciones:
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MultiJuego {
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que crear juego en BD
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:
	 */
	public Juego crear(int pidMontador, int idDistribuidor)throws Exception{
		
		Juego juego=null;
		String sql;
		juego = new Juego(pidMontador, idDistribuidor);
		sql="INSERT INTO TbJuego (id,idMontador,consecutivo,switCh,idDistribuidor) "+
		" VALUES ("
				+juego.getId() + ","
				+pidMontador + ","
				+Juego.getConsecutivo() + ","
				+juego.getSwitCh() + ","
				+juego.getIdDistribuidor() + " "
				+")";
		try {
			Conector.getConector().ejecutarSQL(sql);	
		}
		catch (Exception e) {
			System.out.println("Error en el conector de crear Juego \n");
			juego=null;
			e.printStackTrace();
		}
		return juego;
	
	}
	/*
	Autor: Daniel Chaves
	Descripcion: Metodo que busca juego en BD
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:
	 */
	public  Juego buscarid(int pid) throws java.sql.SQLException,Exception{
		
		Juego juego;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT id,idMontador, switCh "+
		"FROM TbJuego "+
		"WHERE Id = '"+pid+"'";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			juego = new Juego(
					rs.getInt("id"),
					rs.getInt("idMontador"),
					rs.getInt("switCh"),
					rs.getInt("idDistribuidor")
					);
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
	
	public ArrayList<Juego> buscarD(int idDistribuidor) throws SQLException, Exception{
		
		ResultSet rs;
		String sql;
		ArrayList<Juego> juegos = new ArrayList<Juego>();
		
		sql = "SELECT * "
			+ "FROM TbJuego "
			+ "WHERE idDistribuidor = "+idDistribuidor;
		rs = Conector.getConector().ejecutarSQL(sql, true);
		while(rs.next()){
			juegos.add(this.buscarid(rs.getInt("id")));
		}
		if(juegos.size() < 1){
			juegos = null;
		}
		
		return juegos;
		
		
	}
	
	public ArrayList<Juego> listar() throws Exception{
		
		Juego f;
		String sql;
		ResultSet rs; 
		ArrayList<Juego> tabla = new ArrayList<Juego>();
		
		sql = "SELECT * "
			+ "FROM TbJuego ";
		rs = Conector.getConector().ejecutarSQL(sql, true);
		while(rs.next()){
			f = new Juego(
					rs.getInt("id"),
					rs.getInt("idMontador"),
					rs.getInt("switCh"),
					rs.getInt("idDistribuidor")
					);
			tabla.add(f);
		}
		if(tabla.size()<1){
			tabla = null;
		}
		
		return tabla;
		
	}


}
