import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean vram[][];
        byte showexample;
        int displaySize;
        byte color;
        //get al the information
        showexample = getExample();
        displaySize = getSize(showexample);
        color = getcolor(); // if color == 0 no color

        //Fill the field
       vram = fillField(displaySize);

        //Draw field with cross
        vram = drawFielcross(displaySize);

        // Draw Circle
        vram = drawCircle(displaySize);
        //print picture
        printpicture(vram, color);
    }

    private static byte getExample() {}
    private  static int getSize(byte example) {}
    private static byte getcolor() {}

    /*private static void getData(){
        System.out.println("1. Ausgefülltes Rechteck; 2. Rechteck mit Kreuz; 3. Kreis");
        System.out.print("Welches Beispiel soll angezeigt werden:");
        showexample = scanner.nextByte();
        System.out.println();
        System.out.print("Bitte Größe eingeben: ");
        displaySize = scanner.nextInt();
        System.out.println();
        System.out.print("Mit Farbe? [true/false] ");
        qcolor = scanner.nextBoolean();
        System.out.println();
        System.out.print("Wählen Sie eine Farbe: ");
        color = scanner.nextByte();
    }*/

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
        for (int i = 0; i < picture.length; i++){
            for (int j = 0; j < picture[0].length; j++){
                if(picture[i][j] == true){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}