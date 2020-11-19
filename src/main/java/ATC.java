import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ATC implements Runnable{
    private int count = 60;
    private int sleep = 1000;
    private Deque<Bell> bellDeque = new ConcurrentLinkedDeque<>();

    @Override
    public void run() {
        for (int i = 1; i <= count; i++){
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bellDeque.add(new Bell(i));
            if(i <= count) {
                synchronized (this){
                    this.notify();
                }
            }
        }
    }

    public Boolean empty(){
        return bellDeque.isEmpty();
    }

    public String getBell() {
        if (empty()){
            return null;
        } else {
            return bellDeque.remove().toString();
        }
    }

}
