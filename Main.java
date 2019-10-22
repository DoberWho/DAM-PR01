import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		// Hacer el Backup del día
		Backup.getInstance().doBackup();
		
		// Comprobar que la base de datos existe
		DbSqlite db = DbSqlite.getInstance();
		
		// Arrancar
		Connection con = db.getConnection();
		 
		
		String insertar = "INSERT INTO 'categorias' ('nombre') VALUES ('Categoria 01');";
		try {
			Statement statemnt = con.createStatement();
			statemnt.execute(insertar);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		//statemnt.executeQuery(sql);
		
		//con.prepareStatement(sql)
	 
	}

}
