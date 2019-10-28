package src.models.comun;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DbController {
	
	private Connection con;
	
	private static DbController instance;
	 
	private DbController() { 
		DbSqlite db = DbSqlite.getInstance();
		con = db.getConnection();
	}

	public static DbController getInstance() {
		if (instance == null) {
			instance = new DbController();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public boolean saveDb(DbObject obj) {  
		
		String TABLA = obj.getTable();
		String campos = obj.getCampos();
		String valor = obj.getValues();
		 
		String sqlIns = "INSERT INTO "+TABLA+" ("+campos+") VALUES ("+valor+");";
		System.out.println(sqlIns);
		
		try {
			
			Statement statemnt = this.con.createStatement(); 
			statemnt.execute(sqlIns);
		 
		} catch (SQLException e) { 
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
		System.out.println("Objeto "+TABLA+" - "+valor+" Insertada");
		return true;
	}

	/**
	 * 
	 * @param obj Modelo de Datos para recoger la TABLA
	 * @return Devuelve un Array de DbObject o <strong>NULL</strong> en caso de error
	 */
	public List<DbObject> list(DbObject obj) {
		  
		String sql = "SELECT * FROM "+obj.getTable(); 
		ArrayList<DbObject> dev = new ArrayList<DbObject>();
		
		try {
			Statement statemnt = this.con.createStatement(); 
			ResultSet res = statemnt.executeQuery(sql);
			
			while(res.next()) { 
				DbObject nObj = obj.getDbObject(res);
				dev.add(nObj);
			} 
		} catch (SQLException e) { 
			e.printStackTrace();
			System.out.println(e);
			return null;
		} 
		
		return dev;
	}

}
