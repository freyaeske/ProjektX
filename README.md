# JavaTasker 📝

Ein einfaches Konsolen-basiertes ToDo-Verwaltungstool in Java. Entwickelt zur Demonstration von Git-Branching-Strategien.

---

##  Projektziel

Mit JavaTasker kann man:

- Aufgaben über die Konsole hinzufügen
- Alle offenen Aufgaben anzeigen
- Aufgaben löschen (in Entwicklung)

---

##  Projektstruktur
GitFlow

| Branch                | Zweck                             |
|----------------------|------------------------------------|
| `main`               | Produktiv, stabil                  |
| `dev`                | Aktuelle Entwicklung               |
| `feature/add-task`   | Aufgaben hinzufügen                |
| `feature/remove-task`| Aufgaben löschen (WIP)             |
| `hotfix/empty-task-bug` | Fehlerbehebung bei leerer Eingabe |

Entwicklungsschritte (Trunks & Features)

- [x] Projektstruktur anlegen (`main`)
- [x] Grundlogik schreiben (`feature/add-task`)
- [ ] Löschfunktion einbauen (`feature/remove-task`)
- [ ] Datenspeicherung implementieren (`feature/storage`)
- [ ] Release 1.0 vorbereiten (`release/1.0`)

Beispiel: Hinzufügen eines Tasks

```bash
java JavaTasker
> Neue Aufgabe: "Git verstehen"
> Aufgabe gespeichert.
Mitwirkende

Max Mustermann
Lisa Codewitz

Nutzung

javac src/JavaTasker.java
java -cp src JavaTasker
