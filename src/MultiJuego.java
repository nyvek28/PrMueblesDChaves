
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
	public Juego crear(int pid, int pidMontador)throws Exception{
		
		Juego juego=null;
		String sql;
		juego = new Juego(pid,pidMontador);
		sql="INSERT INTO TbJuego "+
		"VALUES ("+pid+","+pidMontador+","+juego.getConsecutivo()+","+juego.getSwitCh()+")";
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
		sql = "SELECT id,idMontador "+
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
	Autor: Daniel Chaves
	Descripcion: Metodo que buesca mueble de juego en BD
	Version: v.1.0
	Fecha: Dic 7, 2015
	Ediciones:
	 */
	public ArrayList<Mueble> buscarMuebleddeJuego(int pid)throws java.sql.SQLException,Exception{
		java.sql.ResultSet rs;
		String sql;
		Mueble m;
		String msj="";
		ArrayList<Mueble> listaMueble= new ArrayList<Mueble>();
		sql = "SELECT id,linea,color,ancho,alto,largo,categoria "+
		"FROM TMueble "+
		"WHERE IdJuego = '"+pid+"'";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		while(rs.next()){
			m= new Mueble(
					rs.getInt("id"),
					rs.getString("linea"),
					rs.getString("color"),
					rs.getDouble("ancho"),
					rs.getDouble("alto"),
					rs.getDouble("largo"),
					rs.getString("categoria"));
			listaMueble.add(m);
			
		}
		return listaMueble;
		
		
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
