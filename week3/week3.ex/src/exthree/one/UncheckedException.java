package exthree.one;

import java.util.ArrayList;
import java.util.List;

public class UncheckedException {
    public static void nullCheck(){
        String s=null;
        System.out.println(s.length());
    }
    public static void outOfBound(){
        String s=null;
        System.out.println(s.length());
    }
    public static void main(String[] args) {
        try{
        nullCheck();
//            outOfBound();
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }

    }
}
