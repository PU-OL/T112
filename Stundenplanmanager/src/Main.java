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
            if(auswahl == 42){
                tableexample();
            }
            if(auswahl > 3 && auswahl != 42 || auswahl < 1 ) {
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
        boolean doppel = false;

        do {
            System.out.flush();
            System.out.println("**Stunden eintragen**");
            System.out.println();
            System.out.println("Bitte Abkürzung Tag und Stunde eingeben. (z.B.: Tag -> Montag = Mo; Stunde -> 1)");
            System.out.println();
            System.out.print("Tag: ");
            day = scanner.next();
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
                    System.out.println("\u001B[31m Kein gültigen Tag eingegeben \u001B[0m");
                    continue;
            }
            System.out.println();
            System.out.print("Stunde: ");
            hour = scanner.nextInt();
            if(hour > 6 && hour < 0){
                System.out.println("\u001B[31m Ausserhalb des Zahlenbereiches! \u001B[0m");
                continue;
            }
            System.out.println();
            System.out.print("Fachabkürzung (max. 2 Buchstaben; zum leeren nicht eingeben): ");
            fach = scanner.next();
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
                System.out.println("\u001B[31m Bitte ein gültiges Fach eingeben! \u001B[0m");
                continue;
            }
            System.out.println();
            System.out.print("Doppelstunde? [J/N]");
            String x = scanner.next();
            if(x.equals("J") || x.equals("j")){
                doppel = true;
            }
            System.out.println();

            if(forward ==  true && forward2 == true){
                table[hour-1][tableday-1] = tablefach;
                if(doppel){
                    table[hour][tableday-1] = tablefach;
                }
                doppel = false;
                stop = true;
                forward2 = false;
                forward = false;
            }else {
                System.out.println("\u001B[31m Es ist ein allgemeiner Fehler aufgetreten! \u001B[0m");
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

    private static void tableexample(){
        String exampleData = "Pr,Pr,Pr,Pr,Pr,Pr,Pr,Pr,Pr,Pr,Pr,Pr,T7,T7,T5,T5,T6,T6,Po,Po,M,M,D,D,T2,T2,E,E,X,X";
        String temp[] = exampleData.split(",");
        for(int i = 0; i < temp.length; i++){
            if(temp[i].equals("X")){
                temp[i] = "";
            }
            switch(temp[i].length()){
                case 1:
                    temp[i] = temp[i] + "  \t ";
                    break;
                case 2:
                    temp[i] = temp[i] + " \t ";
                    break;
                default:
                    temp[i] = "-- \t";
            }
        }
        // hour -> Day
        int k = 0;
        for(int i = 0; i < table[0].length; i++){
            for(int j = 0; j < table.length; j++){
                table[j][i] = temp[k];
                k++;
            }
        }
    }
}
