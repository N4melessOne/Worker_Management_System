

import java.sql.*;
import java.util.ArrayList;


public class SQLHandler {
    private static Connection connection;

    public static void connect(String jdbcUrl) throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, "root", "");
            System.out.println("Connected to database.");
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet executeSelect(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet result = statement.executeQuery();
        return result;
    }
}