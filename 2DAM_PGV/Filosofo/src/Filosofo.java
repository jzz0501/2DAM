import java.util.Random;

public class Filosofo extends Thread{

    private final Tenedor tenedor_left;
    private final Tenedor tenedor_right;

    public Filosofo(String name, Tenedor left, Tenedor right) {
        this.setName(name);
        this.tenedor_left = left;
        this.tenedor_right = right;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " esta pensando");
            synchronized (tenedor_left) {
                System.out.println(Thread.currentThread().getName() + " ha cogido su tenedor izquierda");
                synchronized (tenedor_right) {
                    System.out.println(Thread.currentThread().getName() + " ha cogido su tenedor derecha");
                    System.out.println(Thread.currentThread().getName() + " esta comiendo");
                    /*
                    try {
                        Thread.sleep(new Random().nextInt(9000)+1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    */
                }
            }
        }
    }
}
