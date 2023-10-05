import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainC3 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        FileWriter fw = new FileWriter("files\\file5.txt");
        String letter;

        while (!(letter = sc.nextLine()).equals("#")) {
            fw.write(letter.charAt(0));
        }

        String cadena = sc.nextLine();
        fw.write(cadena);

        fw.close();
        sc.close();
    }
}
