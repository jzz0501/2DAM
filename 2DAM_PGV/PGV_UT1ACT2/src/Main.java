import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        /*
        Scanner sc = new Scanner(System.in);
        System.out.print("introduce un string: ");
        String s = sc.nextLine();

        ProcessBuilder pb = new ProcessBuilder("cmd.exe","/C","java -jar jar\\TOUPPERCASE.jar");
        Process p = pb.start();
        ProcessBuilder pb2 = new ProcessBuilder("cmd.exe","/C","wmplayer \"I:\\2DAM\\PGV\\ACT2\\mp4\\see you again.mp4\"");
        Process p2 = pb2.start();

        OutputStream os = p.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        osw.write(s);
        osw.close();

        InputStream is = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String s2;
        while((s2=br.readLine())!=null) {
            System.out.println(s2);
        }
        */


        /*
        ProcessBuilder pb = new ProcessBuilder("cmd","/C","bat\\bat1.bat");
        Process p = pb.start();

        InputStream is = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(is,"GBK");
        BufferedReader br = new BufferedReader(isr);

        String s;
        while((s = br.readLine())!=null) {
            if(s.contains("svchost.exe")) {
                System.out.println(s);
                System.out.println(br.readLine());
                System.out.println(br.readLine());
                System.out.println();
            }
        }

        br.close();
        isr.close();
        is.close();
        */


        /*
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre de servicio: ");
        String s = sc.nextLine();

        ProcessBuilder pb = new ProcessBuilder("cmd","/C","bat\\bat2.bat");
        Process p = pb.start();

        OutputStream os = p.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        osw.write(s);
        osw.flush();

        InputStream is = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String s2;
        while((s2 = br.readLine()) != null) {
            System.out.println(s2);
        }
        */

    }
}
