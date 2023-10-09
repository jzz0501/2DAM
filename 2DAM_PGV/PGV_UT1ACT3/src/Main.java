import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        //1. El proceso padre (main de esta clase) crea primer proceso que se ejecuta el comando msconfig
        Process p = new ProcessBuilder("msconfig").start();

        //2. Introduce una ruta de carpeta por el usuario para ocultar los ficheros de la carpeta introducido
        System.out.print("Introduce la ruta de carpeta: ");
        String s = new Scanner(System.in).nextLine();
        //3. El proceso padre (main de esta clase) crea segundo proceso que se ejecuta el fichero jar para ocultar los ficheros
        Process p2 = new ProcessBuilder("java","-jar","./out/artifacts/PGV_UT1ACT3_jar/PGV_UT1ACT3.jar").start();
        //4. Obtener el flujo de salida de segundo proceso para pasar la ruta de carpeta introducido por proceso padre al proceso hijo
        OutputStreamWriter osw = new OutputStreamWriter(p2.getOutputStream());
        osw.write(s);
        osw.close();

        //5. Hacer una sincronizacion para que esperar hasta que termina el segundo proceso hijo
        while(true) {
            if(!p2.isAlive()) {
                break;
            }
        }

        /* 6.
           Hasta que segundo proceso se termina (para hacer seguro que esta terminada de operacion con fichero)
           Crea tercer proceso para mostrar los informaciones de esta carpeta
        */
        Process p3 = new ProcessBuilder("cmd.exe","/C","dir " + s).start();
        //7. Obtener el flujo de entrada de tercer proceso hijo para leer su salidas de datos
        BufferedReader br = new BufferedReader(new InputStreamReader(p3.getInputStream(),"GBK"));
        String s2;
        while ((s2 = br.readLine())!=null) {
            System.out.println(s2);
        }

        //8. Ante de finalizar, destruye primer proceso hijo
        p.destroy();
    }
}