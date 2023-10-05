import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        /*
        ProcessBuilder pb = new ProcessBuilder("notepad.exe");
        Process p = pb.start();
        */

        /*
        ProcessBuilder pb = new ProcessBuilder("bat\\bat1.bat");
        Process p = pb.start();

        InputStreamReader isr = new InputStreamReader(p.getInputStream(),"GBK");
        BufferedReader br = new BufferedReader(isr);

        String s;
        while ((s = br.readLine())!=null) {
            System.out.println(s);
        }
        */

        /*
        ProcessBuilder pb = new ProcessBuilder("cmd.exe","/C","java -jar jar\\HelloWorld.jar");
        Process p = pb.start();

        InputStream is = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String s;
        while ((s = br.readLine())!=null) {
            System.out.println(s);
        }
        */
    }
}
