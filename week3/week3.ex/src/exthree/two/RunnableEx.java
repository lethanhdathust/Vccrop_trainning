package exthree.two;

public class RunnableEx {
    public static void main(String[] args) {
        System.out.println("Main thread is : " + Thread.currentThread().getName());
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ignored) {
                }
                int r = 1/0;
                System.out.println(Thread.currentThread().getName()+" execute");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " execute run()");
            }
        });

        t1.start();
        t2.start();
    }


}
