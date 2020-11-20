public class Specialist implements Runnable{
    ATC atc;
    private int timeWork = 3000;
    private Bell bell;
    public Specialist(ATC atc) {
        this.atc = atc;
    }

    @Override
    public void run() {
        while (atc.getBellQueueSize() > 0) {
            bell = atc.getBell();
            if(bell != null){
                System.out.println(bell + " обработан");
            }
            try {
                Thread.sleep(timeWork);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //atc.bellInQueue();

        }
    }
}
