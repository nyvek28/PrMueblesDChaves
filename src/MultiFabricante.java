import java.sql.ResultSet;
import java.sql.SQLException;

public class MultiFabricante {

	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que crea un objeto fabricante y lo guarda el base de datos
	Version: v.1.0
	Fecha: Dic 3, 2015
	Ediciones:

	*/
	public Fabricante crear(int pId, String pNombre, String pApellido, int pTelefono, String pDireccion,
			int linea, int annos){
		
		Fabricante f;
		String sql;
		
		f = new Fabricante(pNombre, pApellido, pTelefono, pDireccion, linea, annos);
		sql = "INSERT INTO TbFabricante "
			+ "VALUES("
			+ f.getId()+","
			+ "'"+f.getNombre()+"',"
			+"'"+f.getApellido()+"',"
			+f.getTelefono()+"',"
			+"'"+f.getDireccion()+"',"
			+f.getSwitCh()+","
			+f.getLinea()+","
			+f.getAnnosExp()+","
			+Fabricante.getConsecutivo()
			+ ")";
		try {
			Conector.getConector().ejecutarSQL(sql);
		} catch (Exception e) {
			f = null;
		}
		
		return f;
		
	}
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que busca la informacion de un objeto fabricante mediante su id y lo 
	crea basado en esa info
	Version: v.1.0
	Fecha: Dic 3, 2015
	Ediciones:

	*/
	public Fabricante buscar(int id) throws SQLException, Exception{
		
		Fabricante f;
		String sql;
		ResultSet rs;
		
		sql = "SELECT * "
			+ "FROM TbFabricante "
			+ "WHERE id = "+id
			+ " AND switch != 0";
		rs = Conector.getConector().ejecutarSQL(sql, true);
		if(rs.next()){
			f = new Fabricante(
					rs.getInt("id"),
					rs.getString("nombre"),
					rs.getString("apellido"),
					rs.getInt("telefono"),
					rs.getString("direccion"),
					rs.getInt("switch"),
					rs.getInt("linea"),
					rs.getInt("annosExp"));
		}else{
			f = null;
		}
		
		return f;
		
	}
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que actualiza un objeto Fabricante que se le envie
	Version: v.1.0
	Fecha: Dic 3, 2015
	Ediciones:

	*/
	public Fabricante modificar(Fabricante f){
		
		String sql;
		
		sql = " UPDATE TbFabricante "
			+ " SET "
			+ " id = "+f.getId()
			+ " nombre = "+f.getNombre()
			+ " apellido = "+f.getApellido()
			+ " telefono = "+f.getTelefono()
			+ " direccion = "+f.getDireccion()
			+ " switch = "+f.getSwitCh()
			+ " linea = "+f.getLinea()
			+ " annosExp = "+f.getAnnosExp()
			+ " WHERE id = "+f.getId();
		try {
			Conector.getConector().ejecutarSQL(sql);
		} catch (Exception e) {
			f = null;
		}
		
		return f;
		
	}
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que elimina a un objeto Fabricante logicamente de la base de datos
	Version: v.1.0
	Fecha: Dic 3, 2015
	Ediciones:

	*/
	public Fabricante eliminar(Fabricante f){
		
		if(f.getSwitCh() != 0){
			f.setSwitCh(0);
			this.modificar(f);
		}else{
			f = null;
		}
		
		return f;
		
	}
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que busca un objeto Fabricante y luego lo elimina logicamente de la base de 
	datos
	Version: v.1.0
	Fecha: Dic 3, 2015
	Ediciones:

	*/
	public Fabricante eliminar(int id) throws SQLException, Exception{
		
		Fabricante f;
		
		f = this.buscar(id);
		
		if(f != null){
			f = this.eliminar(f);
		}else{
			f = null;
		}
		
		return f;
		
	}

}
