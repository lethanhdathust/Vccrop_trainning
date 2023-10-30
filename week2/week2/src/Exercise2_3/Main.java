package Exercise2_3;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try {
            Student x = new Student("dat");
            String d = "k";
            int n = 12;
            FileOutputStream object = new FileOutputStream("object.");

            FileOutputStream charEx = new FileOutputStream("char.txt");
            FileOutputStream intEx = new FileOutputStream("int.txt");

            ObjectOutputStream output = new ObjectOutputStream(object);
            ObjectOutputStream output1 = new ObjectOutputStream(charEx);
            ObjectOutputStream output2 = new ObjectOutputStream(intEx);
            output.writeObject(x);
            output1.writeChars(d);
            output2.writeInt(n);
            output.close();
            output.flush();
            output1.close();
            output1.flush();
            output2.flush();
            output2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//

    }
}


