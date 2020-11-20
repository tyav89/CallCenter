import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ATC implements Runnable{
    private int count = 60;
    private int sleep = 1000;
    private Queue<Bell> bellQueue = new ConcurrentLinkedQueue<>();

    @Override
    public void run() {
        for (int i = 1; i <= count; i++){
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bellQueue.add(new Bell(i));
        }

    }

    public Bell getBell() {
       return bellQueue.poll();
    }

    public int getBellQueueSize(){
        return bellQueue.size();
    }

    /*public void bellInQueue(){
        System.out.println("Звонков в очереди " + bellQueue.size());
    }*/
}
