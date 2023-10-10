import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {


        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","19871124");
        PreparedStatement statement = connection.prepareStatement("insert into dep values (?,?,?)");
        statement.setInt(1,2);
        statement.setString(2,"name2");
        statement.setString(3,"localidad2");
        statement.execute();

        Statement statement2 = connection.createStatement();
        ResultSet rs = statement2.executeQuery("select*from dep");

        while(rs.next()) {
            System.out.println(rs.getString("id_dep"));
            System.out.println(rs.getString("name_dep"));
            System.out.println(rs.getString("localidad"));
        }


    }
}