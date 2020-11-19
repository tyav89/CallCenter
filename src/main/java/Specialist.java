public class Specialist implements Runnable{
    ATC atc;
    private int timeWork = 3000;
    private String number;

    public Specialist(ATC atc) {
        this.atc = atc;
    }

    @Override
    public void run() {
        while (!atc.empty()) {
            number = atc.getBell();
            try {
                Thread.sleep(timeWork);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(number + " обработан");
        }
    }
}
