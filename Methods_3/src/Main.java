import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hat Ziel überschritten: " + hatZielUeberschritten(25.5,10.189));
        System.out.println("Durchschnittsgeschwindigkeit bei 100km in 2 Stunden: " + calculateMiddleSpeed(100, 2));
        int temp = 36;
        System.out.println("Temperatur von " + temp + " °C ist angenehm? " + isTemperatureOk(temp));
        int anzahl = 100;
        double preis = 42.42;
        System.out.println(anzahl + " Tickets kosten insgesamt " + preisGesamt(anzahl, preis) + "€ bei einem Stückpreis von " + preis + "€. Bei mehr als 10 Karten gibt es 10% Rabatt");
        System.out.println("Person darf teilnehmen: " + darfTeilnehmen(true, false, true));
        System.out.println("Alter: " + berechneAlter(1756));
    }

    private static boolean hatZielUeberschritten(double startValue, double targtValue){
        return startValue > targtValue;
    }

    private static double calculateMiddleSpeed(double distance, double time){
        if(distance == 0 || time == 0) return 0;
        return distance/time;
    }

    private static boolean isTemperatureOk(int temperature){
        return temperature < 26 && temperature > 17;
    }

    private static double preisGesamt(int anzahl, double ppT){
         double price =  anzahl * ppT;
         if(anzahl >= 10){
             price = price - (price/10);
             return price;
         }
         return price;
    }

    private static boolean darfTeilnehmen (boolean angemeldet, boolean bezahlt, boolean volljaerig){
        if(!angemeldet || !bezahlt || !volljaerig)return false;
        return true;
    }

    private static int berechneAlter(int geburtsjahr){
        int aktuellesJahr = 2025; //; fehlte
        int alter = aktuellesJahr - geburtsjahr;
        //System.out.println("Alter: " + alter); // unnötig
        return alter;// fehlte
    }
}