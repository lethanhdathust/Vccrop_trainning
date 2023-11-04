package exthree.two;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapEx {
    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();
//        HashMap <String , Integer> map = new HashMap<>();
        Thread thread1 = new Thread(()-> {
            for (int i = 0 ; i < 1000 ; i++){
                    map.put("Key" + i , i);
            }
        });
        Thread thread2 = new Thread(()-> {
            for (int i = 0 ; i < 500 ; i++){
                map.remove("Key" + i , i);
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // In số lượng phần tử còn lại trong map
        System.out.println("Số lượng phần tử trong ConcurrentHashMap: " + map.size());
    }
}
