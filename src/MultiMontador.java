import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MultiMontador {

	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo que crea un objeto montador y lo guarda el base de datos
	Version: v.1.0
	Fecha: Dic 3, 2015
	Ediciones:

	*/
	public Montador crear(int id, String pNombre, String pApellido, int pTelefono, String pDireccion){
		
		Montador m;
		String sql;
		
		m = new Montador(id,pNombre, pApellido, pTelefono, pDireccion);
		sql = "INSERT INTO TbMontador "
			+ "VALUES ("
			+ m.getId()+","
			+ "'"+m.getNombre()+"',"
			+"'"+m.getApellido()+"',"
			+m.getTelefono()+","
			+"'"+m.getDireccion()+"',"
			+m.getSwitCh()+")";
		try {
			Conector.getConector().ejecutarSQL(sql);
		} catch (Exception ex) {
			System.out.println("Error en el conector de crear Montador \n");
			m = null;
			ex.printStackTrace();
		}
		
		return m;
		
	}
	
	/*
	Autor: Emilio Montero 
	Descripcion: Metodo que busca la informacion de un objeto Montador mediante su id y lo 
	crea basado en esa info
	Version: v.1.0
	Fecha: Dic 3, 2015
	Ediciones:

	*/
	public Montador buscar(int id) throws SQLException, Exception{
		
		Montador m;
		String sql;
		ResultSet rs;
		
		sql = "SELECT * "
			+ "FROM TbMontador "
			+ "WHERE id = "+id
			+ " AND switch != 0";
		rs = Conector.getConector().ejecutarSQL(sql, true);
		if(rs.next()){
			m = new Montador(
					rs.getInt("id"),
					rs.getString("nombre"),
					rs.getString("apellido"),
					rs.getInt("telefono"),
					rs.getString("direccion"));
		}else{
			m = null;
		}
		
		return m;
		
	}
	
	/*
	Autor: Emilio Montero 
	Descripcion: Metodo que busca la informacion de un objeto Montador mediante su nombre y lo 
	crea basado en esa info
	Version: v.1.0
	Fecha: Dic 3, 2015
	Ediciones:

	*/
	
	public Montador buscar(String nombre) throws SQLException, Exception{
		
		Montador m;
		String sql;
		ResultSet rs;
		
		sql = "SELECT * "
			+ "FROM TbMontador "
			+ "WHERE nombre = "+nombre
			+ " AND switch != 0";
		rs = Conector.getConector().ejecutarSQL(sql, true);
		if(rs.next()){
			m = new Montador(
					rs.getInt("id"),
					rs.getString("nombre"),
					rs.getString("apellido"),
					rs.getInt("telefono"),
					rs.getString("direccion"));
		}else{
			m = null;
		}
		
		return m;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo que actualiza un objeto Montador que se le envie
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public Montador modificar(Montador m){
		
		String sql;
		
		sql = " UPDATE TbMontador "
			+ " SET "
			+ " id = "+m.getId()+","
			+ " nombre = '"+m.getNombre()+"',"
			+ " apellido = '"+m.getApellido()+"',"
			+ " telefono = "+m.getTelefono()+","
			+ " direccion = '"+m.getDireccion()+"',"
			+ " switCh = "+m.getSwitCh()+" "
			+ " WHERE id = "+m.getId();
		try {
			Conector.getConector().ejecutarSQL(sql);
		} catch (Exception e) {
			m = null;
			e.printStackTrace();
		}
		
		return m;
		
	}

}
