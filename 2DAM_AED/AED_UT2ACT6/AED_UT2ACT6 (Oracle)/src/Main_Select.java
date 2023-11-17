import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Main_Select {

    public static void main(String[] args) throws IOException, SQLException {

        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.97:1521:XE","ZONGZHEN","19871124");

        BufferedReader br = new BufferedReader(new FileReader("./sql/select.sql"));

        char act = 'a';
        String querySentence;
        while((querySentence = br.readLine())!=null) {

            ResultSet resultSet = connection.createStatement().executeQuery(querySentence);
            ResultSetMetaData rsm = resultSet.getMetaData();
            ArrayList<String[]> al = new ArrayList<>();

            System.out.println("Ejercicio select " + act + ":");

            String[] columnName = new String[rsm.getColumnCount()];
            for (int i = 1; i <= rsm.getColumnCount(); i++) {
                columnName[i-1] = rsm.getColumnName(i).trim();
            }
            al.add(columnName);

            while(resultSet.next()) {
                String[] row = new String[rsm.getColumnCount()];
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    row[i-1] = resultSet.getString(rsm.getColumnName(i)).trim();
                }
                al.add(row);
            }

            for (String[] strings : al) {
                for (int j = 0; j < rsm.getColumnCount(); j++) {
                    System.out.print(strings[j] + "     ");
                }
                System.out.println();
            }
            System.out.println();
            act = (char) (act+1);
        }




        connection.createStatement().executeUpdate
                ("UPDATE productos pd SET pd.precio = (pd.precio * 0.95) WHERE pd.cod_prov IN (SELECT cod_prov FROM proveedores WHERE bonifica = 0)");


        /*
        CallableStatement call = connection.prepareCall("CALL update_bonifica(?,?)");
        call.setString(1,"3");
        call.setDouble(2,10);
        call.executeUpdate();


         */
    }
}
