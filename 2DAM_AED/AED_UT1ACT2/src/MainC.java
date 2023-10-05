import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class MainC {

    static final int NAME_LENG = 50;
    static final int SALARY_LENG = 8;
    static final int TELEFONO_LENG = 18;
    static final int NUMEMP_LENG = 4;
    static final int TOTALLENGBYGROUP = NAME_LENG + SALARY_LENG + TELEFONO_LENG + NUMEMP_LENG;
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        RandomAccessFile raf = new RandomAccessFile("file\\Random.dat","rw");

        int num_emp;

        while(next()) {
            switch(chooseOption("1 = find data by emp num 2 = import salary extra")) {
                case 1 -> {
                    num_emp = getInt("introduce un numero de empleado: ");
                    System.out.println(getDataByEmpNum(raf, num_emp));
                }
                case 2 -> {
                    num_emp = getInt("introduce un numero de empleado: ");
                    System.out.println(importSalaryByEmpNum(raf, num_emp)? "operation successful" : "operation failed");
                }
            }
        }
        raf.close();
    }

    public static boolean next() {
        System.out.print("next: ");
        return sc.nextLine().equals("yes");
    }

    public static int getInt(String message) {
        System.out.print(message);
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }

    public static String getDataByEmpNum(RandomAccessFile raf, int num_emp) throws IOException {

        String name, telefono;
        double salario;

        int pos = 0;
        while(pos < raf.length()) {
            raf.seek(pos);
            if(raf.readInt()==num_emp) {
                name = readString(raf, 25);
                telefono = readString(raf, 9);
                salario = raf.readDouble();
                return "num_emp: " + num_emp + " name: " + name.trim() + " telefono: " + telefono.trim() + " salario: " + salario;
            }
            pos += getNextDataPointer(pos);
        }
        return "no encontrado";

    }

    public static String readString(RandomAccessFile raf, int leng) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < leng; i++) {
            sb.append(raf.readChar());
        }
        return sb.toString();
    }

    public static int chooseOption(String message) {
        System.out.println(message);
        int optionSelected = sc.nextInt();
        sc.nextLine();
        return optionSelected;
    }

    public static boolean importSalaryByEmpNum(RandomAccessFile raf, int num_emp) throws IOException {

        double salario;
        double extra;

        int pos = 0;
        while(pos < raf.length()) {
            raf.seek(pos);
            if(raf.readInt()==num_emp) {
                raf.seek(raf.getFilePointer() + NAME_LENG + TELEFONO_LENG);
                salario = raf.readDouble();
                System.out.println("su salario sera: " + salario);
                System.out.print("import extra: ");
                extra = getDouble();
                raf.seek(raf.getFilePointer() - SALARY_LENG);
                raf.writeDouble(extra + salario);
                raf.seek(raf.getFilePointer() - SALARY_LENG);
                System.out.println("su nuevo salario sera: " + raf.readDouble());
                return true;
            }
            pos = getNextDataPointer(pos);
        }
        return false;
    }

    public static double getDouble() {
        double num = sc.nextDouble();
        sc.nextLine();
        return num;
    }

    public static int getNextDataPointer(int pos) {
        return pos + TOTALLENGBYGROUP - 4;
    }

}
