import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main2_Update {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        //Crear una flujo de acceso aleatorio para hacer lectura y modificar
        RandomAccessFile raf = new RandomAccessFile("FILE\\datosEquipos.dat","rw");

        //Definir un entero para registrar el usuario que numero elegido
        String num_selected;
        while(next()) {
            System.out.print("pides un numero de club: ");
            num_selected = sc.nextLine();
            //Imprimir el resultado de metodo findDataByClubNum, cuyo resultado es despues de datos modificado de numero club elegido
            System.out.println(findDataByClubNum(raf, Integer.parseInt(num_selected)));
        }
    }

    //Una condicional para seguir de bucle
    public static boolean next() {
        System.out.print("next: ");
        String s = sc.nextLine();
        return s.equals("yes");
    }

    //Metodo para buscar la posicion de datos que queremos modificar depende de numero elegido
    public static String findDataByClubNum(RandomAccessFile raf, int num_selected) throws IOException {

        //Variable para indicar el inicio de cada grupo de datos, 0 = inicio de fichero
        int pos = 0;
        //Variable para guardar el numero de telefono que queremos modificar
        String telefono_temp;
        //Bucle while para recorrer cada grupo de datos de su principio (num_club)
        while(pos < raf.length()) {
            raf.seek(pos);
            //Si este grupo su inicio tiene guardado un entero igual que numero introducido por usuario, pues realizar su instrucciones
            if((raf.readInt()) == num_selected) {
                System.out.print("Introduce numero de telefono: ");
                telefono_temp = sc.nextLine();
                //Despues de introducir el numero de telefono, pasar el puntero al ante de registro telefono
                raf.seek(raf.getFilePointer() + DATA.NAMECLUB_SIZE + DATA.PRESIDENTE_SIZE);
                //Utilizar metodo writeString para modificar el dato de esta posicion
                Main1_Write.writeString(raf, telefono_temp, DATA.TELEFONO_LENG);
                //Despues de modificar, pasar el puntero al ante de este grupo de datos
                raf.seek(pos);
                //Y desvuelve los datos completos de este grupo de datos
                return "num_club: " + raf.readInt() +
                        " name_club: " + readString(raf, DATA.NAMECLUB_LENG) +
                        " presidente: " + readString(raf, DATA.PRESIDENTE_LENG) +
                        " telefono: " + readString(raf, DATA.TELEFONO_LENG) +
                        " localidad: " + readString(raf, DATA.LOCALIDAD_LENG);
            }
            //Si no es igual, pues directamente saltar al siguiente grupo de datos
            pos = pos + DATA.TOTAL_SIZE;
        }
        //Si termina el bucle y no encuentra, delvueve un string no encontrado
        return "No encontrado el numero de club";
    }

    //Metodo para hacer lectura de caracteres, con parametro int leng para decidir cuantas caracter se va a leer
    public static String readString(RandomAccessFile raf, int leng) throws IOException {
        //Utilizar StringBuilder (En este caso no es un programa de multihilo, que solo tiene un hilo de main, pues no tiene problema de sincronizacion) para unir los caracteres
        StringBuilder sb = new StringBuilder();
        //Un bucle para recorrer a leer los caracteres de fichero depende de longitud decidido por parametro
        for (int i = 0; i < leng; i++) {
            sb.append(raf.readChar());
        }
        //Retornea resultado
        return sb.toString().trim();
    }
}
