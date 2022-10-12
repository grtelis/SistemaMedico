package models;

public class PersonDataBaseModel {
    
    public static int id;
    public static String nombre;
    public static String apellidos;
    public static String telefono;
    public static int getId() {
        return id;
    }
    public void setId(int id) {
        PersonDataBaseModel.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        PersonDataBaseModel.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        PersonDataBaseModel.apellidos = apellidos;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        PersonDataBaseModel.telefono = telefono;
    }

    

}
