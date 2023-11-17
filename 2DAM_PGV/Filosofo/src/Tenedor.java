import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tenedor extends Thread{

    private Lock lock = new ReentrantLock();
    private boolean isUsing = false;

    public Tenedor(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            this.isUsing = true;
            try {
                Thread.sleep(new Random().nextInt(9000 + 1) + 1000);
                lock.unlock();
                isUsing = false;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isUsing() {
        return this.isUsing;
    }

    public Lock getLock() {
        return lock;
    }
}
