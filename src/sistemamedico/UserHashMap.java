package sistemamedico;

import java.util.HashMap;

/**
 *
 * @author Carlos Hernández
 */
public class UserHashMap {
    
    HashMap<String,String> logininfo = new HashMap<String,String>();
       
    UserHashMap() {
        logininfo.put("Carlos", "123456");
        logininfo.put("Ruben", "123456");
        logininfo.put("Fernanda", "123456");
    }
    
    protected HashMap getLoginInfo() {
        return logininfo;
    }
}
