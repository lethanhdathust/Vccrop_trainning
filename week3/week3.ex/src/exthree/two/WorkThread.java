package exthree.two;

public class WorkThread implements  Runnable{
    private final int id;
    public WorkThread(int s){
        this.id=s;
    }
    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start Command =" + id);
        process();
        System.out.println(Thread.currentThread().getName()+" End");
    }
    private void process(){
        try {
            Thread.sleep(1500);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
