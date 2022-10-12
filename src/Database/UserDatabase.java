
package database;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDatabase extends Conexion {

    PreparedStatement prepared;
    ResultSet result;

    
    public boolean logInUser(String userName, String password) {
        //SELECT DE USER NAME        
        try {
            Connection conexion = getConnection();
            prepared = conexion.prepareStatement("SELECT contrasena FROM usuario WHERE nombre = ?;");
            prepared.setString(1, userName);
            result = prepared.executeQuery();
            if(result.next()) {
                //OBTENER PASSWORD 
                String userPassword = result.getString("contrasena");
                //VERIFICAR QUE COINCIDAN 
                if (password.equals(userPassword)) {
                    //ABRIR PANTALLA DE INICIO 
                    JOptionPane.showMessageDialog(null, "La contraseña es correcta");
                    return true;
                } else {                
                    JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
                    return false;
                }
            }
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
            return false;                       
        }
        return false;                
    } 
 
    public void insertUser(String userName, String password) {

        try {
            Connection conexion = getConnection();
            prepared = conexion.prepareStatement("INSERT INTO usuario(nombre, contrasena) VALUES(?,?);");
            prepared.setString(1, userName);
            prepared.setString(2, password);

            JOptionPane.showMessageDialog(null, "Exito al insertar usuario");
            int resultado = prepared.executeUpdate();
            if (resultado > 0) {
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrarse la usuario");
            }
            conexion.close();
        } catch (Exception e) {
            System.err.println("Erro:" + e);
        }
    }
}