package src.models;

import java.util.Date;

import src.models.comun.DbObject;

public class Clientes implements DbObject {

	private Integer id;
	private Date created;
	private String nombre;
	private String dni;
	private String direccion;
	private String telefono;
	private String email;
	
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} 
	
	@Override
	public String getTable() {
		return "categorias";
	}
	@Override
	public String getCampos() {
		String campos = "";
		if (this.nombre != null || !this.nombre.trim().isEmpty()) {
			campos = campos + "nombre";
		}
		return "nombre, dni, direccion, telefono, email";
	}
	@Override
	public String getValues() {
		return "'"+this.nombre+"','"+this.dni+"','"+this.direccion+"','"+this.telefono+"','"+this.email+"'";		
	}
	
}
