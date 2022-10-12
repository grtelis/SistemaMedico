package models;

public class PatientDataBaseModel {
    
    public static int id;
    public static int edad;
    public static float peso;
    public static float talla;
    public static String padecimiento;
    public static int num_estudios;
    public static int persona_id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        PatientDataBaseModel.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        PatientDataBaseModel.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        PatientDataBaseModel.peso = peso;
    }

    public float getTalla() {
        return talla;
    }

    public void setTalla(float talla) {
        PatientDataBaseModel.talla = talla;
    }

    public String getPadecimiento() {
        return padecimiento;
    }

    public void setPadecimiento(String padecimiento) {
        PatientDataBaseModel.padecimiento = padecimiento;
    }

    public int getNumEstudios() {
        return num_estudios;
    }

    public void setNumEstudios(int num_estudios) {
        PatientDataBaseModel.num_estudios = num_estudios;
    }

    public int getPersonaId() {
        return persona_id;
    }

    public void setPersonaId(int persona_id) {
        PatientDataBaseModel.persona_id = persona_id;
    }

}
