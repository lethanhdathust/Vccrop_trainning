package Exercise2_3;

import java.io.*;

public class Main {
    public static class Student implements Serializable{
        String name;

        public void setName(String name) {
            this.name = name;
        }

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    public static void main(String[] args) {
        try {
            Student x= new Student("dat");
            String d ="k";
            int n = 12;
            FileOutputStream a = new FileOutputStream("object.txt");

            FileOutputStream b = new FileOutputStream("char.txt");
            FileOutputStream c = new FileOutputStream("int.txt");

            ObjectOutputStream output = new ObjectOutputStream(a);
            ObjectOutputStream output1 = new ObjectOutputStream(b);
            ObjectOutputStream output2 = new ObjectOutputStream(c);
            output.writeChars(d);
            output1.writeObject(x);
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
