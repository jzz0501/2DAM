import java.io.*;

public class SYSTEMINFO {
    public static void main(String[] args) throws IOException {

        Process p = new ProcessBuilder("cmd.exe","/C","SYSTEMINFO").start();
        InputStream is = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(is,"GBK");
        BufferedReader br = new BufferedReader(isr);

        String info = "Directorio de sistema:";
        String dir = "";

        String s;
        while((s = br.readLine())!=null) {
            if(s.contains("Directorio de sistema:")) {
                dir = s.substring(info.length()+1).trim();
            }
        }

        Process p2 = new ProcessBuilder("cmd.exe","/C","bat\\bat3.bat").start();
        OutputStream os = p2.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        osw.write(dir);
        osw.flush();

        is = p2.getInputStream();
        isr = new InputStreamReader(is);
        br = new BufferedReader(isr);
        while((s = br.readLine())!=null) {
            System.out.println(s);
        }
        osw.close();
        br.close();
    }
}
