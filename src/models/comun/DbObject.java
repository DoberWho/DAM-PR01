package src.models.comun;

public abstract class DbObject {

	public abstract String getTable();
	public abstract String getCampos();
	public abstract String getValues();
	
	public void save() {
		DbController.getInstance().saveDb(this);
	}
}
