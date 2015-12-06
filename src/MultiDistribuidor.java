import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MultiDistribuidor {

	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que crea un objeto distribuidor y lo guarda el base de datos
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public Distribuidor crear(String nombre, String direccion, int telefono, double porcentaje){
		
		Distribuidor d;
		String sql;
		
		d = new Distribuidor(nombre,direccion,telefono,porcentaje);
		sql = "INSERT INTO TbDistribuidor "
			+ "VALUES ("
			+ d.getId() + ","
			+ "'" + d.getNombre() + "',"
			+ "'" + d.getDireccion() + "',"
			+ d.getTelefono() + ","
			+ d.getPorcentaje() + ","
			+ Distribuidor.getConsecutivo() + ","
			+ d.getSwitCh()
			+ ")";
		try {
			Conector.getConector().ejecutarSQL(sql);
		} catch (Exception e) {
			d = null;
			System.out.println("Error en el conector de crear distribuidor \n");
			e.printStackTrace();
		}
		
		return d;
		
	}
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que actualiza un objeto Distribuidor que se le envie
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public Distribuidor buscar(int id) throws SQLException, Exception{
		
		Distribuidor d;
		String sql;
		ResultSet rs;
		
		sql = "SELECT * "
			+ "FROM TbDistribuidor "
			+ "WHERE id = "+id
			+ " AND switch != 0";
		rs = Conector.getConector().ejecutarSQL(sql, true);
		if(rs.next()){
			d = new Distribuidor(
					rs.getInt("id"),
					rs.getString("nombre"),
					rs.getString("direccion"),
					rs.getInt("telefono"),
					rs.getDouble("porcentaje"),
					rs.getInt("switch"));
		}else{
			d = null;
		}
		
		return d;
		
	}
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que actualiza un objeto Distribuidor que se le envie
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public Distribuidor modificar(Distribuidor d){
		
		String sql;
		
		sql = " UPDATE TbDistribuidor "
			+ " SET "
			+ " id = "+d.getId()+","
			+ " nombre = '"+d.getNombre()+"',"
			+ " telefono = "+d.getTelefono()+","
			+ " direccion = '"+d.getDireccion()+"',"
			+ " porcentaje = "+d.getPorcentaje()+","
			+ " switCh = "+d.getSwitCh()+" "
			+ " WHERE id = "+d.getId();
		try {
			Conector.getConector().ejecutarSQL(sql);
		} catch (Exception e) {
			d = null;
			e.printStackTrace();
		}
		
		return d;
		
	}
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que elimina a un objeto Distribuidor logicamente de la base de datos
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public Distribuidor eliminar(Distribuidor d){
		
		if(d.getSwitCh() != 0){
			d.setSwitCh(0);
			this.modificar(d);
		}else{
			d = null;
		}
		
		return d;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo que busca un objeto Distribuidor y luego lo elimina logicamente de la base de 
	datos
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public Distribuidor eliminar(int id) throws SQLException, Exception{
		
		Distribuidor d;
		
		d = this.buscar(id);
		if(d != null){
			d = this.eliminar(d);
		}
		
		return d;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para listar todos los distribuidores en la base de datos
	Version: v.1.0
	Fecha: Dic 6, 2015
	Ediciones:

	*/
	public ArrayList<Distribuidor> listar() throws Exception{
		
		Distribuidor d;
		String sql;
		ResultSet rs;
		ArrayList<Distribuidor> tabla = new ArrayList<Distribuidor>();
		
		sql = "SELECT * "
			+ "FROM TbFabricante ";
		rs = Conector.getConector().ejecutarSQL(sql, true);
		while(rs.next()){
			d = new Distribuidor(
					rs.getInt("id"),
					rs.getString("nombre"),
					rs.getString("direccion"),
					rs.getInt("telefono"),
					rs.getDouble("porcentaje"),
					rs.getInt("switch"));
			tabla.add(d);
		}
		if(tabla.size()<1){
			tabla = null;
		}
		
		return tabla;
		
	}
	
}
