import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static String[][] connections = new String[4][3]; //connection[line][1 = start; 2 = target; 3 = time

    public static void main(String[] args) {
        addConn();
        System.out.println("Auswählen aus: Frankfurt_HBF, Berlin_HBF, Koeln_Messe_Deutz, Muenchen_HBF");
        System.out.print("Bitte einen Startpunkt eingeben: ");
        String start =  scanner.next();
        System.out.println();
        System.out.print("Bitte Zielpunkt eingeben: ");
        String target = scanner.next();
        System.out.println();

        for (int i = 0; i < connections.length; i++) {
            if (connections[i][0].equals(start) && connections[i][1].equals(target)) {
                System.out.println(connections[i][0] + " --> " + connections[i][1]);
                System.out.println("Dauer: " + connections[i][2]);
            }
            if (connections[i][1].equals(start) && connections[i][0].equals(target)) {
                System.out.println(connections[i][1] + " --> " + connections[i][0]);
                System.out.println("Dauer: " + connections[i][2]);
            }
        }
    }

    private static void addConn() {
        int time;
        for (int i = 0; i < connections.length; i++) {
            switch(i){
                case 0:
                    connections[i][0] = "Frankfurt_HBF";
                    connections[i][1] = "Koeln_Messe_Deutz";
                    time = random.nextInt(3);
                    connections[i][2] = time + "";
                    break;
                case 1:
                    connections[i][0] = "Frankfurt_HBF";
                    connections[i][1] = "Berlin_HBF";
                    time = random.nextInt(5);
                    connections[i][2] = time + "";
                    break;

                case 2:
                    connections[i][0] = "Koeln_Messe_Deutz";
                    connections[i][1] = "Muenchen_HBF";
                    time = random.nextInt(7);
                    connections[i][2] = time + "";
                    break;

                default:
                    connections[i][0] = "String" + i;
                    connections[i][1] = "String2" + i;
                    time = random.nextInt(5);
                    connections[i][2] = time + "";
            }
        }
    }
}