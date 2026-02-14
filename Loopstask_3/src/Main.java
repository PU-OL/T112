import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
    }

    private static void task1 (){
        System.out.println("Task 1:\n Zahlen von 1-10 mit for, while und do-while Schleife");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }

        System.out.println();
        int i = 1;
        do{
            System.out.print(i + " ");
            i ++;
        }while(i <= 10);
        System.out.println();

        i = 1;
        while(i <= 10){
            System.out.print(i + " ");
            i ++;
        }
        System.out.println("\n----------");
    }

    private static void task2(){
        int sum = 0;
        for(int i= 1; i <= 10; i++){
            sum = sum + i;
        }
        System.out.print("Summe der Zahlen 1 - 10: " + sum);
        System.out.println("\n----------");
    }

    private static void task3(){
        int sum = 0;
        System.out.print("Bitte einen Startwert eingeben: ");
        int in_start = scanner.nextInt();
        System.out.print("Bitte einen Zielwert eingeben: ");
        int in_target = scanner.nextInt();
        int start;
        int target;
        if(in_start > in_target){
            start = in_target;
            target = in_start;
        }else {
            start = in_start;
            target = in_target;
        }
        for(int i = start; i <= target; i++){
            sum = sum + i;
        }
        System.out.print("Summe der Zahlen von " + start + " bis " + target + " ist: " + sum);
        System.out.println("\n----------");
    }

    private static void task4(){
        float sum = 0;
        float count = 0;
        System.out.print("Bitte einen Startwert eingeben: ");
        int in_start = scanner.nextInt();
        System.out.print("Bitte einen Zielwert eingeben: ");
        int in_target = scanner.nextInt();
        int start;
        int target;
        if(in_start > in_target){
            start = in_target;
            target = in_start;
        }else {
            start = in_start;
            target = in_target;
        }
        for(int i = start; i <= target; i++){
            sum = sum + i;
            count ++;
        }

        float middle = sum/count;
        System.out.print("Der Mittelwert der Zahlen von " + start + " bis " + target + " ist: " + middle);
        System.out.println("\n----------");
    }

    private static void task5(){
        //n random nummern -> Summe Mittelwert Ausgabe
        double[] randomNumbers;
        int sum = 0;
        float mittel;

        System.out.print("Bitte geben Sie an, wie viele zufällige Zahlen Sie haben möchten: ");
        int n = 0;
        do {
            n = scanner.nextInt();
            if(n < 1){
                System.out.println("Die Zahl muss größer als 0 sein! Bitte erneut versuchen!");
            }
        }while(n < 1);
        System.out.println();

        randomNumbers = new double[n];

        for (int i = 0; i < n; i++){
            randomNumbers[i] = random.nextDouble(100);
        }

        for (int i = 0; i < randomNumbers.length; i++){
            sum = sum +  (int) randomNumbers[i];
        }

        mittel = (float) sum / randomNumbers.length;

        System.out.println("Ihre Zufallszahlen: ");
        for (int i = 0; i < randomNumbers.length; i++){
            System.out.print(randomNumbers[i] + " ");
        }
        System.out.println("\nDie Summer der Zufallszahlen: " + sum + "\nDer Mittelwert der Zufallszahlen: " + mittel);
        System.out.print("Press Enter to proceed. ");
        System.out.print("\n----------");
        scanner.nextLine();
        scanner.nextLine();

    }

    private static void task6(){
        int[][] qFunction = new int[2][101];

        for(int j = 0; j < qFunction[0].length; j++){
            qFunction[0][j] = j;
            qFunction[1][j] = j*j;
        }
        System.out.println(" x | x*x \n ---------");
        for(int j = 1; j < qFunction[0].length; j++){
            System.out.println(qFunction[0][j] + " | " + qFunction[1][j]);
        }
        System.out.println("\n----------");
    }

    private static void task7(){
        double percent = 0;
        int numberOfPeople;
        System.out.print("Bitte eine Personenanzahl angeben: ");
        do {
            numberOfPeople = scanner.nextInt();
            if(numberOfPeople <= 0 || numberOfPeople > 364){
                System.out.println("Bitte einen Wert, größer als 0 und kleiner als 365, eingeben!");
            }
        }while(numberOfPeople <= 0 || numberOfPeople > 364);

        System.out.println();
        double yearMultiplier = 1.0;
        double nenner = 0.0;

        nenner = Math.pow(365, numberOfPeople);

        for(int i = 0; i < numberOfPeople; i++){
            if(i == 0){
                yearMultiplier = 365.0;
            }else {
                yearMultiplier = yearMultiplier * (365.0 - i);
            }
        }

        percent = (1-(yearMultiplier/nenner))*100;

        System.out.println("Die Wahrscheinlichkeit bei " + numberOfPeople + " Personen beträgt: " + percent + "%");
        System.out.println("\n----------");
    }
}