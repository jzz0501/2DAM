public class MiHilo_Thread extends Thread {

    public MiHilo_Thread(String name, int priotiry) {
        this.setName(name);
        this.setPriority(priotiry);
    }

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " ejecutado " + i + " veces, su prioridad es " + this.getPriority());

            if (i == 5) {
                if (this.getPriority() == 1) {
                    this.setPriority(10);
                } else if (this.getPriority() == 10) {
                    this.setPriority(1);
                }
                System.out.println(Thread.currentThread().getName() + " modificado la prioridad al " + this.getPriority());
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
