package database;

import javax.swing.JOptionPane;

import models.MedicalStudyDataBaseModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MedicalStudyDatabase extends Conexion {

    PreparedStatement prepared;
    ResultSet result;

    public void createMedicalStudy(String studyType, String date, int patientId) {
        try {
            Connection conexion = getConnection();
            prepared = conexion.prepareStatement(
                    "INSERT INTO estudios_laboratorio(tipo_estudio, fecha_estudio, paciente_id) VALUES(?,?,?);");
            prepared.setString(1, studyType);
            prepared.setString(2, date);
            prepared.setInt(3, patientId);

            int resultado = prepared.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Exito al insertar estudio medico");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar estudio laboratorio");
            }
            conexion.close();
        } catch (Exception e) {
            System.err.println("Erro:" + e);
        }
    }

    public MedicalStudyDataBaseModel fetchMedicalStudy(int medicalStudyId) {

        try {
            Connection conexion = getConnection();
            prepared = conexion.prepareStatement(
                    "SELECT id, tipo_estudio, fecha_estudio, paciente_id FROM estudios_laboratorio WHERE id = ?;");
            prepared.setInt(1, medicalStudyId);
            result = prepared.executeQuery();

            if (result.next()) {

                MedicalStudyDataBaseModel estudiosLaboratorio = new MedicalStudyDataBaseModel();

                estudiosLaboratorio.setId(result.getInt("id"));
                estudiosLaboratorio.setTipoEstudio(result.getString("tipo_estudio"));
                estudiosLaboratorio.setFechaEstudio(result.getString("fecha_estudio"));
                estudiosLaboratorio.setPacienteId(result.getInt("paciente_id"));

                return estudiosLaboratorio;

            } else {

                JOptionPane.showMessageDialog(null, "Error: el estudio de laboratorio no existe");
            }

            conexion.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error" + e);
            return null;
        }
        return null;
    }

    public MedicalStudyDataBaseModel updateMedicalStudy(int medicalStudyId, String studyType, String date,
            int patientId) {

        try {
            Connection conexion = getConnection();

            prepared = conexion.prepareStatement(
                    "UPDATE estudios_laboratorio SET tipo_estudio = ?, fecha_estudio = ?, paciente_id = ? WHERE id = ?;");
            prepared.setString(1, studyType);
            prepared.setString(2, date);
            prepared.setInt(3, patientId);
            prepared.setInt(4, medicalStudyId);

            int resultado = prepared.executeUpdate();

            if (resultado > 0) {
                return this.fetchMedicalStudy(medicalStudyId);
            }

            conexion.close();
        } catch (Exception e) {
            System.err.println("Error:" + e);
            return null;
        }
        return null;

    }

    public void deleteMedicalStudy(int medicalStudyId) {

        try {
            Connection conexion = getConnection();
            prepared = conexion.prepareStatement("DELETE FROM estudios_laboratorio WHERE id = ?;");
            prepared.setInt(1, medicalStudyId);

            int resultado = prepared.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Exito al eliminar estudio");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
            conexion.close();
        } catch (Exception e) {
            System.err.println("Error:" + e);
        }

    }

}
