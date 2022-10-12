package models;

public class DoctorDataBaseModel {
    
    public static int id;
    public static String cedula;
    public static int persona_id;
    public static int hospital_id;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        DoctorDataBaseModel.id = id;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        DoctorDataBaseModel.cedula = cedula;
    }
    public int getPersona_id() {
        return persona_id;
    }
    public void setPersona_id(int persona_id) {
        DoctorDataBaseModel.persona_id = persona_id;
    }
    public int getHospital_id() {
        return hospital_id;
    }
    public void setHospital_id(int hospital_id) {
        DoctorDataBaseModel.hospital_id = hospital_id;
    }
    

}
