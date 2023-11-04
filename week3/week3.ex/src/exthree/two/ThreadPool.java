package exthree.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(4);
//        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 10 ; i++){
            Runnable worker = new WorkThread(i);
            executorService.execute(worker);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            System.out.println("Terminated");
        }
        System.out.println("Finished all threads");
    }
}
