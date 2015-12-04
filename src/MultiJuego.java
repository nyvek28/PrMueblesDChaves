/*
 * author: Daniel Chaves
 * Descripcion: crea un objeto Juego y sus accesores
 * Version 1.0
 * Fecha: Dic 4, 2015
	Ediciones:
 */
public class MultiJuego {
	
	public Juego crear(int pid, int pidMontador, int idMueble1, int idMueble2, int idMueble3, int idMueble4)throws Exception{
		
		Juego juego=null;
		String sql;
		sql="INSERT INTO TLibro "+
		"VALUES ('"+pid+"','"+pidMontador+"', '"+idMueble1+"','"+idMueble2+"','"+idMueble3+"','"+idMueble4+"');";
		try {
			Conector.getConector().ejecutarSQL(sql);
			juego = new Juego(pid,pidMontador,idMueble1);
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
				rs.getInt("idMontador"),
				rs.getInt("idMueble1"));
		} else {
			juego = null;
		}
		rs.close();
		return juego; 
	}


}
