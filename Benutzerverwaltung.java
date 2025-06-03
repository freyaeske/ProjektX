import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Benutzerverwaltung {
    private static final String BENUTZER_DATEI = "/Users/freyaeske/IdeaProjects/HA1-Sperling/src/benutzer.txt";
    private List<Benutzer> benutzerListe;

    public Benutzerverwaltung() {
        benutzerListe = new ArrayList<>();
        ladeBenutzer();
    }
// Benutzer laden (Wie von Aufgabenstellung fordert)
    public void ladeBenutzer() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BENUTZER_DATEI))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] teile = line.split(";");
                if (teile.length == 3) {
                    benutzerListe.add(new Benutzer(
                            teile[0],
                            teile[1],
                            Integer.parseInt(teile[2])
                    ));
                }
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Benutzerdatei: " + e.getMessage());
        }
    }

    public void speichereBenutzer() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BENUTZER_DATEI))) {
            for (Benutzer benutzer : benutzerListe) {
                writer.write(benutzer.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Speichern der Benutzerdatei: " + e.getMessage());
        }
    }

    public Benutzer anmelden(String benutzername, String passwort) {
        for (Benutzer benutzer : benutzerListe) {
            if (benutzer.getBenutzername().equals(benutzername) &&
                    benutzer.getPasswort().equals(passwort)) {
                return benutzer;
            }
        }
        return null;
    }
}