import java.util.ArrayList;
import java.util.List;

public class Einstellungen {
    private static boolean einstellungen = true;
    public static void setEinstellungen() {
        System.out.println("Etagen Bearbeiten [E] Parkplätze Bearbeiten [P] Fahrzeug suchen [W] Freie Parkplätze [F] Freie Parkplätze pro Etage [H] Zurück [Z]");
        String einstellung = Parkhaus.scanner.next().toLowerCase();
            while (einstellungen) {
                switch (einstellung) {
                    case "e":
                        etagenMod();
                        break;

                    case "p":
                        parkPlatzMod();
                        break;

                    case "h":
                        anzeigeEtageUndParkplatz();
                        break;

                    case "w":
                        autoWo();
                        break;

                    case "f":
                        setFreieParkplaetze();
                        break;

                    case "z":
                        Parkhaus.parkhaus();
                        break;
                }


            }
        }

        public static void etagenMod() {
                System.out.println("Wie viele Etagen sollen hinzugefügt werden?");
                int etagenMenge = Parkhaus.scanner.nextInt();
                Parkhaus.etagenListe.clear();
                for (int i = 0; i < etagenMenge; i++) {
                    Parkhaus.etagenListe.add(i);
                    List<Integer> parkplatzListe = new ArrayList<>();
                    Parkhaus.etageUndParkplatz.put(i, parkplatzListe);
                }
                System.out.println(Parkhaus.etagenListe);
                setEinstellungen();
            }

            public static void parkPlatzMod() {
                System.out.println("Welche Etage soll verändert werden?");
                int etageNummer = Parkhaus.scanner.nextInt();
                if (Parkhaus.etagenListe.contains(etageNummer)) {
                    System.out.println("Wie viele Parkplätze sollen hinzugefügt werden?");
                    int parkplatzMenge = Parkhaus.scanner.nextInt();
                    List<Integer> parkplatzListe = Parkhaus.etageUndParkplatz.get(etageNummer);
                    parkplatzListe.clear();
                    if (parkplatzListe == null) {
                        parkplatzListe = new ArrayList<>();
                    }
                    for (int i = 0; i < parkplatzMenge; i++) {
                        parkplatzListe.add(i);
                    }
                    Parkhaus.etageUndParkplatz.put(etageNummer, parkplatzListe);

                    System.out.println("Etage " + etageNummer + " hat jetzt " + parkplatzListe.size() + " Parkplätze.");
                } else {
                    System.out.println("Diese Etage existiert nicht.");
                }

                setEinstellungen();
            }

            public static void anzeigeEtageUndParkplatz() {
                System.out.println("Etagen und zugehörige Parkplätze");
                for (Integer etage : Parkhaus.etagenListe) {
                    List<Integer> parkplatz = Parkhaus.etageUndParkplatz.get(etage);
                    System.out.println("Etage " + etage + ": " + parkplatz.size() + " Parkplätze");
                }
                setEinstellungen();
            }

            public static void setFreieParkplaetze() {
                int freieParkplaetze = 0;
                for (List<Integer> parkplatzListe : Parkhaus.etageUndParkplatz.values()) {
                    freieParkplaetze += parkplatzListe.size();
                }
                System.out.println("Es gibt " + freieParkplaetze + " freie Parkplätze.");
                setEinstellungen();
            }
        public static void autoWo() {
            System.out.println("Kennzeichen angeben");
            String kundeKennzeichen = Parkhaus.scanner.next();
            if (Parkhaus.geparkteAutos.containsKey(kundeKennzeichen)) {
                System.out.println(Parkhaus.geparkteAutos.get(kundeKennzeichen));
            }else {
                System.out.println("dieses fahrzeug ist nicht hier geparkt");
            }
            setEinstellungen();

        }
    }



