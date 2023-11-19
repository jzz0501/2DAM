public class Main {

    public static void main(String[] args) {

        Tenedor between1_2 = new Tenedor("1_2");
        Tenedor between2_3 = new Tenedor("2_3");
        Tenedor between3_4 = new Tenedor("3_4");
        Tenedor between4_5 = new Tenedor("4_5");
        Tenedor between5_1 = new Tenedor("5_1");

        new Filosofo("Filosofo 1", between5_1, between1_2).start();
        new Filosofo("Filosofo 2", between1_2, between2_3).start();
        new Filosofo("Filosofo 3", between2_3, between3_4).start();
        new Filosofo("Filosofo 4", between3_4, between4_5).start();
        new Filosofo("Filosofo 5", between4_5, between5_1).start();


    }
}