package Exercise2_2.singleton;

public class User {
    private static User instance;
    private final String name;
//    private String email;

    private User(String name){
        this.name=name;
    }

    public static User getInstance(String name){
        if(instance == null){
            System.out.println("1");
            instance = new User(name);
        }
        return instance;
    }
    public String getNameAndEmail(){
        return "name"+name +" " ;
    }

    public static void main(String[] args) {
        User user1 = User.getInstance("Dat");
        User user2 = User.getInstance("Lam");
        System.out.println(user1.name);
        System.out.println(user2.name);


    }
}
