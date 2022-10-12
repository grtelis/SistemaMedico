package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static final String URL = "jdbc:postgresql://localhost:5432/ProyectoFinal"; //Poner nombre de la base de datos
    public static final String USERNAME = "postgres";
    public static final String PASSWD = "C0sme_238"; // Poner contraseña

    public Connection getConnection() {

        Connection conexion = null;
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWD);
        } catch (Exception e) {

            System.err.println("Error: " + e);
        }
        return conexion;
    }

}