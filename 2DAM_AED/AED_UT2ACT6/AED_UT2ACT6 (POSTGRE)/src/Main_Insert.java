import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main_Insert {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection
                ("jdbc:postgresql://192.168.1.15:5432/postgres","postgres","19871124");


        BufferedReader br = new BufferedReader(new FileReader("./sql/insert.sql"));
        StringBuilder sentences = new StringBuilder();
        String cadena;
        while((cadena=br.readLine())!=null) {
            sentences.append(cadena);
        }
        connection.createStatement().executeUpdate(sentences.toString());
    }
}