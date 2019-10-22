package src.models.comun;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbController {
	
	private static DbController instance;

	private DbController() { 
		DbSqlite db = DbSqlite.getInstance();
		Connection con = db.getConnection();
	}

	public static DbController getInstance() {
		if (instance == null) {
			instance = new DbController();
		}
		return instance;
	}
	
	public static boolean saveDb(Connection con, String nombre) { 
		
		try {
			
			Statement statemnt = con.createStatement();
			
			String sql = "select * from categorias where nombre = '"+nombre+"'";
			ResultSet res = statemnt.executeQuery(sql);
			if (res.next()) {
				System.out.println("Categoria "+nombre+" Ya Existe");
				return false;
			}
			
			String insertar = "INSERT INTO 'categorias' ('nombre') VALUES ('"+nombre+"');";
			statemnt.execute(insertar);
		 
		} catch (SQLException e) { 
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
		System.out.println("Categoria "+nombre+" Insertada");
		return true;
	}

}
