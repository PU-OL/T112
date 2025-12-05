import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] numbers = werteZuweisung();
        int ergebnis = mittelBrechnung(numbers);
        System.out.println(ergebnis);
    }

    private static int[] werteZuweisung() {
        Random random= new Random();
        int[] randomNumbers;
        randomNumbers = new int[100];
        for(int i = 0; i < randomNumbers.length; i++){
            randomNumbers[i] =  random.nextInt(100);
        }
        return randomNumbers;
    }

    private static int mittelBrechnung(int[] numbers){
        int sum = 0;
        for(int i = 0; i < numbers.length; i++){
            sum += numbers[i];
        }
        return sum/numbers.length;
    }
}