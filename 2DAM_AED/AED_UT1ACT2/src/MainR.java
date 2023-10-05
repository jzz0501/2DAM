import java.io.*;

public class MainR {
    public static void main(String[] args) throws IOException {

        DataInputStream dis = new DataInputStream(new FileInputStream("file\\Random.dat"));
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("file\\Empleados_DIO.dat"));

        try {
            while (true) {
                dos.writeInt(dis.readInt());
                dos.writeChars(readString(dis,25));
                dos.writeChars(readString(dis,9));
                dos.writeDouble(dis.readDouble());
            }
        } catch (EOFException e) {

        } finally {
            dis.close();
            dos.close();
        }


        DataInputStream dis2 = new DataInputStream(new FileInputStream("file\\Random.dat"));

        try {
            while (true) {
                int num_emp = dis2.readInt();
                String name = readString(dis2, 25);
                String telefono = readString(dis2, 9);
                double salario = dis2.readDouble();
                if(salario > 5000) {
                    System.out.println("num_emp: " + num_emp +
                                        " name: " + name.trim() +
                                        " telefono: " + telefono.trim() +
                                        " salario: " + salario);
                }
            }
        } catch (EOFException e) {

        } finally {
            dis2.close();
        }
    }

    public static String readString(DataInputStream dis, int leng) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < leng; i++) {
            sb.append(dis.readChar());
        }
        return sb.toString();
    }
}
