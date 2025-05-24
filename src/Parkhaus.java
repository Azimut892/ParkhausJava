import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Parkhaus {
    public static HashMap<String, String> geparkteAutos = new HashMap<>();
    public static HashMap<Integer, List<Integer>> etageUndParkplatz = new HashMap<>();
    static List<Integer> etagenListe = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void parkhaus() {
        System.out.println("Parken [P] Ausparken [A] Einstellungen [E] Beenden [Q]");
        String input = scanner.next().toLowerCase();
        switch (input) {
            case "p":
                Parken.parken();
                break;

            case "a":
                AusParken.ausParken();
                break;


            case "e":
                Einstellungen.setEinstellungen();
                break;


            case "q":
                System.exit(0);
                break;

            default:
                Parkhaus.parkhaus();
                System.out.println("Ungültige Eingabe. Bitte erneut versuchen.");
        }
    }
}
