package src; 
import src.models.Clientes;
import src.models.comun.DbController; 

public class Main {

	public static void main(String[] args) {
		
		// Hacer el Backup del d�a
		//Backup.getInstance().doBackup();  
		
		Clientes client = new Clientes();
		client.setNombre("cliente 02");
		client.setEmail("user02@user.com");
		client.setDni("1234");
		client.setTelefono("1234567");
		 
		DbController.getInstance().saveDb(client);
		
		//statemnt.executeQuery(sql);
		
		//con.prepareStatement(sql)
	 
	}

}
