public class Main {
    public static void main(String[] args) {
        ATC atc = new ATC();
        Thread threadATC = new Thread(atc);
        Thread threadSpecialist1 = new Thread(new Specialist(atc));
        Thread threadSpecialist2 = new Thread(new Specialist(atc));

        threadATC.start();

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
