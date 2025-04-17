import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    public static Connection connect() {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:konto.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Alles hat fehlerlos geklappt");
        } catch (SQLException e) {
            System.out.println("Ein Fehler ist aufgetreten");
        }
        return conn;
    }
}
