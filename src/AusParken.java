import java.util.List;

public class AusParken {
    public static void ausParken() {
        System.out.println("Kennzeichen angeben:");
        String kundenKennzeichen = Parkhaus.scanner.next();

        if (Parkhaus.geparkteAutos.containsKey(kundenKennzeichen)) {
            String parkingInfo = Parkhaus.geparkteAutos.get(kundenKennzeichen);
            String[] parts = parkingInfo.split(", Parkplatz ");
            if (parts.length == 2) {
                int etageToRemove = Integer.parseInt(parts[0].replaceAll("[^0-9]", ""));
                int removedParkplatz = Integer.parseInt(parts[1]);

                if (Parkhaus.etageUndParkplatz.containsKey(etageToRemove)) {
                    List<Integer> parkplatzListe = Parkhaus.etageUndParkplatz.get(etageToRemove);

                    if (parkplatzListe != null) {
                        parkplatzListe.add(removedParkplatz);
                        Parkhaus.geparkteAutos.remove(kundenKennzeichen);

                        System.out.println("Das Fahrzeug mit Kennzeichen " + kundenKennzeichen + " kann jetzt das Parkhaus verlassen.");
                    }
                }
            }
        } else {
            System.out.println("Das angegebene Kennzeichen ist nicht in der Parkliste.");
        }
        Parkhaus.parkhaus();
    }
}
