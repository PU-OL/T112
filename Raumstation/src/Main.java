import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[][] spaceStationdata;
        int[][] info;
        spaceStationdata = errorDetection();
        info = energieBerechnung(spaceStationdata);
        printdata(spaceStationdata, info);
    }

    private static int[][] errorDetection(){
        Random random= new Random();
        int[][] spacestation;
        spacestation = new int[5][8]; //spacestation[sector][modul]
        for(int i = 0; i < spacestation.length; i++){
            for(int j = 0; j < spacestation[i].length; j++){
                spacestation[i][j] =  random.nextInt(3);//Zahlen 0-2
            }
        }
        return spacestation;
    }

    private static int[][] energieBerechnung(int[][] energieWerte){
        int gesamtEnergie = 200;
        int[][] alert;
        alert = new int[2][3];
        for(int i = 0; i < energieWerte.length; i++){
            for(int j = 0; j < energieWerte[i].length; j++){
                if(energieWerte[i][j] == 1){
                    gesamtEnergie -= 3;
                }else{
                    if(energieWerte[i][j] == 2){
                        gesamtEnergie -= 10;
                    }
                }
                if(gesamtEnergie < 50 && alert[0][0] != 1) {
                    alert[0][0] = 1;
                    alert[0][1] = i;
                    alert[0][2] = j;
                }
                if(gesamtEnergie < 0 && alert[1][0] != 1){
                    alert[1][0] = 1;
                    alert[1][1] = i;
                    alert[1][2] = j;
                }else{
                    if(alert[1][0] != 1) {
                        alert[1][1] = gesamtEnergie;
                    }
                }
            }
        }
        return alert;
    }

    private static void printdata(int[][] stationdata, int[][] alert){
        System.out.println("\u001B[34m------------------------------------------------------");
        System.out.println("Informationen Raumstation");
        System.out.println();
        System.out.println("Legende: \u001B[32m 0 = OK, \u001B[33m 1 = Fehler, \u001B[31m 2 = Kritischer Fehler\u001B[34m");
        System.out.println("------------------------------------------------------\u001B[0m");
        System.out.println();
        System.out.println("\u001B[36mHole Daten");
        System.out.print("Bitte warten");
        for(int i = 0; i < 3; i++){
            System.out.print(".");
            try {
                Thread.sleep(1000); // 1,0 Sekunden Pause
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
        System.out.println();
        System.out.println();
        System.out.print("Überprüfe Module");
        for(int i = 0; i < 3; i++){
            try {
                System.out.print(".");
                Thread.sleep(1000); // 1,0 Sekunden Pause
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\u001B[0m");
        System.out.println();
        System.out.println("\u001B[35m-----------------");
        System.out.println("Status der Module: \u001B[0m");
        System.out.println();


        for(int i = 0; i < stationdata.length; i++){
            System.out.println("\u001B[35m Sektor: " + (i+1) + "\u001B[0m");
            for(int j = 0; j < stationdata[i].length; j++){
                switch(stationdata[i][j]){
                    case 0:
                        System.out.print("\u001B[32m"); //Grün
                        break;
                    case 1:
                        System.out.print("\u001B[33m"); //Gelb
                        break;
                    case 2:
                        System.out.print("\u001B[31m"); //Rot
                        break;
                }
                System.out.print(stationdata[i][j] + ", ");
                System.out.print("\u001B[0m"); //Reset
                try {
                    Thread.sleep(500); // 0,5 Sekunden Pause
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("\u001B[35m-----------------\u001B[0m");
        System.out.println();
        if(alert[0][0] == 1){
            System.out.println("\u001B[33m---------------------------------------------");
            System.out.println("Warnung: Energie der Reparaturdrohne kritisch");
            System.out.println("Ab: Sektor " + (alert[0][1]+1) + "  Modul " + (alert[0][2]+1));
            System.out.println("---------------------------------------------\u001B[0m");
        }
        if(alert[1][0] == 1){
            System.err.println("---------------------------------------------");
            System.err.println("Systemabsturz! - Keine Energie mehr verfügbar");
            System.err.println("Ab: Sektor " + (alert[1][1]+1) + " Modul " + (alert[1][2]+1));
            System.err.println("---------------------------------------------");
        }else{
            System.out.println("\u001B[32m---------------------------------------------");
            System.out.println("Noch " + alert[1][1] + " von 200 Energieeinheiten vorhanden");
            System.out.println("---------------------------------------------\u001B[0m");
        }
    }
}