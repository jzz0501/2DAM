import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.SQLException;

public class MainW {

    public static void main(String[] args) throws SQLException, IOException {

        int[] num_emp = {3,2,22,1,4,7};
        String[] name = {"abc","bwd","css","dda","eds","fgs"};
        String[] telefono = {"123456789","123456789","123456789","123456789","123456789","123456789"};
        double[] salario = {14444,22222,33333,4444,522,62};

        RandomAccessFile raf = new RandomAccessFile("file\\Random.dat","rw");

        for (int i = 0; i < num_emp.length; i++) {
            raf.writeInt(num_emp[i]);
            writeString(raf,name[i],25);
            writeString(raf,telefono[i],9);
            raf.writeDouble(salario[i]);
        }
        raf.close();
    }

    public static void writeString(RandomAccessFile raf, String s, int leng) throws IOException {
        StringBuilder sb = new StringBuilder(s);
        sb.setLength(leng);
        raf.writeChars(sb.toString());
    }
}