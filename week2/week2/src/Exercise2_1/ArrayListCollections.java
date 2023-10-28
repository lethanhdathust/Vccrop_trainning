package Exercise2_1;

import java.util.ArrayList;
import java.util.List;

public class ArrayListCollections {
    public static void one(){
        ArrayList<String> list = new ArrayList<>();

//        Add the elements to the list
        list.add(0,"3");

        list.add(1,"3");

        list.add(2,"32");
        System.out.println("Add the element to the specification index");
        for (String a: list
        ) {
            System.out.println(a);
        }
    }
    public static void two(){
//        Add the elements to the list
        ArrayList<String> list = new ArrayList<>();

        list.add("3");
        list.add("3");
        list.add("32");
        System.out.println("Add the element");
        for (String a: list
        ) {
            System.out.println(a);
        }
    }
    public static void three(){
        ArrayList<String> list = new ArrayList<>();

        ArrayList<String> b = new ArrayList<>(3);
        b.add("1");
        b.add("2");
        b.add("#");
        b.add("#");
        list.addAll(b);
        System.out.println("Add the element");
        for (String a: list
        ) {
            System.out.println(a);
        }
    }
    public static void four()
    {
        // Creating an empty Integer ArrayList
        ArrayList<Integer> arr = new ArrayList<Integer>(3);

        // Adding elements to above ArrayList
        // using add() method
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);

        // Printing the elements inside current ArrayList
        System.out.println("The list initially: " + arr);

        // Clearing off elements
        // using clear() method
        arr.clear();

        // Displaying ArrayList elements
        // after using clear() method
        System.out.println(
                "The list after using clear() method: " + arr);
    }
    public static void five()
    {
        // Creating an empty Integer ArrayList
        ArrayList<Integer> arr = new ArrayList<Integer>(3);

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        Integer val = arr.get(3);
        System.out.println(val);


    }
    public static void main(String[] args) {
//    Create the List object interface implemented by the ArrayList class
        System.out.println("This is the function one");
        one();
        System.out.println("This is the function two");
        two();
        System.out.println("This is the function three");
        three();
        System.out.println("This is the function four");
        four();
        System.out.println("This is the function five");
        five();
    }
}
