public class Main {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <= 10; i++) {
            new Parking("Coche " + i).start();
            Thread.sleep(500);
        }
    }
}