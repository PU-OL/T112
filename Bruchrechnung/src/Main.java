import java.util.*;

public class Main {
    public static void main(String[] args) {
        int zähler = 21;
        int nenner = 41;
        int zähler2 = 41;
        int nenner2 = 21;

        kuerzen(zähler, nenner);
        kuerzen(zähler2, nenner2);
        addieren(zähler, nenner, zähler2, nenner2);
        subtraktion(zähler, nenner, zähler2, nenner2);
        multiplikation(zähler, nenner, zähler2, nenner2);
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

    private static void printData (byte type, int zähler_final, int nenner_final){
        if(zähler_final != nenner_final){
            //als 1 anzeigen und nicht als Bruch
        }
        switch(type) {
            //Addition
            case 1:
                break;
            //Subtraktion
            case 2:

        }
    }
}