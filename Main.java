

public class Main {

	public static void main(String[] args) {
		
		// Hacer el Backup del d�a
		Backup.getInstance().doBackup();
		
		// Comprobar que la base de datos existe
		DbSqlite db = DbSqlite.getInstance();
		
		// Arrancar

	}

}
