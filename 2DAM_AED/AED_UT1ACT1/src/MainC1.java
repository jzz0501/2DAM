import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainC1 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        File file = new File("files\\file1.txt");
        FileReader fr = new FileReader(file);

        int letter;
        while ((letter = fr.read()) != -1) {
            System.out.println((char) letter);
        }

    }
}
