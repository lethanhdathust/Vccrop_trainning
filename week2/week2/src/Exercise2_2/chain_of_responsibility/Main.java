package Exercise2_2.chain_of_responsibility;

import Exercise2_2.chain_of_responsibility.handler.AdminCheckHandle;
import Exercise2_2.chain_of_responsibility.handler.Handler;
import Exercise2_2.chain_of_responsibility.handler.PasswordHandler;
import Exercise2_2.chain_of_responsibility.handler.UserNameHandle;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Database db= new Database();
        Handler h1 = new UserNameHandle(db);
        Auth a = new Auth(h1);
        h1.setNextHandler(new AdminCheckHandle()).setNextHandler(new PasswordHandler(db));
    }
}
