import java.util.*;

public class Main {
    public static void main(String[] args) {
        aufgabe1();
        aufgabe2();
        aufgabe3();
        aufgabe4();

    }

    private static void aufgabe1(){
        int a = 1;
        int b = 2;
        System.out.println("----------");
        System.out.println("Aufgabe 1: ");
        for(int c = a; c <= b; c++){
            System.out.println(c);
        }
        System.out.println("----------");
    }

    private static void aufgabe2(){
        int a = 1;
        int b = 20;
        System.out.println("----------");
        System.out.println("Aufgabe 2: ");
        if(a != b){
            for (int c = a; c <= b; c++){
                System.out.print(c);
                if(c != b) {
                    System.out.print("; ");
                }
            }
            System.out.println();
        }else{
            System.out.println("Es muss a != b sein");
        }
        System.out.println("----------");
    }

    private static void aufgabe3(){
        int n = 5;
        int counter = 0;
        System.out.println("----------");
        System.out.println("Aufgabe 3: ");
        Random r = new Random();
        int arrayLength = r.nextInt(20) + 20;
        int array[] = new int[arrayLength];
        for (int i=0; i<arrayLength; i++){
            array[i] = r.nextInt(100);
        }
        for (int i = 0; i < arrayLength; i++){
            System.out.print(array[i]);
            counter++;
            if (counter == n){
                System.out.println();
                counter = 0;
            }else{
                if(i != arrayLength - 1) {
                    System.out.print("; ");
                }else {
                    System.out.println();
                }
            }
        }
        System.out.println("----------");
    }

    private static void aufgabe4(){
        int n = 3;
        System.out.println("----------");
        System.out.println("Aufgabe 4: ");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("----------");
    }
}