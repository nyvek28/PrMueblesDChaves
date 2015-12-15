import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MultiCliente {

	/*
	Autor: Emilio Montero
	Descripcion: Metodo que crea un objeto cliente y lo guarda el base de datos
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public Cliente crear(int id, String pNombre, String pApellido, int pTelefono, String pDireccion,String trabajo, int telTrabajo){
		
		Cliente c;
		String sql;
		
		c = new Cliente(id,pNombre, pApellido, pTelefono, pDireccion,trabajo,telTrabajo);
		sql = "INSERT INTO TbCliente "
			+ "VALUES ("
			+ c.getId()+","
			+ "'"+c.getNombre()+"',"
			+"'"+c.getApellido()+"',"
			+c.getTelefono()+","
			+"'"+c.getDireccion()+"',"
			+c.getSwitCh()+","
			+"'"+c.getTrabajo()+"',"
			+c.getTelTrabajo()+")";
		try {
			Conector.getConector().ejecutarSQL(sql);
		} catch (Exception ex) {
			System.out.println("Error en el conector de crear Cliente \n");
			c = null;
			ex.printStackTrace();
		}
		
		return c;
		
	}
	
	/*
	Autor: Emilio Montero 
	Descripcion: Metodo que busca la informacion de un objeto Cliente mediante su id y lo 
	crea basado en esa info
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public Cliente buscar(int id) throws SQLException, Exception{
		
		Cliente c;
		String sql;
		ResultSet rs;
		
		sql = "SELECT * "
			+ "FROM TbCliente "
			+ "WHERE id = "+id
			+ " AND switch != 0";
		rs = Conector.getConector().ejecutarSQL(sql, true);
		if(rs.next()){
			c = new Cliente(
					rs.getInt("id"),
					rs.getString("nombre"),
					rs.getString("apellido"),
					rs.getInt("telefono"),
					rs.getString("direccion"),
					rs.getString("trabajo"),
					rs.getInt("telTrabajo"));
		}else{
			c = null;
		}
		
		return c;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo que actualiza un objeto Cliente que se le envie
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public Cliente modificar(Cliente c){
		
		String sql;
		
		sql = " UPDATE TbCliente "
			+ " SET "
			+ " id = "+c.getId()+","
			+ " nombre = '"+c.getNombre()+"',"
			+ " apellido = '"+c.getApellido()+"',"
			+ " telefono = "+c.getTelefono()+","
			+ " direccion = '"+c.getDireccion()+"',"
			+ " switCh = "+c.getSwitCh()+", "
			+ " trabajo = '"+c.getTrabajo()+"',"
			+ " telTrabajo = "+c.getTelTrabajo()+" "
			+ " WHERE id = "+c.getId();
		try {
			Conector.getConector().ejecutarSQL(sql);
		} catch (Exception e) {
			c = null;
			e.printStackTrace();
		}
		
		return c;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo que elimina a un objeto Cliente logicamente de la base de datos
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public Cliente eliminar(Cliente c){
		
		if(c.getSwitCh() != 0){
			c.setSwitCh(0);
			this.modificar(c);
		}else{
			c = null;
		}
		
		return c;
		
	}
	
	/*
	Autor: Emilio Montero
	Descripcion: Metodo para listar todos los clientes en la base de datos
	Version: v.1.0
	Fecha: Dic 15, 2015
	Ediciones:

	*/
	public ArrayList<Cliente> listar() throws Exception{
		
		Cliente c;
		String sql;
		ResultSet rs; 
		ArrayList<Cliente> tabla = new ArrayList<Cliente>();
		
		sql = "SELECT * "
			+ "FROM TbCliente ";
		rs = Conector.getConector().ejecutarSQL(sql, true);
		while(rs.next()){
			c = new Cliente(
					rs.getInt("id"),
					rs.getString("nombre"),
					rs.getString("apellido"),
					rs.getInt("telefono"),
					rs.getString("direccion"),
					rs.getInt("switch"),
					rs.getString("trabajo"),
					rs.getInt("telTrabajo"));
			tabla.add(c);
		}
		if(tabla.size()<1){
			tabla = null;
		}
		
		return tabla;
		
	}

}
