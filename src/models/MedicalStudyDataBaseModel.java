package models;

public class MedicalStudyDataBaseModel {

    private static int id;
    private static String tipo_estudio;
    private static String fecha_estudio;
    public static int paciente_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        MedicalStudyDataBaseModel.id = id;
    }

    public String getTipoEstudio() {
        return tipo_estudio;
    }

    public void setTipoEstudio(String tipo_estudio) {
        MedicalStudyDataBaseModel.tipo_estudio = tipo_estudio;
    }

    public String getFechaEstudio() {
        return fecha_estudio;
    }

    public void setFechaEstudio(String fecha_estudio) {
        MedicalStudyDataBaseModel.fecha_estudio = fecha_estudio;
    }

    public int getPacienteId() {
        return paciente_id;
    }

    public void setPacienteId(int paciente_id) {
        MedicalStudyDataBaseModel.paciente_id = paciente_id;
    }

}
