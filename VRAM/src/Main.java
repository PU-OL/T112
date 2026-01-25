import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        boolean vram[][];
        boolean exit = false;
        byte showexample;
        int displaySize;
        byte color;

        do {
            //get al the information
            showexample = getExample();
            displaySize = getSize(showexample);
            color = getcolor(); // if color == 0 no color

            //Add example to internal storage
            switch (showexample) {
                case 1:
                    //Fill the field
                    vram = fillField(displaySize);
                    break;
                case 2:
                    //Draw field with cross
                    vram = drawFielcross(displaySize);
                    break;
                case 3:
                    // Draw Circle
                    vram = drawCircle(displaySize);
                    break;
                default:
                    System.err.println("Ungültige Zahl in showexample");
                    vram = new boolean[1][1];
            }

            //print picture
            printpicture(vram, color);

            //New picture?
            System.out.print("Neues Objekt anzeigen? [J/N]");
            String input = scanner.next();
            switch (input){
                case "J":
                case "j":
                    exit = true;
                    break;
                case "N":
                case "n":
                    exit = false;
                    break;
                default:
                    System.out.println("\u001B[31m Bitte einen gültigen Wert eingeben! \u001B[0m");
                    exit = false;
            }
        }while(exit);
    }

    private static byte getExample() {
        boolean numberInRange;
        byte example;
        System.out.println("Bitte wählen Sie ein Beispiel: ");
        System.out.println("1. Ausgefülltes Rechteck");
        System.out.println("2. Rechteck mit Kreuz");
        System.out.println("3. Kreis");
        do {
            System.out.print("--> ");
            example = scanner.nextByte();
            if (example < 4 && example > 0){
                numberInRange = false;
            }else{
                System.out.println("\u001B[31m Bitte einen gültigen Wert eingeben! \u001B[0m");
                numberInRange = true;
            }
        }while(numberInRange);

        return example;
    }
    private  static int getSize(byte example) {
        boolean valid = true;
        int size;
        System.out.println("Bitte geben Sie die Größe an: ");
        do{
            System.out.print("--> ");
            size = scanner.nextInt();
            if(size%2 == 0 && example == 3){
                System.out.println(" \u001B[31m Bitte eine ungerade Zahl eingeben! \u001B[0m");
            }else {
                valid = false;
            }
        }while(valid);

        return size;
    }

    private static byte getcolor() {
        byte color = 0;
        boolean repeat;
        System.out.println("Soll das Bild mit Farbe sein? [J/N]: ");
        do {
            System.out.print("--> ");
            String input = scanner.next();
            switch (input) {
                case "N":
                case "n":
                    return color;
                case "J":
                case "j":
                    repeat = false;
                    break;
                default:
                    System.out.println("\u001B[31m Bitte einen gültigen Wert eingeben! \u001B[0m");
                    repeat = true;
            }
        }while (repeat);

        System.out.println("Bitte eine Farbe auswählen: ");
        System.out.println("1. Rot");
        System.out.println("2. Blau");
        System.out.println("3. Grün");
        System.out.println("4. Gelb");
        System.out.println("5. Lila");
        System.out.println("6. Cyan");

        do{
            System.out.print("--> ");
            byte input = scanner.nextByte();
            switch (input){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    color = input;
                    repeat = false;
                    break;
                case 42:
                    color = 7;
                    repeat = false;
                    break;
                default:
                    System.out.println("\u001B[31m Bitte einen gültigen Wert eingeben! \u001B[0m");
                    repeat = true;
            }
        }while (repeat);

        return color;
    }

    private static boolean[][] fillField(int size){
        boolean[][] tempvram = new boolean[size][size];
        for (int i = 0; i < tempvram.length; i++) {
            for (int j = 0; j < tempvram[0].length; j++){
                tempvram[j][i] = true;
            }
        }
        return tempvram;
    }

    private static boolean[][] drawFielcross(int size) {
        boolean[][] tempvram = new boolean[size][size];
        for(int i = 0; i < tempvram.length; i++) {
            for (int j = 0; j < tempvram[0].length; j++) {
                if (j == 0 || j == tempvram.length - 1 || i == 0 || i == tempvram.length - 1 || i == j || j == tempvram[0].length - i) {
                    tempvram[j][i] = true;
                }
            }
        }
        return tempvram;
    }

    private static boolean[][] drawCircle(int size){
        boolean[][] tempvram = new boolean[size][size];
        int circle = (int)Math.floor((double)size/2);

        int cordXleft = circle;
        int cordXright = circle;

        for (int i = 0; i < tempvram.length; i++){
            for (int j = 0; j < tempvram[0].length; j++) {
                if(j == cordXright){ // Quadrant 2 + 3
                    tempvram[i][j] = true;
                }
                if(j == cordXleft){ //Quadrant 1 + 4
                    tempvram[i][j] = true;
                }
            }
            if(i < circle){
                cordXleft = cordXleft-1;
                cordXright = cordXright+1;
            }else{
                cordXleft = cordXleft+1;
                cordXright = cordXright-1;
            }
        }
        return tempvram;
    }

    private static void printpicture(boolean[][] picture, byte choosenColor){
        boolean rainbow = false;
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();
        switch (choosenColor){
            case 1:
                System.out.print("\u001B[31m");
                break;
            case 2:
                System.out.print("\u001B[34m");
                break;
            case 3:
                System.out.print("\u001B[32m");
                break;
            case 4:
                System.out.print("\u001B[33m");
                break;
            case 5:
                System.out.print("\u001B[35m");
                break;
            case 6:
                System.out.print("\u001B[36m");
                break;
            case 7:
                rainbow = true;
                break;
            default:
                System.out.print("\u001B[0m");
        }
        for (int i = 0; i < picture.length; i++){
            for (int j = 0; j < picture[0].length; j++){
                if(rainbow){
                    int randCol = random.nextInt(5);
                    switch (randCol){
                        case 0:
                            System.out.print("\u001B[31m");
                            break;
                        case 1:
                            System.out.print("\u001B[34m");
                            break;
                        case 2:
                            System.out.print("\u001B[32m");
                            break;
                        case 3:
                            System.out.print("\u001B[33m");
                            break;
                        case 4:
                            System.out.print("\u001B[35m");
                            break;
                        case 5:
                            System.out.print("\u001B[36m");
                            break;
                        default:
                            System.out.print("\u001B[0m");
                    }
                }
                if(picture[i][j]){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("\u001B[0m");
        System.out.println("-----------------------------------");
        System.out.println();
    }
}