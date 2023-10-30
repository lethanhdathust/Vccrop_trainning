package exercise2_2.chain_of_responsibility;

import exercise2_2.chain_of_responsibility.handler.AdminCheckHandle;
import exercise2_2.chain_of_responsibility.handler.Handler;
import exercise2_2.chain_of_responsibility.handler.PasswordHandler;
import exercise2_2.chain_of_responsibility.handler.UserNameHandle;

public class Main {
    public static void main(String[] args) {
        Database db= new Database();
        Handler handlerUsernameCheck = new UserNameHandle(db);
        Handler handlerAdminCheck = handlerUsernameCheck.setNextHandler(new AdminCheckHandle());
        handlerAdminCheck.setNextHandler(new PasswordHandler(db));
        Auth a = new Auth(handlerUsernameCheck);
        a.login("taikhoan1","matkhau1");
//        a.login("admin","admin");
//        a.login("taikoa","taik");

    }
}
