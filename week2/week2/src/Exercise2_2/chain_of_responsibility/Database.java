package Exercise2_2.chain_of_responsibility;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private final Map<String,String> users = new HashMap<>();
    public Database(){
        users.put("taikhoan1","matkhau1");
        users.put("taikhoan2", "matkhau2");
        users.put("admin","admin");
    }
    public boolean isValidUsers(String userName){
        return users.containsKey(userName);
    }
    public boolean isValidPassword(String username,String password){
        return users.get(username).equals(password);
    }
}
