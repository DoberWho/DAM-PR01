package src.models;

import java.util.Date;

import src.models.comun.DbObject;

public class Producto extends DbObject {

	private Integer id;
	private Date created;
	private String nombre;
	private Integer precio; // 100 = 1,00
	private Integer stock;
	
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
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
	@Override
	public String getTable() {
		return "producto";
	}
	@Override
	public String getCampos() {
		String campos = ""; 
		campos = getCorrectCampos(null, "nombre", this.nombre);
		campos = getCorrectCampos(null, "precio", this.precio);
		campos = getCorrectCampos(null, "stock" , this.stock); 
		return campos;
	}
	@Override
	public String getValues() {
		String value = ""; 
		value = getCorrectValues(null, this.nombre);
		value = getCorrectValues(null, this.precio); 
		value = getCorrectValues(null, this.stock); 
		return value;		
	}
	
	
}
