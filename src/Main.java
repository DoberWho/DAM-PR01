package src; 
import src.models.Clientes; 

public class Main {

	public static void main(String[] args) {
		
		// Hacer el Backup del d�a
		//Backup.getInstance().doBackup();  
		
		Clientes client = new Clientes();
		client.setNombre("cliente 022224");  
		client.setTelefono("1234567");
		  
		client.save();
		
		//statemnt.executeQuery(sql);
		
		//con.prepareStatement(sql)
	 
	}

}
