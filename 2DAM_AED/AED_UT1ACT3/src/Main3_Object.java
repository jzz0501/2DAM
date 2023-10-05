import java.io.*;

public class Main3_Object {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Crear una flujo de acceso aleatorio para hacer lectura (Aunque aqui tambien se puede hacer con DataInputStream)
        RandomAccessFile raf = new RandomAccessFile("FILE\\datosEquipos.dat","r");
        //Crear una flujo de serializacion para escribir los objetos a un fichero
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FILE\\datosEquipos.obj"));

        //Un bucle para leer todos los grupos de datos y serializarlo como los objetos de Equipos
        try {
            while (true) {
                int num_club = raf.readInt();
                String name_club = Main2_Update.readString(raf, DATA.NAMECLUB_LENG);
                String presidente = Main2_Update.readString(raf, DATA.PRESIDENTE_LENG);
                String telefono = Main2_Update.readString(raf, DATA.TELEFONO_LENG);
                String localidad = Main2_Update.readString(raf, DATA.LOCALIDAD_LENG);
                oos.writeObject(new Equipos(num_club, name_club, presidente, telefono, localidad));
            }
        } catch (EOFException e) {

        } finally {
            oos.close();
            raf.close();
        }

        //Crear una flujo de deserializacion para leer los objetos de un fichero
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("FILE\\datosEquipos.obj"));
        //Crear una flujo salida de byte para hacer escritura
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("FILE\\Equipos.asc"));

        //Un bucle para deserializar todos los objetos y escribirlo a otro fichero
        try {
            while (true) {
                Equipos equipo = (Equipos) ois.readObject();
                int num_club = equipo.getNum_club();
                String name_club = equipo.getName_club();
                String presidente = equipo.getPresidente();
                String telefono = equipo.getTelefono();
                String localidad = equipo.getLocalidad();
                dos.writeInt(num_club);
                dos.writeUTF(name_club);
                dos.writeUTF(presidente);
                dos.writeUTF(telefono);
                dos.writeUTF(localidad);
                System.out.println(equipo);
            }
        } catch (EOFException e) {

        } finally {
            dos.close();
            ois.close();
        }


    }
}
