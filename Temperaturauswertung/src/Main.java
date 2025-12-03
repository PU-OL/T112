import java.util.*;

public class Main {
    static int[] tempmesswerte;
    public static void main(String[] args) {
        speichernderTemp();
        ausgabetable();
    }

    private static void speichernderTemp() {
        System.out.print("Wollen Sie die manuelle Eingabe nutzen [Y/N]: ");
        Scanner scanner = new Scanner(System.in);
        char value;
        value = scanner.next().charAt(0);
        System.out.println();
        if(value == 'y' || value == 'Y') {
            tempmesswerte = new int[14];
            for(int i = 0; i < tempmesswerte.length; i++) {
                System.out.print("Bitte Temperatur von " + (i+1) + ". Tag in der Vergangenheit: ");
                tempmesswerte[i] = scanner.nextInt();
                System.out.println();
            }
        }else{
            tempmesswerte = new int[]{12, 14, 10, 7, 11, 13, 12, 15, 15, 18, 16, 13, 10, 12};
        }
    }

    private static void ausgabetable() {
        System.out.println("Die Temperaturen der letzten " + (tempmesswerte.length) + " Tage in der Übersicht:");
        for(int i = 0; i < tempmesswerte.length; i++) {
            System.out.print("|--------|");
        }
        System.out.println();
        for(int i = 0; i < tempmesswerte.length; i++) {
            if(i < 9) {
                System.out.print("|   0" + (i + 1) + "   |");
            }else{
                System.out.print("|   " + (i + 1) + "   |");
            }
        }
        System.out.println();
        for(int i = 0; i < tempmesswerte.length; i++) {
            System.out.print("|--------|");
        }
        System.out.println();
        for (int i = 0; i < tempmesswerte.length; i++) {
            if(tempmesswerte[i] < 9) {
                System.out.print("|   0" + (tempmesswerte[i] + 1) + "   |");
            }else{
                System.out.print("|   " + (tempmesswerte[i] + 1) + "   |");
            }
        }
        System.out.println();
        for(int i = 0; i < tempmesswerte.length; i++) {
            System.out.print("|--------|");
        }
        System.out.println();
    }
}