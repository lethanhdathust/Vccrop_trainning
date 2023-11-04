package exthree.one;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckException  {
    public static void readFile() throws FileNotFoundException {
        File file = new File("not_existing_file.txt");
        FileInputStream stream = new FileInputStream(file);
    }
    public static void readFile2()  {
        try{
            File file = new File("not_existing_file.txt");
            FileInputStream stream = new FileInputStream(file);
        }catch (FileNotFoundException e)
        {
            throw new RuntimeException("The File does not exists");
//            e.printStackTrace();
        }

    }
    public static void main(String[] args)  {
//        readFile();
        readFile2();
    }

}
