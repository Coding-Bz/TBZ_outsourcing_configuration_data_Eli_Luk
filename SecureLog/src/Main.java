import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        UserManager.createTable();

        Scanner scanner = new Scanner(System.in);
        int auswahl;

        do {
            System.out.println("\n===== Benutzerverwaltung =====");
            System.out.println("1) Neuen Benutzer erstellen");
            System.out.println("2) Alle Benutzer anzeigen");
            System.out.println("3) Beenden");
            System.out.print("➡️ Auswahl: ");
            auswahl = scanner.nextInt();
            scanner.nextLine();

            switch (auswahl) {
                case 1:
                    System.out.print("Benutzername: ");
                    String username = scanner.nextLine();
                    System.out.print("Passwort: ");
                    String password = scanner.nextLine();
                    UserManager.insertUser(username, password);
                    break;

                case 2:
                    UserManager.showAllUsers();
                    break;

                case 3:
                    System.out.println("Erfolgreich beendet");
                    break;

                default:
                    System.out.println("Nicht möglich");
            }

        } while (auswahl != 3);

        scanner.close();
    }
}
