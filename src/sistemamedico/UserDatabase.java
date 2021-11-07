package sistemamedico;

import java.util.HashMap;

/**
 *
 * @author mac
 */
public class UserDatabase {
    
    HashMap<String,String> logininfo = new HashMap<String,String>();
       
    UserDatabase() {
        logininfo.put("Carlos", "123456");
        logininfo.put("Ruben", "123456");
        logininfo.put("Fernanda", "123456");
    }
    
    protected HashMap getLoginInfo() {
        return logininfo;
    }
}
