package exthree.three;

import com.google.gson.Gson;

public class StringToJsonUsingGSON {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Person person = new Person("dat", 5, "GNhe An");

        //Convert object to String
        String result = gson.toJson(person);
        System.out.println(result);
    }
}
 class Person {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String toString() {
        return name + " - " + age + " - " + address;
    }
}
