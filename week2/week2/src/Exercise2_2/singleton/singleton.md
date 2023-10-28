**1. Description** 
- **`Singleton`** is a creational design pattern that lets you ensure that a class has only one instance while providing a global access point to this instance.

(Creational patterns: 
These patterns provide various object creation mechanisms, which increase flexibility and reuse of existing code.)
![alt](https://gpcoder.com/wp-content/uploads/2018/09/singleton-pattern.png)

**2. Why we need use singleton**

- Ensure that a class has just a single instance: We want to control access to some shared resource - such as : User, database, ...
Clients will work with the same instance all the time.

- Provide a global access point to that instance :  The Singleton pattern lets you access some object from anywhere in the program.However, is also protects that instance from being overwritten .

**3. How we can do Singleton**
- Make the default constructor private, to prevent clients from initialize the new instance 
  - Create a static creation method that acts as a constructor. Inside the method, This method calls the private constructor to create an object and saves it in a static field.All following calls to this method return to the same instance.  

**4.My Project**


    public class User {
    private static User instance;
    private final String name;
    /   /    private String email;

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

- In my project , I use singleton because i only want a instance of User to use in all app.
In this example, i have used the static User instance to share the object to other instances.
- We do not initialize the instance through the constructor. Instead, we make the constructor private, then create the public method "getInstance()" to initialize the instance.
if there is an instance that has been initialized, the method will return the same instance.
- I have created two instances: user1 and user2 with the different names.But Both of them reference to the same object, so the user1.name and user2.name will return "Dat" same.

5.Applicability

- Use the Singleton pattern when a class in your program should have just one instance for sharing to all apps.Example, The USer object when user signs in shared to by different parts of the program. 