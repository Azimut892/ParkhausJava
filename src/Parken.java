import java.util.List;

public class Parken {
    public static void parken() {
        System.out.println("Was möchten Sie parken? Auto [A] Motorrad [M]");
        String fahrzeug = Parkhaus.scanner.next().toLowerCase();

        switch (fahrzeug) {
            case "a":
                parkAuto();
                break;
            case "m":
                parkMotorrad();
                break;
            default:
                System.out.println("Ungültige Eingabe. Bitte erneut versuchen.");
                Parkhaus.parkhaus();

        }
    }

    private static int findAvailableEtage() {
        for (Integer etage : Parkhaus.etagenListe) {
            if (etage > 0) {
                List<Integer> parkplatzListe = Parkhaus.etageUndParkplatz.get(etage);
                if (parkplatzListe != null && !parkplatzListe.isEmpty()) {
                    return etage;
                }
            }
        }
        return -1;
    }

    public static void parkAuto() {
        int etageNummer = findAvailableEtage();
        if (etageNummer < 0) {
            System.out.println("Es sind keine freien Parkplätze auf den oberen Etagen verfügbar.");
            Parkhaus.parkhaus();
            return;
        }

        List<Integer> parkplatzListe = Parkhaus.etageUndParkplatz.get(etageNummer);
        if (parkplatzListe == null || parkplatzListe.isEmpty()) {
            System.out.println("Es sind keine freien Parkplätze auf Etage " + etageNummer + " verfügbar.");
            Parkhaus.parkhaus();
            return;
        }

        System.out.println("Geben Sie Ihr Kennzeichen an oder [A] um abzubrechen");
        String kennzeichen = Parkhaus.scanner.next();
        if (kennzeichen.equalsIgnoreCase("a")) {
            Parkhaus.parkhaus();
            return;
        }

        if (Parkhaus.geparkteAutos.containsKey(kennzeichen)) {
            System.out.println("Ein Fahrzeug mit Kennzeichen [ " + kennzeichen + " ] ist bereits geparkt.");
            parkAuto();
            return;
        }

        int parkplatz = parkplatzListe.get(0);
        parkplatzListe.remove(0);
        System.out.println("Ihr Auto ist auf Etage " + etageNummer + ", Parkplatz " + (parkplatz + 1) + " geparkt.");
        Parkhaus.geparkteAutos.put(kennzeichen, "Etage " + etageNummer + ", Parkplatz " + (parkplatz + 1));

        Parkhaus.parkhaus();
    }


    public static void parkMotorrad() {
        List<Integer> parkplatzListe = Parkhaus.etageUndParkplatz.get(0);
        if (parkplatzListe != null && !parkplatzListe.isEmpty()) {
            System.out.println("Geben Sie Ihr Kennzeichen an oder [A] um abzubrechen");
            String kennzeichen = Parkhaus.scanner.next();
            if (kennzeichen.equalsIgnoreCase("a")) {
                Parkhaus.parkhaus();
            }

            if (Parkhaus.geparkteAutos.containsKey(kennzeichen)) {
                System.out.println("Ein Fahrzeug mit Kennzeichen [ " + kennzeichen + " ] ist bereits geparkt.");
                parkMotorrad();
                return;
            }

            int parkplatz = parkplatzListe.get(0);
            parkplatzListe.remove(0);
            System.out.println("Ihr Motorrad ist auf Etage 0, Parkplatz " + (parkplatz + 1) + " geparkt.");
            Parkhaus.geparkteAutos.put(kennzeichen, "Etage 0, Parkplatz " + (parkplatz + 1));
        } else {
            System.out.println("Es sind keine freien Parkplätze auf der Motorrad Etage verfügbar.");
        }
        Parkhaus.parkhaus();

    }
}