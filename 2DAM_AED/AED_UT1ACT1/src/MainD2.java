import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainD2 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedWriter bw = new BufferedWriter(new FileWriter("files\\file3.txt"));

        String cadena;
        while (!(cadena = sc.nextLine()).equals("#")) {
            bw.write(cadena);
            bw.newLine();
        }

        bw.close();

    }
}
