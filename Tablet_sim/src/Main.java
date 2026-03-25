import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double displayDiagonale = 11;
        int akkuLadung = 20;
        boolean isOn = false;

        akkuLadung = akkuAufladen(akkuLadung, 100);
        akkuLadung = akkuAufladen(akkuLadung, 80);

        isOn = switchOn(isOn);
        isOn = switchOff(isOn);
    }

    private static int akkuAufladen(int akku, int target){
        if(target <= 100){
            System.out.println("Laden bis " + target + "% gestartet.");
            for (int i = akku+1; i <= target; i++) {
                int filled = (i * 30)/100;
                //String bar = "[🚂" + "🚋".repeat(filled) +  " ".repeat(10-filled) + "]";
                String bar = "[" + "-".repeat(filled) + "🛬" + " ".repeat(30-filled) + "]";

                System.out.print("\r\033[2K");
                System.out.print("Akkustand: " + i + "%" + " ||" + bar);

                akku = i;
                if(i < 50) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {}
                }else{
                    try{
                        Thread.sleep(2500);
                    }catch (InterruptedException e){}
                }
            }
            System.out.println();
            System.out.println("Laden beendet mit: " + akku + "%");
            return akku;
        }else{
            System.err.println("Der Aktuelle Zielwert " + target + "% überschreitet das Maximum von 100%");
            return akku;
        }
    }

    private static boolean switchOn(boolean status){
        if(status){
            System.err.println("Gerät ist bereits angeschaltet");
            return status;
        }else {
            System.out.println("Gerät angeschaltet worden");
            return status;
        }
    }

    private static boolean switchOff(boolean status){
        if(status){
            System.err.println("Gerät ist bereits abgeschaltet");
            return status;
        }else {
            System.out.println("Gerät abgeschaltet worden");
            return status;
        }
    }
}