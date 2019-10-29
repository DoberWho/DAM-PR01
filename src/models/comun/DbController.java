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
	
	private boolean doExecute(String sql) {
		try {
			
			Statement statemnt = this.con.createStatement(); 
			statemnt.execute(sql);
		 
		} catch (SQLException e) { 
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	
	private boolean doSave(DbObject obj) {
		String TABLA = obj.getTable();
		String campos = obj.getCampos();
		String valor = obj.getValues();
		 
		String sql = "INSERT INTO "+TABLA+" ("+campos+") VALUES ("+valor+");";
		System.out.println(sql);
		
		boolean check = this.doExecute(sql); 
		if (check) {
			System.out.println("Objeto "+TABLA+" - Insertada");
		}else {
			System.out.println("FALLO "+TABLA+" - Insertada");
		}
		return check;
	}
	
	private boolean doUpdate(DbObject obj) {
		
		String TABLA = obj.getTable();
		String campos = obj.getCampos();
		String valores = obj.getValues();
				
		String modificaciones = "";
		String[] arCampos  = campos.split(",");
		String[] arValores = valores.split(",");
		
		for (int i = 0; i < arCampos.length; i++) {
			String campo = arCampos[i];
			String valor = arValores[i];
			
			modificaciones = modificaciones + campo+"="+valor;
			//Posible solucion a evitar que tenga coma en el ultimo elemento.
			if (i < arCampos.length) {
				modificaciones = modificaciones+",";
			}
		}
		// Otra posible soluci�n a tener coma al final del elemento
		//modificaciones = modificaciones.substring(0, modificaciones.length()-1);  
		
		String sql = "UPDATE "+TABLA+" SET "+modificaciones+" WHERE 'id'="+obj.getId();
		System.out.println(sql);
		
		boolean check = this.doExecute(sql); 
		if (check) {
			System.out.println("Objeto "+TABLA+" - Actualizado");
		}else {
			System.out.println("FALLO "+TABLA+" - Actualizado");
		}
		return check;
	}
	
	public boolean saveDb(DbObject obj) {  
		
		if (obj.getId() == null) {
			return this.doSave(obj);
		}
		 
		return this.doUpdate(obj);
	}

	public boolean deleteDb(DbObject obj) {  
		
		String TABLA = obj.getTable(); 
		
		String sql = "DELETE FROM "+TABLA+" where id = "+obj.getId();
		System.out.println(sql); 
		
		boolean check = this.doExecute(sql);
		if (check) {
			System.out.println("Objeto "+TABLA+" - Borrado");
		}else {
			System.out.println("FALLO "+TABLA+" - Borrado");
		}
		
		return check;
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
