public class MiHilo_Runnable implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " ejecutado " + i + "veces");
        }
        System.out.println(Thread.currentThread().getName() + " terminada de ejecutar");
    }
}
