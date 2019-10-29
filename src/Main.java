package src; 
import java.util.ArrayList;
import java.util.List;

import src.models.Categoria;
import src.models.Clientes;
import src.models.Producto;
import src.models.comun.DbObject; 

public class Main {

	public static void main(String[] args) {
		
		// Hacer el Backup del día
		//Backup.getInstance().doBackup();  
		
		 Categoria cat = new Categoria();
		 cat.setNombre("Cat 01");
		 //cat.save();
		 List<DbObject> cats = cat.list();
		 for (DbObject item : cats) {
			Categoria dbCat = (Categoria)item;
			System.out.println(dbCat.toString());
		}
		 
		 Producto prod = new Producto();
		 prod.setId_categoria(1); // TODO: Select de la categoria insertada
		 prod.setNombre("PROD 01");
		 prod.setPrecio(100);
		 prod.setStock(1);
		 
		 prod.save();
		 
		 List<DbObject> productos = prod.list();
		 for (DbObject dbObject : productos) {
			Producto p = (Producto) dbObject;
			//p.delete();
			p.setPrecio(100);
			p.save(); 
		} 
		 
		 Clientes cli = new Clientes();
		 cli.setNombre("Cliente");
		 cli.setDni("11222334455");
		 cli.save();
		 
		 
		
		
		
		//statemnt.executeQuery(sql);
		
		//con.prepareStatement(sql)
	 
	}

}
