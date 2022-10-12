package database;

import javax.swing.JOptionPane;

import models.PersonDataBaseModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonDatabase extends Conexion {

    PreparedStatement prepared;
    ResultSet result;

    public int createPerson(String name, String lastNames, String phoneNumber) {
        int idPerson = 0;
        try {
            Connection conexion = getConnection();
            prepared = conexion.prepareStatement("INSERT INTO persona(nombre, apellidos, telefono) VALUES(?,?,?);",
                    Statement.RETURN_GENERATED_KEYS);
            prepared.setString(1, name);
            prepared.setString(2, lastNames);
            prepared.setString(3, phoneNumber);

            int resultado = prepared.executeUpdate();

            if (resultado > 0) {
                ResultSet resultSet = prepared.getGeneratedKeys();

                if (resultSet.next()) {
                    idPerson = resultSet.getInt(1);
                    if (idPerson > 0) {
                        return idPerson;
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar persona");
                return 0;
            }
            conexion.close();
        } catch (Exception e) {
            System.err.println("Erro:" + e);
            return 0;
        }
        return 0;
    }

    public PersonDataBaseModel fetchPerson(int id) {

        try {
            Connection conexion = getConnection();
            prepared = conexion.prepareStatement("SELECT id, nombre, apellidos, telefono FROM persona WHERE id = ?;");
            prepared.setInt(1, id);
            result = prepared.executeQuery();
            if (result.next()) {

                PersonDataBaseModel persona = new PersonDataBaseModel();

                persona.setId(result.getInt("id"));
                persona.setNombre(result.getString("nombre"));
                persona.setApellidos(result.getString("apellidos"));
                persona.setTelefono(result.getString("telefono"));

                return persona;

            } else {
                JOptionPane.showMessageDialog(null, "Error: la persona no existe");
            }
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
            return null;
        }
        return null;

    }

    public void updatePerson(int personId, String name, String lastNames, String phoneNumber) {

        try {
            Connection conexion = getConnection();

            prepared = conexion
                    .prepareStatement("UPDATE persona SET nombre = ?, apellidos = ?, telefono = ? WHERE id = ?;");
            prepared.setString(1, name);
            prepared.setString(2, lastNames);
            prepared.setString(3, phoneNumber);
            prepared.setInt(4, personId);

            int resultado = prepared.executeUpdate();

            if (resultado > 0) {
                // JOptionPane.showMessageDialog(null, "Exito al actualizar persona");
            }

            conexion.close();
        } catch (Exception e) {

            System.err.println("Error:" + e);

        }

    }

    public void deletePerson(int personId) {
        try {
            Connection conexion = getConnection();
            prepared = conexion.prepareStatement("DELETE FROM persona WHERE id = ?;");
            prepared.setInt(1, personId);

            int resultado = prepared.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Exito al eliminar a la persona");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar a la persona");
            }
            conexion.close();
        } catch (Exception e) {
            System.err.println("Erro:" + e);
        }
    }
}
