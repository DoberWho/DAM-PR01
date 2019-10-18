import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 


public class DbSqlite {
	
	final String PATH = "./db/";
	final String DBNAME = "miTienda.db";
	
	private static DbSqlite instance;
	private DbSqlite(){
		this.init();
	} 
	public static DbSqlite getInstance(){
		if (instance == null){
			instance = new DbSqlite(); 
		}
		return instance;
	}
	
	private void checkDbFiles() {
		boolean fileExist = false;
		System.out.println("Comprobando Base de Datos");
		File path = new File(PATH);
		if (!path.exists()) {
			path.mkdirs();
		}
		File db = new File(path, DBNAME);
		if (db.exists()) {
			System.out.println("Base de Datos Ya Creada");
			this.init();
			return;
		}
		try {
			System.out.println("Creando Base de Datos");
			if( db.createNewFile() ) {
				fileExist = true;				
			}
		} catch (IOException e) { 
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			if (fileExist) {
				System.out.println("Base de Datos, Creada");
				this.init();
			}
		}
		
	}
	
	public void init() {
		
		Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:"+PATH+DBNAME;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.checkDbFiles();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
	}
	
	public static void main(String[] args) {
		DbSqlite db = DbSqlite.getInstance();
		 
	}

}
