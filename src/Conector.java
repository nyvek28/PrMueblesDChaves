
/**
 *
 * @author Emilio
 */
public class Conector {
    
    	private static AccesoBD conectorDB = null;
    
    public static AccesoBD getConector() throws java.sql.SQLException,Exception{
	
        if(conectorDB==null){
	
            conectorDB = new AccesoBD("net.ucanaccess.jdbc.UcanaccessDriver","jdbc:ucanaccess://BaseDeDatos/BDMuebles.accdb");
	}
        
	return conectorDB;
    }
    
}
