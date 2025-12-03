import java.util.*;
import java.io.*;

public class Main {
    static double[] einkauf;
    public static void main(String[] args) {
        eingabe();
        berechnung();
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
}
