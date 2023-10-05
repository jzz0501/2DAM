import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Servicio {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String s = "sc qc " + sc.nextLine();
        Process p = new ProcessBuilder("cmd.exe","/C",s).start();
        InputStream is = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String s2;
        while ((s = br.readLine())!=null) {
            System.out.println(s);
        }
    }
}
