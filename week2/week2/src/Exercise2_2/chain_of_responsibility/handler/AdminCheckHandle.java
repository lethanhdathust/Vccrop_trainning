package Exercise2_2.chain_of_responsibility.handler;

public class AdminCheckHandle extends  Handler{

    @Override
    public boolean handle(String username, String password) {
        if("admin".equals(username)){
            System.out.println("Navigate to the Admin page");
            return true;
        }
        return handleNext(username,password);
    }
}
