import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class MainE {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        FileOutputStream fos = new FileOutputStream("files\\file4.txt");
        FileInputStream fis = new FileInputStream("files\\file4.txt");

        String letter;
        for (int i = 0; i < 50; i++) {
            letter = sc.nextLine();
            fos.write(letter.charAt(0));
        }

        for (int i = 0; i < 10; i++) {
            fos.write('+');
        }

        int asc;
        while ((asc = fis.read()) != -1) {
            System.out.print((char) asc);
        }

        fis.close();
        fos.close();
    }
}
