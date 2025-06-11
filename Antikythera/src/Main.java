import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    //slime

    public static void SQLMode() {
        // connection string
        var url = "jdbc:sqlite:Antikythera/Data/antikythera.db";
        Scanner scanner = new Scanner(System.in);

        //create table for Lunar eclipse
        var lunarEclipse = "CREATE TABLE IF NOT EXISTS LUNARECLIPSE ("
                + " DATE txt PRIMARY KEY,"
                + " TD txt NOT NULL,"
                + " TYPE txt NOT NULL,"
                + " SAROS INTEGER NOT NULL,"
                + " MAGNITUDE REAL NOT NULL,"
                + " CENTRALDURATION INTEGER NOT NULL,"
                + " VISIBILITY txt NOT NULL"
                + ");";

        var solarEclipse = "CREATE TABLE IF NOT EXISTS SOLARECLIPSE ("
                + " DATE txt PRIMARY KEY,"
                + " TD txt NOT NULL,"
                + " TYPE txt NOT NULL,"
                + " SAROS INTEGER NOT NULL,"
                + " MAGNITUDE REAL NOT NULL,"
                + " CENTRALDURATION INTEGER NOT NULL,"
                + " VISIBILITY txt NOT NULL"
                + ");";

        // TO-DO: User Interface

        try (var conn = DriverManager.getConnection(url)) {
            Statement statement = conn.createStatement();

            statement.execute(lunarEclipse);
            statement.execute(solarEclipse);

            //Insert SQL working here

            String lunEcl = "INSERT INTO LUNARECLIPSE VALUES ('2025 March 14', '6:59:56 AM', 'Total', 123, 1.178, 65, 'Pacific, Americas, W Europe, W Africa')";
            statement.executeUpdate(lunEcl);
            String solEcl = "INSERT INTO SOLARECLIPSE VALUES ('2025 March 29', '10:48:36 AM', 'Partial', 149, 0.938, 0, 'NW Africa, Europe, N Russia')";
            statement.executeUpdate(solEcl);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SQLMode();
    }
}