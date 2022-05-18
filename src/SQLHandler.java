import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLHandler {
    public static void connect(String jdbcUrl) throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "");
            System.out.println("Connected to database.");
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void execute(String statement){
        String sql = "SELECT * FROM";
    }
}