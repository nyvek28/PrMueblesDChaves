
public class MultiMueble {
		
	public Mueble crear(int pid,int plinea, String pcolor, double ancho, double alto, double largo, String pcategoria)throws Exception{
		Mueble mueble=null;
		String sql;
		sql="INSERT INTO TLibro "+
		"VALUES ('"+pid+"','"+plinea+"', '"+pcolor+"','"+ancho+"','"+alto+"','"+largo+"''"+pcategoria+"');";
		try {
			Conector.getConector().ejecutarSQL(sql);
			mueble = new Mueble(pid,plinea,pcolor, ancho, alto, largo, pcategoria);
		}
		catch (Exception e) {
			throw new Exception (".");
		}
		return mueble;
	}
	public  Mueble buscarid(int pid) throws java.sql.SQLException,Exception{
		
		Mueble mueble;
		java.sql.ResultSet rs;
		String sql;
		sql = "SELECT id,linea,color,ancho,alto,largo,categoria "+
		"FROM TLibro "+
		"WHERE Isbn = '"+pid+"'";
		rs = Conector.getConector().ejecutarSQL(sql,true);
		if (rs.next()){
			mueble = new Mueble(
				rs.getInt("id"),
				rs.getInt("linea"),
				rs.getString("color"),
				rs.getDouble("ancho"),
				rs.getDouble("alto"),
				rs.getDouble("largo"),
				rs.getString("categoria"));
		} else {
			mueble = null;
		}
		rs.close();
		return mueble; 
	}
	
	
}


