import java.util.ArrayList;
import java.util.Scanner;

public class JavaTasker {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("📝 Willkommen bei JavaTasker!");
        while (true) {
            System.out.println("\nWas möchtest du tun?");
            System.out.println("1. Aufgabe hinzufügen");
            System.out.println("2. Aufgaben anzeigen");
            System.out.println("3. Beenden");
            System.out.print("> ");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Neue Aufgabe: ");
                    String task = scanner.nextLine();
                    if (!task.trim().isEmpty()) {
                        tasks.add(task);
                        System.out.println("✅ Aufgabe hinzugefügt.");
                    } else {
                        System.out.println("⚠️ Aufgabe darf nicht leer sein.");
                    }
                    break;
                case "2":
                    if (tasks.isEmpty()) {
                        System.out.println("📭 Keine Aufgaben vorhanden.");
                    } else {
                        System.out.println("🗒️ Deine Aufgaben:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;
                case "3":
                    System.out.println("👋 Auf Wiedersehen!");
                    return;
                default:
                    System.out.println("❌ Ungültige Eingabe.");
            }
        }
    }
}
