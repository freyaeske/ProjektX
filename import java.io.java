import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Benutzerverwaltung {

    private Collection<Benutzer> benutzer = new ArrayList<Benutzer>(); 
    
    public void importBenutzer() {
        ArrayList<String> filenames = new ArrayList<>();
        filenames.add("benutzer.txt");     
    }
    
    public void readBenutzerFromTextfile() {
        readBenutzerFromTextFile("benutzer.txt");
    }

    public void readBenutzerFromTextFile(String filename) {
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                
                if (line.isEmpty() || line.startsWith("Benutzer")) {
                    continue;
                }
                
                String benutzernameTxt = line;
                if (!scanner.hasNextLine()) break;
                String passwortTxt = scanner.nextLine().trim();
                
                if (!scanner.hasNextLine()) break;
                String highscoreLine = scanner.nextLine().trim();
                
                int highscoreTxt = 0;
                try {
                    highscoreTxt = Integer.parseInt(highscoreLine);
                } catch (NumberFormatException e) {
                    System.out.println("Fehler beim Parsen des Highscores für Benutzer: " + benutzernameTxt);
                    continue;
                }
                
                Benutzer benutzer = new Benutzer(benutzernameTxt, passwortTxt, highscoreTxt);
                this.benutzer.add(benutzer);
                System.out.println("Benutzer: " + benutzernameTxt + " hinzugefügt.");
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Einlesen der Datei.");
            e.printStackTrace();
        }
    }

    public void loadBenutzer(){       
        this.benutzer.add(new Benutzer("jane", "1234", 5));
        this.benutzer.add(new Benutzer("tom", "1111", 4));
        this.benutzer.add(new Benutzer("justus", "2222", 9));
        this.benutzer.add(new Benutzer("anna", "3333", 5));
        this.benutzer.add(new Benutzer("laura", "4444", 6));
    }
    
    public void writeBenutzerIntoTextFile() {
        try (PrintWriter writer = new PrintWriter("benutzer.txt")) {
            for (Benutzer b : this.benutzer) {
                writer.println("Benutzer1:");
                writer.println(b.getBenutzernameTxt());
                writer.println(b.getPasswortTxt());
                writer.println(b.getHighscoreTxt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fehler beim Öffnen der Datei zum Speichern.");
            e.printStackTrace();
        }
    }

    // 🚫 Fehlerhafte Login-Methode (kein Null-Check!)
    public boolean login(String benutzername, String passwort) {
        for (Benutzer b : this.benutzer) {
            if (b.getBenutzernameTxt().equals(benutzername) &&
                b.getPasswortTxt().equals(passwort)) {
                return true;
            }
        }
        return false;
    }

    public void updateHighscoreFürBenutzer(String benutzername, int neuerHighscore) {
        for (Benutzer b : this.benutzer) {
            if (b.getBenutzernameTxt().equalsIgnoreCase(benutzername)) {
                if (neuerHighscore > b.getHighscoreTxt()) {
                    b.setHighscoreTxt(neuerHighscore);
                    System.out.println("Neuer Highscore gespeichert für " + benutzername + ": " + neuerHighscore);
                } else {
                    System.out.println("Kein neuer Highscore. Dein bestehender ist höher oder gleich.");
                }
                break;
            }
        }
    }
}
 {
    
}
