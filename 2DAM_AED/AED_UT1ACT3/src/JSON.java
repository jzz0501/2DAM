import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class JSON {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Crear un flujo de deserializacion y obtener todos sus objetos
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("FILE\\datosEquipos.obj"));
        //Crear un flujo salida de caracter para escribir a un fichero json
        FileWriter fw = new FileWriter("FILE\\json.json");

        //Crear un ArrayList para guardar los objetos deserializados
        ArrayList<Equipos> equipos = new ArrayList<>();
        Gson gson = new Gson();

        try {
            while(true) {
                Object obj = ois.readObject();
                Equipos equipo = (Equipos) obj;
                equipos.add(equipo);
            }
        } catch (EOFException e) {

        } finally {
            ois.close();
        }

        //Despues de añadir todos los objetos a la lista, serializarlo con formato json
        gson.toJson(equipos,fw);
        fw.close();

        //Crear un flujo entrada de caracter para deserializar el datos de formato json al objeto ArrayList
        FileReader br = new FileReader("FILE\\json.json");
        String s = gson.fromJson(br, ArrayList.class).toString();

        /*
            Utilizar regex para mostrar los datos linea por linea
            '}, \\{' significa '}, {'
            '\\[\\{|}]' significa '[{' or '}]'

            \ es un simbolo para cambiar significado como \n = newLine \r = enter
            '[' y '{' tienen significado especial en regular expresion [ = rango de caracter { = cantidad
            pues necesita otro \ para volver a cambiar su significado como normal
        */

        System.out.println(s.replaceAll("}, \\{","\n").
                                replaceAll("\\[\\{|}]","")
        );

        br.close();

    }
}
