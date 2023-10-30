package exercise2_2.chain_of_responsibility.handler;

import exercise2_2.chain_of_responsibility.Database;

public class PasswordHandler extends Handler
{
    private final Database db;
    public PasswordHandler(Database db){
        this.db= db;
    }
    @Override
    public boolean handle(String username, String password) {
        if(!db.isValidPassword(username,password))
        {
            System.out.println("The PassWord is not correct");
            return false;
        }
        return handleNext(username,password);
    }
}
