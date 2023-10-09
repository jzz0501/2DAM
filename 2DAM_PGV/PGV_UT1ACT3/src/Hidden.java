import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//Clase para hacer el fichero de jar, ruta ---> PGV_UT1ACT3\out\artifacts\PGV_UT1ACT3_jar\PGV_UT1ACT3.jar
public class Hidden {

    public static void main(String[] args) throws IOException {

        /* 1.
           Definir una cadena para recibir la ruta introducida por proceso padre
           Cuando utiliza el metodo nextLine() el hilo de este proceso se va a bloquear
           (Ya que en java si no crea el hilo por manual pues solo tiene un hilo (hilo main), pues si se bloquea, el proceso se para)
        */
        String s = new Scanner(System.in).nextLine();

        // 2. Crea un variable de clase File para instanciar la ruta de carpeta introducido
        File files = new File(s);

        // 3. Un bucle para recorrer todos los ficheros en dentro de carpeta instanciado y operarlo con archivo lotes para ocultar
        for (File file:files.listFiles()) {
            Process p = new ProcessBuilder("./bat/hidden.bat").start();
            OutputStreamWriter osw = new OutputStreamWriter(p.getOutputStream());
            osw.write(file.getAbsolutePath());
            osw.close();
        }

    }
}
