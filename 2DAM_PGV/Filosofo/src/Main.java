public class Main {

    public static void main(String[] args) {

        Tenedor tenedor1x5 = new Tenedor("Tenedor 1x5");
        Tenedor tenedor2x5 = new Tenedor("Tenedor 2x5");
        Tenedor tenedor3x5 = new Tenedor("Tenedor 3x5");
        Tenedor tenedor4x5 = new Tenedor("Tenedor 4x5");
        Tenedor tenedor5x5 = new Tenedor("Tenedor 5x5");

        Filosofo filosofo1 = new Filosofo(tenedor5x5,tenedor1x5,"filosofo1");
        Filosofo filosofo2 = new Filosofo(tenedor5x5,tenedor1x5,"filosofo2");
        Filosofo filosofo3 = new Filosofo(tenedor5x5,tenedor1x5,"filosofo3");
        Filosofo filosofo4 = new Filosofo(tenedor5x5,tenedor1x5,"filosofo4");
        Filosofo filosofo5 = new Filosofo(tenedor5x5,tenedor1x5,"filosofo5");
    }
}