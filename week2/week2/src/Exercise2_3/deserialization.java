package Exercise2_3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;

public class deserialization {
    public static void main(String[] args) {
//        ----- it is deserialization


            try (ObjectInputStream object = new ObjectInputStream(new FileInputStream("object.txt"));
                 ObjectInputStream cha = new ObjectInputStream(new FileInputStream("char.txt"));
                 ObjectInputStream i = new ObjectInputStream(new FileInputStream("int.txt"))) {

                // Read the object
                try {
                    Student st = (Student) object.readObject();
                    System.out.println("Name: " + st.getName());
                } catch (OptionalDataException e) {
                    // Handle OptionalDataException if required
                    e.printStackTrace();
                    System.out.println("Optional data encountered during object deserialization: " + e.getMessage());
                }

                // Read the String from input
                try {
                    String a = String.valueOf(cha.readChar());
                    System.out.println(a);
                } catch (OptionalDataException e) {
                    // Handle OptionalDataException if required
                    System.out.println("Optional data encountered during char deserialization: " + e.getMessage());
                }

                // Read the int value
                try {
                    int b = i.readInt();
                    System.out.println(b);
                } catch (OptionalDataException e) {
                    // Handle OptionalDataException if required
                    System.out.println("Optional data encountered during int deserialization: " + e.getMessage());
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
}
