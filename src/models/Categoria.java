package src.models;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import src.models.comun.DbObject;

public class Categoria extends DbObject {

	private Integer id;
	private Date created;
	private String nombre;
	
	@Override
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	} 
	
	@Override
	public String toString() {
		return ""+this.id+":: "+this.nombre+" - "+this.created;
	}
	
	@Override
	public String getTable() {
		return "categorias";
	}
	@Override
	public String getCampos() {  
		return getCorrectCampos(null, "nombre", this.nombre);
	}
	@Override
	public String getValues() {
		return getCorrectValues(null, this.nombre);		
	} 
	
	@Override
	public DbObject getDbObject(ResultSet res) throws SQLException {
		Categoria item = new Categoria();
		item.setId( res.getInt("id") ); 
		
		int created = res.getInt("created");
		Date date = new Date(created);		
		item.setCreated( date );
		item.setNombre( res.getString("nombre") ); 
		
		return item;
	}
	
}
