package Exercise2_2.chain_of_responsibility.handler;

import Exercise2_2.chain_of_responsibility.Database;

public class UserNameHandle extends Handler{
    private final Database db;
    public UserNameHandle(Database db){
        this.db = db;
    }
    @Override
    public boolean handle(String username, String password) {
        if(!db.isValidUsers(username))
        {
            System.out.println("The User Name is not correct");
            return false;
        }
        return handleNext(username,password);
    }
}
