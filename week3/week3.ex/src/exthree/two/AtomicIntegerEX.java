package exthree.two;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerEX {
    public static void main(String[] args) throws InterruptedException {
        ProcessingThread processingThread = new ProcessingThread();
        Thread thread1 = new Thread(processingThread,"t1");
        Thread thread2 = new Thread(processingThread,"t2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println( " count:" +  processingThread.getCount());
        System.out.println(" number :" + processingThread.number);
    }

}


class ProcessingThread implements Runnable{
    private  AtomicInteger count= new AtomicInteger();
    int number = 0;

    public int getCount(){
        return this.count.get();
    }
    private void processSomething(int i){
        try{
            number++;
            Thread.sleep(i*100);
        }catch (InterruptedException e){
            e.printStackTrace();

        }
    }


    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            processSomething(i);
            count.incrementAndGet();
        }
    }
}
