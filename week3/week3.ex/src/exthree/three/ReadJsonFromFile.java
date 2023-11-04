package exthree.three;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;

public class ReadJsonFromFile  {
    public static void main(String[] args) throws IOException {
       JsonObject obj =(JsonObject) JsonParser.parseReader(new FileReader("JSONExample.json"));
        // getting firstName and lastName
        System.out.println(obj);
        var map  = obj.asMap();
        System.out.println(map.get("firstName"));
        Object firstName =  obj.get("firstName");

        System.out.println(firstName);
        Object age =  obj.get("age");
        System.out.println(age);
//{"firstName":"John","lastName":"Smith","address":

    }
}
