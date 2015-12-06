import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public Distribuidor eliminar(Distribuidor d){
		
		if(d.getSwitCh() != 0){
			d.setSwitCh(0);
			this.modificar(d);
		}else{
			d = null;
		}
		
		return d;
		
	}
	
	public Distribuidor eliminar(int id) throws SQLException, Exception{
		
		Distribuidor d;
		
		d = this.buscar(id);
		if(d != null){
			d = this.eliminar(d);
		}
		
		return d;
		
	}
	
}
