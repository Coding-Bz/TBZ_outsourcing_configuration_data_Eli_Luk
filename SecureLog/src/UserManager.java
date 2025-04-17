import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserManager {

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS konto ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "username TEXT NOT NULL, "
                + "password TEXT NOT NULL);";
        try (Connection conn = DatabaseConnector.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabelle 'konto' wurde angelegt (oder existiert schon).");
        } catch (SQLException e) {
            System.out.println("Fehler beim Erstellen der Tabelle");
        }
    }

    public static void insertUser(String username, String password) {
        String sql = "INSERT INTO konto(username, password) VALUES(?, ?)";
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("✅ Benutzer wurde gespeichert!");
        } catch (SQLException e) {
            System.out.println("Fehler beim Speichern des Benutzers");
        }
    }

    public static void showAllUsers() {
        String sql = "SELECT id, username, password FROM konto";
        try (Connection conn = DatabaseConnector.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nBenutzerliste:");
            while (rs.next()) {
                System.out.printf("ID: %d | Username: %s ",
                        rs.getInt("id"),
                        rs.getString("username"));
            }
        } catch (SQLException e) {
            System.out.println("Fehler beim Auslesen der Benutzer");
        }
    }
}
