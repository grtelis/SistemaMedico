package database;

import javax.swing.JOptionPane;

import models.HospitalDataBaseModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HospitalDatabase extends Conexion {

    PreparedStatement prepared;
    ResultSet result;

    public void createHospital(String name, String type) {
        try {
            Connection conexion = getConnection();
            prepared = conexion.prepareStatement("INSERT INTO hospital(nombre, tipo) VALUES(?,?);");
            prepared.setString(1, name);
            prepared.setString(2, type);

            int resultado = prepared.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Exito al insertar hospital");
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrarse al usuario");
            }
            conexion.close();
        } catch (Exception e) {
            System.err.println("Erro:" + e);
        }
    }

    public HospitalDataBaseModel fetchHospital(int id) {
        try {
            Connection conexion = getConnection();
            prepared = conexion.prepareStatement("SELECT id, nombre, tipo FROM hospital WHERE id = ?;");
            prepared.setInt(1, id);
            result = prepared.executeQuery();
            if (result.next()) {

                HospitalDataBaseModel hospital = new HospitalDataBaseModel();

                hospital.setId(result.getInt("id"));
                hospital.setNombre(result.getString("nombre"));
                hospital.setTipo(result.getString("tipo"));

                return hospital;

            } else {
                JOptionPane.showMessageDialog(null, "Error: el hospital no existe");
            }
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
            return null;
        }
        return null;
    }

    public HospitalDataBaseModel updateHospital(int hospitalId, String name, String type) {
        try {
            Connection conexion = getConnection();

            prepared = conexion.prepareStatement("UPDATE hospital SET nombre = ?, tipo = ? WHERE id = ?;");
            prepared.setString(1, name);
            prepared.setString(2, type);
            prepared.setInt(3, hospitalId);

            int resultado = prepared.executeUpdate();

            if (resultado > 0) {
                return this.fetchHospital(hospitalId);
            }

            conexion.close();
        } catch (Exception e) {
            System.err.println("Error:" + e);
            return null;
        }
        return null;

    }

    public void deleteHospital(int hospitalId) {

        try {
            Connection conexion = getConnection();
            prepared = conexion.prepareStatement("DELETE FROM hospital WHERE id = ?;");
            prepared.setInt(1, hospitalId);

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