import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int zähler = 21;
        int nenner = 41;
        int zähler2 = 41;
        int nenner2 = 21;

        kuerzen(zähler, nenner);
        kuerzen(zähler2, nenner2);

        int section = 0;

        do{
            System.out.print("==========\nHerzlich Willkommen zu unserem Java Bruchrechner!\nWählen Sie:\n1: Brüche addieren\n2: Brüche subtrahieren\n3: Brüche multiplizieren\n4: Brüche dividieren\n5: Bruch kürzen\n6: Bruch erweitern\n7: Größten gemeinsamen Teiler ermitteln\n0: Abbruch\n==========\nIhre Wahl:");
            section = scanner.nextInt();
            if(section != 0) {
                System.out.print("Geben Sie den Zähler des ersten Bruches ein: ");
                zähler = scanner.nextInt();
                System.out.print("Geben Sie den Nenner des ersten bruches ein: ");
                nenner = scanner.nextInt();
                System.out.print("Geben Sie den Zähler des zweiten Bruches ein: ");
                zähler2 = scanner.nextInt();
                System.out.print("Geben Sie den Nenner des zweiten Bruches ein: ");
                nenner2 = scanner.nextInt();
            }

            switch(section){
                case 1:
                    addieren(zähler, nenner, zähler2, nenner2);
                    break;
                case 2:
                    subtraktion(zähler, nenner, zähler2, nenner2);
                    break;
                case 3:
                    multiplikation(zähler, nenner, zähler2, nenner2);
                    break;
                case 4:
                    divison(zähler, nenner, zähler2, nenner2);
                    break;
                case 5:
                    kuerzen(zähler, nenner);
                    kuerzen(zähler2, nenner2);
                    break;
                case 6:
                    int[] a = erweitern(zähler, nenner, zähler2, nenner2);
                    System.out.println("Die Erweiterung der Brüche " + zähler + "/" + nenner + " und " + zähler2 + "/" + nenner2 + "ergibt: " + a[1] + "/" + a[0] + " und " + a[2] + "/" + a[0]);
                    break;
                case 7:
                     int teiler = ggT2(zähler, nenner);
                    System.out.println("Das Kürzen des Bruches " + zähler + "/" + nenner + " ergibt: " + (zähler/teiler) + "/" + (nenner/teiler));
                case 0:
                    System.out.println("System beenden ...");
                    break;
                default:
                    System.err.println("Es ist ein Fehler aufgetreten");
            }
            try{
                Thread.sleep(2500);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }while(section != 0);
    }

    private static int ggT1 (int zähler, int nenner){
        while(nenner != zähler && nenner != 0){
            if(zähler > nenner){
                zähler = zähler - nenner;
            }else{
                nenner = nenner - zähler;
            }
        }
        return zähler;
    }

    private static int ggT2 (int zähler, int nenner){
        int rest = 0;
        while(nenner != 0){
            rest = zähler % nenner;
            zähler = nenner;
            nenner = rest;
        }
        return zähler;
    }

    private static void kuerzen (int zähler, int nenner){
        int zähler_2 = zähler;
        int nenner_2 = nenner;
        int teiler = ggT2(zähler, nenner);
        if(teiler != 0 || teiler != 1){
             zähler_2 = zähler/teiler;
             nenner_2 = nenner/teiler;
        }
        System.out.println("Der Bruch " + zähler + "/" + nenner + " wurde zu " + zähler_2 + "/" + nenner_2 + " gekürtzt.");
    }

    private static int[] erweitern (int zähler_I, int zähler_II, int nenner_I, int nenner_II){
        int[] values = new  int[3];

        if(nenner_I != nenner_II){
            values[0] = nenner_I * nenner_II;
            values[1] = zähler_I * nenner_II;
            values[2] = zähler_II * nenner_I;
        }else{
            values[0] = nenner_I;
            values[1] = zähler_I;
            values[2] = zähler_II;
        }

        return values;
    }

    private static void addieren(int zähler_I, int nenner_I, int zähler_II, int nenner_II){
        int zähler_final = 0;
        int nenner_final = 0;
        int zähler_I_temp = 0;
        int nenner_I_temp = 0;
        int zähler_II_temp = 0;

        int[] erweiterteWerte = erweitern(zähler_I, zähler_II, nenner_I, nenner_II);

        nenner_I_temp = erweiterteWerte[0];
        zähler_I_temp = erweiterteWerte[1];
        zähler_II_temp = erweiterteWerte[2];
        //System.out.println("Debug: " + zähler_I_temp + "/" + nenner_I_temp + " und " + zähler_II_temp + "/" + nenner_II_temp);

        zähler_final = zähler_I_temp + zähler_II_temp;
        nenner_final = nenner_I_temp;

        int teiler = ggT2(zähler_final, nenner_final);
        if(teiler != 0 || teiler != 1) {
            zähler_final = zähler_final / teiler;
            nenner_final = nenner_final / teiler;
        }

        System.out.println("Die Addition der Brüche " + zähler_I + "/" + nenner_I + " und " + zähler_II + "/" + nenner_II + " ergibt: " + zähler_final + "/" + nenner_final);
    }

    private static void subtraktion (int zähler_I, int nenner_I, int zähler_II, int nenner_II){
        int zähler_final = 0;
        int nenner_final = 0;
        int zähler_I_temp = 0;
        int nenner_I_temp = 0;
        int zähler_II_temp = 0;

        int[] erweiterteWerte = erweitern(zähler_I, zähler_II, nenner_I, nenner_II);

        nenner_I_temp = erweiterteWerte[0];
        zähler_I_temp = erweiterteWerte[1];
        zähler_II_temp = erweiterteWerte[2];

        zähler_final = zähler_I_temp - zähler_II_temp;
        nenner_final = nenner_I_temp;

        int teiler = ggT2(zähler_final, nenner_final);
        if(teiler != 0 || teiler != 1) {
            zähler_final = zähler_final / teiler;
            nenner_final = nenner_final / teiler;
        }

        System.out.println("Die Subtraktion der Brüche " + zähler_I + "/" + nenner_I + " und " + zähler_II + "/" + nenner_II + " ergibt: " + zähler_final + "/" + nenner_final);
    }

    private static void multiplikation (int zähler_I, int nenner_I, int zähler_II, int nenner_II){
        int zähler_final = 0;
        int nenner_final = 0;

        zähler_final = zähler_I * zähler_II;
        nenner_final = nenner_I * nenner_II;

        int teiler = ggT2(zähler_final, nenner_final);
        if(teiler != 0 || teiler != 1) {
            zähler_final = zähler_final / teiler;
            nenner_final = nenner_final / teiler;
        }

        System.out.println("Die Multiplikation der Brüche " + zähler_I + "/" + nenner_I + " und " + zähler_II + "/" + nenner_II + " ergibt: " + zähler_final + "/" + nenner_final);
    }

    private static void divison (int zähler_I, int nenner_I, int zähler_II, int nenner_II){
        int zähler_final = 0;
        int nenner_final = 0;

        zähler_final = zähler_I / nenner_II;
        nenner_final = nenner_I / zähler_II;

        System.out.println("Die Division der Brüche " + zähler_I + "/" + nenner_I + " und " + zähler_II + "/" + nenner_II + " ergibt: " + zähler_final + "/" + nenner_final);
    }
}