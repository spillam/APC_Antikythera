import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    //slime

    public static void SQLMode() {
        // connection string
        var url = "jdbc:sqlite:Antikythera/Data/assignment3.db";
        Scanner scanner = new Scanner(System.in);

        // TO-DO: User Interface

        try (var conn = DriverManager.getConnection(url)) {
            Statement statement = conn.createStatement();

            //Insert SQL working here

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SQLMode();
    }
}