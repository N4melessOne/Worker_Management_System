import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class WMS_Test {
    @Test
    public void addWorkerTest(){
        Boolean actual = false;


        try {
            PreparedStatement statement = SQLHandler.connection.prepareStatement("INSERT INTO workers (workerName, workerAddress, birthDate, departmentId, leader, mobile, email, salary, plantId) VALUES (?,?,?,?,?,?,?,?,?)");

            statement.setString(1, "Teszt Elek");
            statement.setString(2, "Teszt u. 1.");
            statement.setDate(3, Date.valueOf(LocalDate.now()));
            statement.setInt(4,1);
            statement.setInt(9,1);
            statement.setBoolean(5,false);
            statement.setString(6,"0610101010");
            statement.setString(7,"teszt@gmail.com");
            statement.setInt(8,1010101);

            actual = SQLHandler.executeInsert(statement);
        } catch (SQLException e) {
            actual = false;
        }
        Assertions.assertEquals(true,actual);
    }

    public void resultCountTest(){
        //TODO: tests can't invoke sql connection, should make it happen somehow!
        int actual = 0;
        try {
            ResultSet result = SQLHandler.executeSelect("SELECT * FROM enterprise");
            actual = SQLHandler.countResult(result);
        } catch (SQLException e) {
            actual = 0;
        }
        Assertions.assertEquals(1,actual);
    }
}