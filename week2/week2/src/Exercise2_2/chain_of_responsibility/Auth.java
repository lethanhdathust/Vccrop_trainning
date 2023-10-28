package Exercise2_2.chain_of_responsibility;

import Exercise2_2.chain_of_responsibility.handler.Handler;

public class Auth {
    private final Handler handler;
    public Auth(Handler handler){
        this.handler=handler;
    }
    public boolean login(String username, String password){
        if(handler.handle(username,password)){
            System.out.println("Login success");
            return true;
        }
        return false;
    }
}
