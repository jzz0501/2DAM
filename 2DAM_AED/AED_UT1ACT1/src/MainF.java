import java.io.*;

public class MainF {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        BufferedReader br = new BufferedReader(new FileReader("files\\file6.txt"));
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files\\file7.txt"));

        String cadena;
        while ((cadena = br.readLine()) != null) {
            String[] data = cadena.split(",");
            String name = data[0];
            String dni = data[1];
            int edad = Integer.parseInt(data[2]);
            double salario = Double.parseDouble(data[3]);
            oos.writeObject(new Personas(name,dni,edad,salario));
        }


        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files\\file7.txt"));
            Personas personas;
            while ((personas = (Personas) ois.readObject()) != null) {
                System.out.println(personas);
            }
        } catch (EOFException e) {

        }

    }

}

