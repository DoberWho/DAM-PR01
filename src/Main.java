package src; 
import java.util.ArrayList;
import java.util.List;

import src.models.Categoria;
import src.models.Clientes;
import src.models.Producto;
import src.models.comun.DbObject; 

public class Main {

	public static void main(String[] args) {
		
		// Hacer el Backup del d�a
		//Backup.getInstance().doBackup();  
		
		 Categoria cat = new Categoria();
		 cat.setNombre("Cat 01");
		 
		 Producto prod = new Producto();
		 prod.setId_categoria(1); // TODO: Select de la categoria insertada
		 prod.setNombre("PROD 01");
		 prod.setPrecio(100);
		 prod.setStock(1);
		 
		 prod.save();
		 
		 List<DbObject> productos = prod.list();
		
		
		
		//statemnt.executeQuery(sql);
		
		//con.prepareStatement(sql)
	 
	}

}
