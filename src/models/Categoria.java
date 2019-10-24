package src.models;
 
import java.util.Date;

import src.models.comun.DbObject;

public class Categoria extends DbObject {

	private Integer id;
	private Date created;
	private String nombre;
	
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
	
}
