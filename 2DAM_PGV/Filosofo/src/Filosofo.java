import java.util.PropertyResourceBundle;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Filosofo extends Thread {

    private Tenedor tenedor_izquierda;
    private Tenedor tenedor_derecha;
    private Lock lockTenedor_izquierda;
    private Lock lockTenedor_derecha;

    public Filosofo(Tenedor tenedor_izquierda, Tenedor tenedor_derecha, String name) {
        this.tenedor_izquierda = tenedor_izquierda;
        this.tenedor_derecha = tenedor_derecha;
        this.lockTenedor_izquierda = tenedor_izquierda.getLock();
        this.lockTenedor_derecha = tenedor_derecha.getLock();
        this.setName(name);
    }

    @Override
    public void run() {
        while(true) {
            if (tenedor_izquierda.isUsing()) {
                System.out.println(tenedor_izquierda.getName() + " esta usando, " + this.getName() + " tiene que esperar");
            } else if (tenedor_derecha.isUsing()) {
                System.out.println(tenedor_derecha.getName() + " esta usando, " + this.getName() + " tiene que esperar");
            }
            lockTenedor_izquierda.lock();
            lockTenedor_derecha.lock();
            System.out.println(this.getName() + " logrado los dos tenedores, y esta comiendo");
            try {
                Thread.sleep(new Random().nextInt(9000+1)+1000);
                lockTenedor_izquierda.unlock();
                lockTenedor_derecha.unlock();
                System.out.println(this.getName() + " Terminada de comer, libera los dos tenedores");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
