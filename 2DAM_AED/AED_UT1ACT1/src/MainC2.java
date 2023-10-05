import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainC2 {

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);

        File file = new File("files\\file1.txt");
        FileReader fr = new FileReader(file);

        int lenght;
        char[] chars = new char[10];
        while ((lenght = fr.read(chars)) != -1) {
            System.out.print(new String(chars,0,lenght));
            sc.nextLine();
        }

    }
}
