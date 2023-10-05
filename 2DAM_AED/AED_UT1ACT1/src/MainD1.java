import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainD1 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new FileReader("files\\file2.txt"));

        String cadena;
        while ((cadena = br.readLine()) != null) {
            System.out.print(cadena);
            sc.nextLine();
        }

        br.close();
    }
}
