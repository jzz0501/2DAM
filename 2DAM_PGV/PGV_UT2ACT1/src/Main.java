public class Main {

    public static void main(String[] args) throws InterruptedException {
        
        /*
        for (int i = 1; i <= 4; i++) {
            new Thread(new MiHilo_Runnable(), "Hilo " + i).start();
        }
        */


        MiHilo_Thread t1 = new MiHilo_Thread("tarea 1", 1);
        MiHilo_Thread t2 = new MiHilo_Thread("tarea 2", 5);
        MiHilo_Thread t3 = new MiHilo_Thread("tarea 3", 10);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("terminada de ejecutar");
    }
}