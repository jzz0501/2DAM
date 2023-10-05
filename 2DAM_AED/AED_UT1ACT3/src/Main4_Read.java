import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class Main4_Read {

    public static void main(String[] args) throws IOException {

        //Crear un flujo entrada de byte para leer fichero
        DataInputStream dis = new DataInputStream(new FileInputStream("FILE\\Equipos.asc"));

        int num_club;
        String name_club;
        String presidente;
        String telefono;
        String localidad;

        //Solo se muestra el numero de club entre 200-300
        try {
            while(true) {
                num_club = dis.readInt();
                name_club = dis.readUTF();
                presidente = dis.readUTF();
                telefono = dis.readUTF();
                localidad = dis.readUTF();
                if(num_club >= 200 && num_club <= 300) {
                    System.out.println("num_club: " + num_club +
                            " name_club: " + name_club +
                            " presidente: " + presidente +
                            " telefono: " + telefono +
                            " localidad: " + localidad);
                }
            }
        } catch (EOFException e) {

        } finally {
            dis.close();
        }

    }
}
