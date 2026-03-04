import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Nr. 1
        int produkt1 = produkt(5,10);
        //Nr. 2
        int produkt2 = produkt(5,10,15);
        System.out.println("Nr. 1\nProdukt aus 2 Zahlen: " + produkt1 + "\nNr. 2\nProdukt aus 3 Zahlen: " + produkt2);
        //Nr. 3
        boolean higherValue = istErsterWertGroesser(42,5);
        System.out.print("Nr. 3\nIst der Wert eins höher als der Wert zwei? ");
        if(higherValue){
            System.out.print("Ja\n");
        }else{
            System.out.print("Nein\n");
        }
        //Nr. 4
        int year = 2026;
        boolean schaltjahr = istSchaltjahr(year);
        System.out.print("Nr. 4\nIst das Jahr " + year + " ein Schaltjahr? ");
        if(schaltjahr){
            System.out.print("Ja\n");
        }else{
            System.out.print("Nein\n");
        }
        //Nr. 5
        int number = 42;
        byte result = sign(number);
        System.out.print("Nr. 5\nDer Wert der Zahl (" + number + ") ist ");
        switch(result){
            case 1:
                System.out.println("positiv");
                break;
            case -1:
                System.out.println("negativ");
                break;
            case 0:
                System.out.println("exakt 0");
                break;
            default:
                System.err.println("Zahl konnte nicht bewertet werden!");
        }
        //Nr. 6
        int[] numbers = {42,52,-5};
        int maxResult = getMaximum(numbers);
        System.out.print("Nr. 6\nDas Maximum der Zahlen: [ ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.print("]\n");
        if(maxResult != -1) {
            System.out.println("ist: " + maxResult);
        }
    }

    private static int produkt (int faktor1, int faktor2){
        int produkt = 0;
        produkt = faktor1*faktor2;
        return produkt;
    }

    private static int produkt (int faktor1, int faktor2, int faktor3){
        int produkt = 0;
        produkt = produkt(produkt(faktor1,faktor2),faktor3);
        return produkt;
    }

    private static boolean istErsterWertGroesser (int valueOne, int valueTwo){
        boolean higherValue = false;
        if (valueOne > valueTwo){
            higherValue = true;
        }
        return higherValue;
    }

    private static boolean istSchaltjahr (int year){
        boolean istSchaltjahr = false;
        if(year % 4 == 0){
            if (year % 100 == 0 && year % 400 == 0){
                istSchaltjahr = true;
            }else{
                if(year % 100 != 0){
                    istSchaltjahr = true;
                }
            }
        }
        return istSchaltjahr;
    }

    private static byte sign (int testValue){
        byte result = 0;
        if (testValue < 0){
            result = -1;
        }else{
            if(testValue > 0){
                result = 1;
            }
        }
        return result;
    }

    private static int getMaximum (int[] numbers){
        int maxValue = 0;

        for (int i = 0; i < numbers.length; i++){
            if(numbers[i] < 0){
                System.err.println("Mindestens eine Zahl ist kleiner als 0!");
                maxValue = -1;
                return maxValue;
            }else {
                if (numbers[i] > maxValue) {
                    maxValue = numbers[i];
                }
            }
        }
        return maxValue;
    }
}