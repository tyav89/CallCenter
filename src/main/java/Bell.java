public class Bell {
    private int count;

    public Bell(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Звонок " + count;
    }
}
