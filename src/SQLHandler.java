import java.sql.*;

public class SQLHandler {
    public static Connection connection;
    private static  PreparedStatement statement;

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

    public  static Boolean executeDelete(String sql){
        try {
            statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            return false;
        }
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public static Boolean executeInsert(String sql){
        try {
            statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            return false;
        }
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public static Boolean executeInsert(PreparedStatement statement){
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            return false;
            //TODO:LOG!
        }
        return true;
    }

    public static int countResult(ResultSet result) throws SQLException {
        int numberOfRows = 0;
        while (result.next()){
            numberOfRows++;
        }
        return numberOfRows;
    }
}