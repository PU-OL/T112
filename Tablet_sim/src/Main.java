import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double displayDiagonale = 11;
        int akkuLadung = 20;
        boolean isOn = true;

        akkuLadung = akkuAufladen(akkuLadung, 30);
        akkuLadung = akkuAufladen(akkuLadung, 100);
        akkuLadung = akkuAufladen(akkuLadung, 111);
        akkuLadung = akkuAufladen(akkuLadung, 40);

        isOn = switchOn(isOn);
        isOn = switchOff(isOn);
    }

    private static int akkuAufladen(int akku, int target) {
        if (akku >= target) {
            System.out.println("\033[31m Der Akkustand (" + akku + "%) ist größer als die Ziel Ladung mit " + target + "%");
            brL(25);
            return akku;
        }else{
            if (target <= 100) {
                System.out.println("\033[32m Laden bis " + target + "% gestartet.");
                for (int i = akku + 1; i <= target; i++) {
                    int filled = (i * 30) / 100;
                    //String bar = "[🚂" + "🚋".repeat(filled) +  " ".repeat(10-filled) + "]";
                    String bar = "[" + "=".repeat(filled) + "🛬" + " ".repeat(30 - filled) + "]";

                    System.out.print("\r\033[2K");
                    System.out.print(" \033[5;36m Akkustand: " + i + "%" + " ||" + bar);

                    akku = i;
                    if (i < 75) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                        }
                    } else {
                        try {
                            Thread.sleep(2500);
                        } catch (InterruptedException e) {
                        }
                    }
                }
                System.out.println();
                System.out.println("\033[32m Laden beendet mit: " + akku + "%");
                brL(25);
                return akku;
            } else {
                System.out.println("\033[31m Der Aktuelle Zielwert " + target + "% überschreitet das Maximum von 100%");
                brL(25);
                return akku;
            }
        }
    }

    private static boolean switchOn(boolean status){
        if(status){
            System.out.println("\033[31m Das Gerät ist bereits angeschaltet");
        }else {
            System.out.println("\033[32m Das Gerät ist angeschaltet worden");
        }
        brL(25);
        return status;
    }

    private static boolean switchOff(boolean status){
        if(!status){
            System.out.println("\033[31m Das Gerät ist bereits abgeschaltet");
            brL(25);
        }else {
            System.out.println("\033[32m Das Gerät ist abgeschaltet worden");
        }
        return status;
    }

    private static void brL(int lenght){
        System.out.print("\033[0m");
        if(lenght > 0) {
            for (int i = 0; i < lenght; i++) {
                System.out.print("-");
            }
        }
        System.out.println();
    }
}