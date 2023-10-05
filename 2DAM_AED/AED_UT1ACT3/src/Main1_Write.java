import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main1_Write {

    public static void main(String[] args) throws IOException {

        //Crear una entrada flujo de caracter con la clase BufferedReader
        BufferedReader br = new BufferedReader(new FileReader("File\\datosEquipos.txt"));
        //Crear una flujo de acceso aleatorio
        RandomAccessFile raf = new RandomAccessFile("File\\datosEquipos.dat","rw");

        //Definir una string para guardar la cada linea de fichero
        String cadena;
        //Un bucle para hacer la lectura de fichero
        while((cadena = br.readLine()) != null) {
            //Utilizar metodo split para separar caracteres con regular expresion y devuelve un vector separado
            String[] strings = cadena.split("##");
            int num_club = Integer.parseInt(strings[0]);
            String name_club = strings[1];
            String presidente = strings[2];
            String telefono = strings[3];
            String localidad = strings[4];
            //Utilizar metodo writeTeamData
            writeTeamData(raf, num_club, name_club, presidente, telefono, localidad);
        }

    }

    //Metodo writeTeamData para escribir los datos obtenidos al fichero binario con RandomAccessFile
    public static void writeTeamData(RandomAccessFile raf,
                                     int num_club,
                                     String name_club,
                                     String presidente,
                                     String telefono,
                                     String localidad) throws IOException {
        raf.writeInt(num_club);
        writeString(raf, name_club, DATA.NAMECLUB_LENG);
        writeString(raf, presidente, DATA.PRESIDENTE_LENG);
        writeString(raf, telefono, DATA.TELEFONO_LENG);
        writeString(raf, localidad, DATA.LOCALIDAD_LENG);
    }

    //Metodo para configurar longitud de caracteres String y luego escribirlo al fichero
    public static void writeString(RandomAccessFile raf, String s, int leng) throws IOException {
        StringBuilder sb = new StringBuilder(s);
        sb.setLength(leng);
        raf.writeChars(sb.toString());
    }
}