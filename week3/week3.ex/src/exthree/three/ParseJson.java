package exthree.three;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ParseJson {
    public static void main(String[] args) throws IOException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("firstName", "John");
        jsonObject.put("lastName", "Smith");
        jsonObject.put("age", 25);
        HashMap m = new HashMap(4);
        m.put("streetAddress", "21 2nd Street");
        m.put("city", "New York");
        m.put("state", "NY");
        m.put("postalCode", 10021);
        jsonObject.put("address",m);
        JsonArray jsonArray = new JsonArray();
        m = new HashMap(2);
        m.put("type", "fax");
        m.put("number", "212 555-1234");

        // adding map to list
        jsonArray.add(m);

        // putting phoneNumbers to JSONObject
        jsonObject.put("phoneNumbers", jsonArray);
        // writing JSON to file:"JSONExample.json" in cwd
        File e = new File("t.json");
        FileOutputStream f = new FileOutputStream(e);
        f.write(jsonObject.toJson().getBytes());
        f.close();
        f.flush();
//        -------------
        PrintWriter pw = new PrintWriter("JSONExample.json");
        System.out.println(jsonObject);
        System.out.println(jsonObject.toJson());
        pw.write(jsonObject.toJson());

        pw.flush();
        pw.close();
    }
}
