import java.util.*;
import java.io.*;

public class Main {
    static double[] einkauf;
    public static void main(String[] args) {
        boolean fail = false;
        boolean correct = false;
        char forward;
        Scanner scanner = new Scanner(System.in);
        eingabe();
        berechnung();
        do {
            System.out.print("Wollen Sie einen Wert suchen?: [Y/N]");
            forward = scanner.next().charAt(0);
            System.out.println();
            if (forward == 'Y' || forward == 'y') {
                do {
                    fail = suche();
                } while (fail);
                correct = true;
            }else {
                if (forward != 'N' && forward != 'n') {
                    System.out.println("Bitte Wiederholen Sie ihre Eingabe. Diese war ungültig");

                }
                if (forward == 'n' || forward == 'N') {
                    correct = true;
                }
            }
        }while(correct == false);

    }

    private static void eingabe() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bei Gleitkommazahlen bitte z.B.: 1,5 schreiben!");
        System.out.println("----------");
        System.out.print("Bitte geben Sie die Anzahl an Waren ein: ");
        int anzahl = scanner.nextInt();
        einkauf = new double[anzahl];
        System.out.println("----------");
        for (int i = 0; i < anzahl; i++) {
            System.out.println();
            System.out.print("Bitte Wert der " + (i+1) + ". Ware eingeben: ");
            einkauf[i] = scanner.nextDouble();
        }
        System.out.println();
        System.out.println("----------");
    }

    private static void berechnung() {
        double sum = 0;
        for(int i = 0; i < einkauf.length; i++) {
            sum += einkauf[i];
        }
        sum = Math.round(sum * 100.0) / 100.0;
        System.out.println("Summe aller Waren: " + sum);
    }

    private static boolean suche() {
        double searchvalue;
        boolean searchfailed = false;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie einen zu suchenden Wert ein: ");
        searchvalue = scanner.nextDouble();

        for(int i = 0; i < einkauf.length; i++) {
            if(einkauf[i] == searchvalue) {
                System.out.println("Wert " + searchvalue + " gefunden bei Position: " + i);
                searchfailed = false;
            }else{
                searchfailed = true;
            }
        }
        return searchfailed;
    }
}
