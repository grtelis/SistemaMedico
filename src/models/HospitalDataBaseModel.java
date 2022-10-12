package models;

public class HospitalDataBaseModel {
    
    private static int id;
    private static String nombre;
    private static String tipo;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		HospitalDataBaseModel.id = id;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		HospitalDataBaseModel.nombre = nombre;
	}
	
    
    public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		HospitalDataBaseModel.tipo = tipo;
	}

    
    

}
