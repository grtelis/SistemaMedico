package database;

import javax.swing.JOptionPane;

import models.PatientDataBaseModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientDatabase extends Conexion {

    PersonDatabase personDatabase = new PersonDatabase();
    PreparedStatement prepared;
    ResultSet result;

    public void insertPatient(String name, String lastNames, String phoneNumber, int age, float weight, float size,
            String suffering, int studiesNumber) {

        int personId = personDatabase.createPerson(name, lastNames, phoneNumber);

        if (personId == 0) {
            JOptionPane.showMessageDialog(null, "No funciona" + personId);
            return;
        }

        try {

            Connection conexion = getConnection();
            prepared = conexion.prepareStatement(
                    "INSERT INTO paciente(edad, peso, talla, padecimiento, persona_id, num_estudios) VALUES(?,?,?,?,?,?)");
            prepared.setInt(1, age);
            prepared.setFloat(2, weight);
            prepared.setFloat(3, size);
            prepared.setString(4, suffering);
            prepared.setInt(5, personId);
            prepared.setInt(6, studiesNumber);

            int resultado = prepared.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Éxito al insertar el paciente");

            } else {

                JOptionPane.showMessageDialog(null, "Error al registrarse el paciente");
            }

            conexion.close();

        } catch (Exception e) {

            System.err.println("Error: " + e);
        }
    }

    public PatientDataBaseModel fetchPatient(int id) {

        try {
            Connection conexion = getConnection();
            prepared = conexion.prepareStatement(
                    "SELECT id, edad, peso, talla, padecimiento, persona_id, num_estudios FROM paciente WHERE id = ?;");
            prepared.setInt(1, id);
            result = prepared.executeQuery();
            if (result.next()) {

                PatientDataBaseModel paciente = new PatientDataBaseModel();

                paciente.setId(result.getInt("id"));
                paciente.setEdad(result.getInt("edad"));
                paciente.setPeso(result.getFloat("peso"));
                paciente.setTalla(result.getFloat("talla"));
                paciente.setPadecimiento(result.getString("padecimiento"));
                paciente.setPersonaId(result.getInt("persona_id"));
                paciente.setNumEstudios(result.getInt("num_estudios"));

                return paciente;

            } else {
                JOptionPane.showMessageDialog(null, "Error: el paciente no existe");
            }
            conexion.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error" + e);
            return null;
        }
        return null;
    }

    public PatientDataBaseModel updatePatient(int patientId, int age, float weight, float size, String suffering,
            String name, String lastNames, String phoneNumber) {

        try {
            Connection conexion = getConnection();

            prepared = conexion.prepareStatement(
                    "UPDATE paciente SET edad = ?, peso = ?, talla = ?, padecimiento = ? WHERE id = ?;");
            prepared.setInt(1, age);
            prepared.setFloat(2, weight);
            prepared.setFloat(3, size);
            prepared.setString(4, suffering);
            prepared.setInt(5, patientId);

            int resultado = prepared.executeUpdate();

            PatientDataBaseModel patient = this.fetchPatient(patientId);
            personDatabase.updatePerson(patient.getPersonaId(), name, lastNames, phoneNumber);

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Éxito al actualizar paciente");
                return patient;
            }

            conexion.close();

        } catch (Exception e) {

            System.err.println("Error:" + e);
            return null;
        }

        return null;

    }

    public void deletePatient(int patientId) {
        try {
            Connection conexion = getConnection();
            prepared = conexion.prepareStatement("DELETE FROM paciente WHERE id = ?;");
            prepared.setInt(1, patientId);
            int resultado = prepared.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Exito al eliminar el paciente");

            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el paciente");
            }

            conexion.close();

        } catch (Exception e) {

            System.err.println("Error:" + e);
        }
    }

}
