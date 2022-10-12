package database;

import javax.swing.JOptionPane;

import models.DoctorDataBaseModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoctorDatabase extends Conexion {

    PersonDatabase personDatabase = new PersonDatabase();
    PreparedStatement prepared;
    ResultSet result;

    public void insertDoctor(String identificationCard, String name, String lastNames, String phoneNumber,
            int hospitalId) {

        int personId = personDatabase.createPerson(name, lastNames, phoneNumber);

        if (personId == 0) {

            JOptionPane.showMessageDialog(null, "Error: No se registro el medico");

            return;
        }
        try {
            Connection conexion = getConnection();
            prepared = conexion.prepareStatement(
                    "INSERT INTO medico(cedula, persona_id, hospital_id, created_at) VALUES(?,?,?,?);");
            prepared.setString(1, identificationCard);
            prepared.setInt(2, personId);
            prepared.setInt(3, hospitalId);
            prepared.setTimestamp(4, new java.sql.Timestamp(System.currentTimeMillis()));

            int resultado = prepared.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Exito al insertar el Medico");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrarse al Medico");
            }
            conexion.close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error: " + e);
            //System.err.println("Error:" + e);

        }

    }

    public DoctorDataBaseModel fetchDoctor(int id) {

        try {
            Connection conexion = getConnection();
            prepared = conexion
                    .prepareStatement("SELECT id, cedula, persona_id, hospital_id FROM medico WHERE id = ?;");
            prepared.setInt(1, id);
            result = prepared.executeQuery();
            if (result.next()) {

                DoctorDataBaseModel medico = new DoctorDataBaseModel();

                medico.setId(result.getInt("id"));
                medico.setCedula(result.getString("cedula"));
                medico.setPersona_id(result.getInt("persona_id"));
                medico.setHospital_id(result.getInt("hospital_id"));

                return medico;

            } else {
                JOptionPane.showMessageDialog(null, "Error: el doctor no existe");
            }
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
            return null;
        }
        return null;

    }

    public DoctorDataBaseModel updateDoctor(int doctorId, String name, String lastNames, String phoneNumber,
            String identificationCard, int hospitalId) {

        try {
            Connection conexion = getConnection();

            prepared = conexion.prepareStatement("UPDATE medico SET cedula = ?, hospital_id = ? WHERE id = ?;");
            prepared.setString(1, identificationCard);
            prepared.setInt(2, hospitalId);
            prepared.setInt(3, doctorId);

            int resultado = prepared.executeUpdate();

            DoctorDataBaseModel doctor = this.fetchDoctor(doctorId);
            personDatabase.updatePerson(doctor.getPersona_id(), name, lastNames, phoneNumber);

            // int resultado = prepared.executeUpdate();

            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Exito al actualizar");
                return doctor; // this.fetchDoctor(doctorId);

            }

            conexion.close();

        } catch (Exception e) {

            System.err.println("Error:" + e);
            return null;
        }

        return null;

    }

    public void deleteDoctor(int doctorId) {
        try {
            Connection conexion = getConnection();
            prepared = conexion.prepareStatement("DELETE FROM medico WHERE id = ?;");
            prepared.setInt(1, doctorId);

            int resultado = prepared.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Exito al eliminar");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
            conexion.close();
        } catch (Exception e) {
            System.err.println("Erro:" + e);
        }
    }
}
