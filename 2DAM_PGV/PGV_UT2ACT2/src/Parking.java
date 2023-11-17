import javax.xml.transform.stax.StAXResult;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Parking extends Thread{

    static Semaphore semaphore = new Semaphore(5);

    public Parking(String coche) {
        this.setName(coche);
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " buscando la plaza");
        System.out.println("Plaza resto: " + semaphore.availablePermits());
        if(semaphore.availablePermits()==0) {
            System.out.println(Thread.currentThread().getName() + " Esperando la plaza");
        }
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " aparcado");
            Thread.sleep(new Random().nextInt(9000+1)+1000);
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " salido");
            System.out.println("Plaza resto: " + semaphore.availablePermits());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
