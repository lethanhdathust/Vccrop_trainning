package exthree.two;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class LockEx {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        MethodCounter counter = new MethodCounter();
        executorService.execute(() -> {
            int a = counter.incrementAndGetCounter();
            System.out.println("Thread1: "+ Thread.currentThread().getName()+ " " + a);
        });
        executorService.execute(() -> {
            int a = counter.incrementAndGetCounter();
            System.out.println("Thread: "+ Thread.currentThread().getName()+ " " + a);
        });
//        for(int i = 0; i < 10 ; i++){
//            Runnable runnable =new WorkThread(i);
//            counter.incrementAndGetCounter();
//            executorService.execute(runnable);
//        }
        executorService.shutdown();
    }
}
class MethodCounter{
    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;
    public int incrementAndGetCounter(){
//        lock.lock();
        boolean isAcquired = lock.tryLock();
        System.out.println("Acquired "+ isAcquired);
        if (isAcquired){
            try {
                lock.lock();

                Thread.sleep(1000);
                count+=1;
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }
        return count;
    }
}