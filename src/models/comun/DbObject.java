package src.models.comun;

import java.sql.Date;

public abstract class DbObject {

	public abstract String getTable();
	public abstract String getCampos();
	public abstract String getValues();
	
	public void save() {
		DbController.getInstance().saveDb(this);
	}
	
	private boolean isNullOrEmpty(Object value) {
		if (value == null) {
			return true;
		} 
		
		if (value instanceof String) {
			if (( (String)value ).trim().isEmpty() ) {
				return true;
			}
		}
		
		return false;
	}
	
	public String getCorrectCampos(String data, String campo, Object value) {
		if (isNullOrEmpty(data)) {
			data = "";
		}
		if (isNullOrEmpty(value)) {
			return data;
		}
		
		if (data.isEmpty()) {
			return ""+campo;
		} 
		
		return data+","+campo;
	}
	
	
	public String getCorrectValues(String data, Object value) {
		if (isNullOrEmpty(data)) {
			data = "";
		}
		if (isNullOrEmpty(value)) {
			return data;
		}
		
		if (data == null || data.isEmpty()) {
			return "'"+value+"'";
		} 
		
		return data+",'"+value+"'";
	}
}
