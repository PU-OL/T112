import java.util.Scanner;

public class Main {
    static String[][] table = new String[6][5];
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int auswahl = 0;
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[i].length; j++){
                table[i][j] = "-- \t ";
            }
        }
        do{
            System.out.flush();
            System.out.println("----------------------------------");
            System.out.println("1. Stundenplan ausgeben");
            System.out.println("2. Stunde eintragen");
            System.out.println("3. Beenden");
            System.out.print("Bitte auswählen: ");
            auswahl = scanner.nextInt();
            if(auswahl == 1) {
                System.out.println("----------------------------------");
                System.out.println();
                printTable();
            }else if(auswahl == 2) {
                System.out.println("----------------------------------");
                System.out.println();
                addData();
            }
            if(auswahl > 3 || auswahl < 1) {
                System.err.println("Bitte eine gültige Zahl eingeben!");
            }
        }while(auswahl != 3);
    }

    private static void addData(){
        String day = "";
        int tableday = 0;
        int hour = 0;
        String fach = "";
        String tablefach = "";
        boolean stop = false;
        boolean forward = false;
        boolean forward2 = false;

        do {
            System.out.flush();
            System.out.println("**Stunden eintragen");
            System.out.println();
            System.out.println("Bitte Abkürzung Tag und Stunde eingeben. (z.B.: Tag -> Montag = Mo; Stunde -> 1)");
            System.out.println();
            System.out.print("Tag: ");
            day = scanner.next();
            System.out.println();
            System.out.print("Stunde: ");
            hour = scanner.nextInt();
            System.out.println();
            System.out.print("Fachabkürzung (max. 2 Buchstaben; zum leeren nicht eingeben): ");
            fach = scanner.next();
            System.out.println();

            switch(day){
                case "Mo":
                    tableday = 1;
                    forward = true;
                    break;
                case "Di":
                    tableday = 2;
                    forward = true;
                    break;
                case "Mi":
                    tableday = 3;
                    forward = true;
                    break;
                case "Do":
                    tableday = 4;
                    forward = true;
                    break;
                case "Fr":
                    tableday = 5;
                    forward = true;
                    break;
                default:
                    System.err.println("Kein gültigen Tag eingegeben");
            }

            if(fach.length() < 3){
                switch(fach.length()){
                    case 1:
                        tablefach = fach + "  \t ";
                        break;
                    case 2:
                        tablefach = fach + " \t ";
                        break;
                    default:
                        tablefach = "-- \t";
                }
                forward2 = true;
            }else{
                System.err.println("Bitte ein gültiges Fach eingeben!");
            }

            if(forward ==  true && forward2 == true && hour < 6 && hour > 0){
                table[hour-1][tableday-1] = tablefach;
                stop = true;
                forward2 = false;
                forward = false;
            }else {
                System.err.println("Es ist ein allgemeiner Fehler aufgetreten oder die Stunde ausserhalb des Bereiches");
            }
        }while(!stop);
    }

    private static void printTable(){
        System.out.flush();
        System.out.println("\t Aktueller Stundenplan");
        System.out.println();
        System.out.println("Mo \t Di \t Mi \t Do \t Fr");
        System.out.println("----------------------------------");
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            for(int j = 0; j < table[i].length; j++){
                System.out.print(table[i][j]);
            }
            System.out.println();
        }
    }
}
