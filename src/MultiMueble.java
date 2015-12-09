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
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para crear y guardar mueble alto
	Version: v.1.0
	Fecha: Dic 8, 2015
	Ediciones:

	*/
	public Mueble crear(int plinea, String pcolor, double ancho, double alto, double largo, int pcategoria, double precio){
		Mueble m;
		String sql;
		
		m = new Alto(plinea,pcolor,ancho,alto,largo,pcategoria,precio);
		sql = "INSERT INTO TbMueble (id, linea, color, ancho, alto, largo, categoria, switch, idJuego, precio, consecutivo)"
			+ " VALUES( "
			+ m.getId() + ","
			+ m.getLinea() + ","
			+ "'" + m.getColor() + "',"
			+ m.getDimensiones()[0] + ","
			+ m.getDimensiones()[1] + ","
			+ m.getDimensiones()[2] + ","
			+ m.getCategoria() + ","
			+ m.getSwitCh() + ","
			+ m.getIdJuego() + ","
			+ m.getPrecio() + ","
			+ Mueble.getConsecutivo()
			+ " )";
		try {
			Conector.getConector().ejecutarSQL(sql);
		} catch (Exception e) {
			//m = null;
			e.printStackTrace();
		}
		
		return m;
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para crear y guardar mueble bajo
	Version: v.1.0
	Fecha: Dic 8, 2015
	Ediciones:

	*/
	public Mueble crear(int plinea, String pcolor, double ancho, double alto, double largo, int pcategoria, double precio,
			double alturaSobreSuelo){
		Mueble m;
		String sql;
		
		m = new Bajo(plinea,pcolor,ancho,alto,largo,pcategoria,precio, alturaSobreSuelo);
		sql = "INSERT INTO TbMueble (id, linea, color, ancho, alto, largo, categoria, switch, idJuego, precio, consecutivo)"
			+ " VALUES( "
			+ m.getId() + ","
			+ m.getLinea() + ","
			+ "'" + m.getColor() + "',"
			+ m.getDimensiones()[0] + ","
			+ m.getDimensiones()[1] + ","
			+ m.getDimensiones()[2] + ","
			+ m.getCategoria() + ","
			+ m.getSwitCh() + ","
			+ m.getIdJuego() + ","
			+ m.getPrecio() + ","
			+ Mueble.getConsecutivo()
			+ " ) "
			+ "INSERT INTO TbBajo (id ,alturaSobreSuelo) "
			+ " VALUES("
			+ m.getId() + ","
			+ ((Bajo)m).getAlturaSobreSuelo() + " "
			+ ")";
		try {
			Conector.getConector().ejecutarSQL(sql);
		} catch (Exception e) {
			//m = null;
			e.printStackTrace();
		}
		
		return m;
	}
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para crear y guardar mueble panel
	Version: v.1.0
	Fecha: Dic 8, 2015
	Ediciones:

	*/
	public Mueble crear(int plinea, String pcolor, double ancho, double alto, double largo, int pcategoria, double precio, int acabado){
		Mueble m;
		String sql;
		
		m = new Panel(plinea,pcolor,ancho,alto,largo,pcategoria,precio,acabado);
		sql = "INSERT INTO TbMueble (id, linea, color, ancho, alto, largo, categoria, switch, idJuego, precio, consecutivo)"
			+ " VALUES( "
			+ m.getId() + ","
			+ m.getLinea() + ","
			+ "'" + m.getColor() + "',"
			+ m.getDimensiones()[0] + ","
			+ m.getDimensiones()[1] + ","
			+ m.getDimensiones()[2] + ","
			+ m.getCategoria() + ","
			+ m.getSwitCh() + ","
			+ m.getIdJuego() + ","
			+ m.getPrecio() + ","
			+ Mueble.getConsecutivo()
			+ " ) "
			+ "INSERT INTO TbPanel (id, acabado) "
			+ " VALUES ("
			+ m.getId() + ","
			+ ((Panel)m).getAcabado() + ""
			+ " ) ";
		try {
			Conector.getConector().ejecutarSQL(sql);
		} catch (Exception e) {
			//m = null;
			e.printStackTrace();
		}
		
		return m;
	}
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para crear y guardar mueble encimera
	Version: v.1.0
	Fecha: Dic 8, 2015
	Ediciones:

	*/
	public Mueble crear(int plinea, String pcolor, double ancho, double alto, double largo, int pcategoria, double precio,int tipo, 
			double espesor){
		Mueble m;
		String sql;
		
		m = new Encimera(plinea,pcolor,ancho,alto,largo,pcategoria,precio,tipo,espesor);
		sql = "INSERT INTO TbMueble (id, linea, color, ancho, alto, largo, categoria, switch, idJuego, precio, consecutivo)"
			+ " VALUES( "
			+ m.getId() + ","
			+ m.getLinea() + ","
			+ "'" + m.getColor() + "',"
			+ m.getDimensiones()[0] + ","
			+ m.getDimensiones()[1] + ","
			+ m.getDimensiones()[2] + ","
			+ m.getCategoria() + ","
			+ m.getSwitCh() + ","
			+ m.getIdJuego() + ","
			+ m.getPrecio() + ","
			+ Mueble.getConsecutivo()
			+ " ) "
			+ "INSERT INTO TbEncimera (id, tipo, espesor) "
			+ "VALUES ( "
			+ m.getId() + ","
			+ ((Encimera)m).getTipo() + ","
			+ ((Encimera)m).getEspesor() + ""
			+ " ) ";
		try {
			Conector.getConector().ejecutarSQL(sql);
		} catch (Exception e) {
			//m = null;
			e.printStackTrace();
		}
		
		return m;
	}
	
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para buscar un mueble
	Version: v.1.0
	Fecha: Dic 8, 2015
	Ediciones:

	*/
	public  Mueble buscarid(int pid) throws java.sql.SQLException,Exception{
		
		Mueble m;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT * "+
		"FROM TbMueble "+
		"WHERE id = "+pid+
		" AND switch != 0";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		
		if (rs.next()){
			switch(rs.getInt("categoria")){
			
			case 1:
				m = this.buscarBajo(rs);
				break;
				
			case 2:
				m = this.buscarEncimera(rs);
				break;
				
			case 3:
				m = this.buscarPanel(rs);
				break;
				
			default:
				m = new Alto(
						rs.getInt("id"),
						rs.getInt("linea"),
						rs.getString("color"),
						rs.getDouble("ancho"),
						rs.getDouble("alto"),
						rs.getDouble("largo"),
						rs.getInt("categoria"),
						rs.getDouble("precio"),
						rs.getInt("switch"),
						rs.getInt("idJuego")
						);
				break;
		
			}
		} else {
			m = null;
		}
		rs.close();
		return m; 
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para buscar la especializacion de bajo
	Version: v.1.0
	Fecha: Dic 8, 2015
	Ediciones:

	*/
	private Mueble buscarBajo(ResultSet rs) throws Exception{
		
		Mueble m;
		ResultSet rset;
		String sql;
		
		sql = "SELECT * "
			+ "FROM TbBajo "
			+ "WHERE id = " + rs.getInt("id");
		rset = Conector.getConector().ejecutarSQL(sql, true);
		if(rset.next()){
			m = new Bajo(
					rs.getInt("id"),
					rs.getInt("linea"),
					rs.getString("color"),
					rs.getDouble("ancho"),
					rs.getDouble("alto"),
					rs.getDouble("largo"),
					rs.getInt("categoria"),
					rs.getDouble("precio"),
					rs.getInt("switch"),
					rs.getInt("idJuego"),
					rset.getDouble("alturaSobreSuelo")
					);
		}else{
			m = null;
		}
		
		return m;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para buscar la especializacion de panel
	Version: v.1.0
	Fecha: Dic 8, 2015
	Ediciones:

	*/
	private Mueble buscarPanel(ResultSet rs) throws Exception{
		
		Mueble m;
		ResultSet rset;
		String sql;
		
		sql = "SELECT * "
			+ "FROM TbPanel "
			+ "WHERE id = " + rs.getInt("id");
		rset = Conector.getConector().ejecutarSQL(sql, true);
		if(rset.next()){
			m = new Panel(
					rs.getInt("id"),
					rs.getInt("linea"),
					rs.getString("color"),
					rs.getDouble("ancho"),
					rs.getDouble("alto"),
					rs.getDouble("largo"),
					rs.getInt("categoria"),
					rs.getDouble("precio"),
					rs.getInt("switch"),
					rs.getInt("idJuego"),
					rset.getInt("acabado")
					);
		}else{
			m = null;
		}
		
		return m;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para buscar la especializacion de encimera
	Version: v.1.0
	Fecha: Dic 8, 2015
	Ediciones:

	*/
	private Mueble buscarEncimera(ResultSet rs) throws Exception{
		
		Mueble m;
		ResultSet rset;
		String sql;
		
		sql = "SELECT * "
			+ "FROM TbEncimera "
			+ "WHERE id = " + rs.getInt("id");
		rset = Conector.getConector().ejecutarSQL(sql, true);
		if(rset.next()){
			m = new Encimera(
					rs.getInt("id"),
					rs.getInt("linea"),
					rs.getString("color"),
					rs.getDouble("ancho"),
					rs.getDouble("alto"),
					rs.getDouble("largo"),
					rs.getInt("categoria"),
					rs.getDouble("precio"),
					rs.getInt("switch"),
					rs.getInt("idJuego"),
					rset.getInt("tipo"),
					rset.getDouble("espesor")
					);
		}else{
			m = null;
		}
		
		return m;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para buscar el mueble por su Juego
	Version: v.1.0
	Fecha: Dic 8, 2015
	Ediciones:

	*/
	public  ArrayList<Mueble> buscaridJ(int pid) throws java.sql.SQLException,Exception{
		
		ArrayList<Mueble> muebles = new ArrayList<Mueble>();
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT *"+
		"FROM TbMueble "+
		"WHERE idJuego = '"+pid+"'";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		while(rs.next()){
			muebles.add(this.buscarid(rs.getInt("id")));
		}
		if(muebles.size() < 1){
			muebles = null;
		}
		rs.close();
		return muebles; 
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para buscar el mueble por su fabricante
	Version: v.1.0
	Fecha: Dic 8, 2015
	Ediciones:

	*/
	public ArrayList<Mueble> buscarF(int linea) throws SQLException, Exception{
		
		ResultSet rs;
		String sql;
		ArrayList<Mueble> muebles = new ArrayList<Mueble>();
		
		sql = "SELECT * "
			+ "FROM TbMueble "
			+ "WHERE linea = "+linea;
		rs = Conector.getConector().ejecutarSQL(sql, true);
		while(rs.next()){
			muebles.add(this.buscarid(rs.getInt("id")));
		}
		if(muebles.size() < 1){
			muebles = null;
		}
		
		return muebles;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para modificar mueble
	Version: v.1.0
	Fecha: Dic 8, 2015
	Ediciones:

	*/
	public Mueble modificar(Mueble m){
		
		String sql;
		
		sql = "UPDATE TbMueble "
			+ "SET switch = " + m.getSwitCh();
		try {
			Conector.getConector().ejecutarSQL(sql);
		} catch (Exception e) {
			m = null;
			e.printStackTrace();
		}
		
		return m;
		
	}
	
	/*
	Autor: Kevyn Quiros
	Descripcion: Metodo para eliminar mueble
	Version: v.1.0
	Fecha: Dic 8, 2015
	Ediciones:

	*/
	public Mueble eliminar(Mueble m){
		
		if(m.getSwitCh() != 0){
			m.setSwitCh(0);
			this.modificar(m);
		}else{
			m = null;
		}
		
		return m;
		
	}
	
	public ArrayList<Mueble> listar() throws Exception{
		
		Mueble m;
		String sql;
		ResultSet rs; 
		ArrayList<Mueble> tabla = new ArrayList<Mueble>();
		
		sql = "SELECT * "
			+ "FROM TbMueble ";
		rs = Conector.getConector().ejecutarSQL(sql, true);
		while(rs.next()){
			
			tabla.add(this.buscarid(rs.getInt("id")));
		}
		if(tabla.size()<1){
			tabla = null;
		}
		
		return tabla;
		
	}
	
}


