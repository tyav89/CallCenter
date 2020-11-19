public class Main {
    public static void main(String[] args) {
        int sleep = 2000;
        ATC atc = new ATC();
        Thread threadATC = new Thread(atc);
        Thread threadSpecialist1 = new Thread(new Specialist(atc));
        Thread threadSpecialist2 = new Thread(new Specialist(atc));

        threadATC.start();
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadSpecialist1.start();
        threadSpecialist2.start();

        try {
            threadATC.join();
            threadSpecialist1.join();
            threadSpecialist2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
