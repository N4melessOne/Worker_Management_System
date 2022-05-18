

import java.sql.*;


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

    public static ResultSet execute(String statement) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(statement);
        ResultSet result = preparedStatement.executeQuery();
        return result;
    }
}