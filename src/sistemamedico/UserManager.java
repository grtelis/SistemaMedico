/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamedico;

/**
 *
 * @author Carlos Hernández
 */
public class UserManager {
    
    UserDatabase userDatabase = new UserDatabase();
    
    UserManager() {
        
    }
    
    
    void signIn(String userName, String password) {
        userDatabase.insertUser(userName, password);
    }
    
    void logIn(String userName, String password) {
        //GET USER WITH PASSWORD 
        
        //VALIDATE PASSWORDS 
    }
    
}
