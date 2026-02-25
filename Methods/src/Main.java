import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start Test Typ I\n----------");
        ausgabeName();
        ausgabeVorname();
        ausgabeNameKomplett();
        String name = getName();
        String vorname = getVorname();
        int numbers = getProdukt1bis10();
        System.out.println("End Test Typ I\n----------\nName: " + name + ", Vorname: " + vorname + "\nProdukt aus 1 bis 10: " + numbers + "\nEnd Test Typ II\n----------\nStart Test Typ III\n----------");
        ausgabeNameII("Test V");
        ausgabeVornameII("Test VI");
        ausgabeNameKomplettII("Test VI", "Test V");
        System.out.println("End Test Typ III\n---------\nStart Test Typ IV\n----------");
        String fullname = getNameKomplett("IIX", "Test VII");
        String progInfo = getProgrammEndeMeldung("P-Ende");
        int[] numberTo = getZahlen1bis(42);
        System.out.print("Fullname: " + fullname + "\nZahlen von 1 bis x: ");
        for(int i = 0; i < numberTo.length; i++) {
            System.out.print(numberTo[i] + " ");
        }
        System.out.println();
        System.err.println(progInfo);
        System.out.println("End Test Typ IV\n----------");
    }

    private static void ausgabeName(){
        System.out.println("Test_I");
    }

    private static void ausgabeVorname(){
        System.out.println("Test_II");
    }

    private static void ausgabeNameKomplett(){
        System.out.println("Test_II Test_I");
    }

    private static String getName(){
        String name = "Test_III";
        return name;
    }

    private static String getVorname(){
        String vorname = "Test_IV";
        return vorname;
    }

    private static int getProdukt1bis10(){
        int bis10 = 1;
        for(int i = 0; i < 10; i++){
            bis10 = bis10 * i;
        }
        return bis10;
    }

    private static void ausgabeNameII(String name){
        System.out.println(name);
    }

    private static void ausgabeVornameII(String vorname){
        System.out.println(vorname);
    }

    private static void ausgabeNameKomplettII(String vorname, String name){
        System.out.println(vorname + " " + name);
    }

    private static String getNameKomplett(String name, String vorname){
        String fullname = vorname + " " + name;
        return fullname;
    }

    private static String getProgrammEndeMeldung(String info){
        String answer = "";
        if(info.equals("P-Ende")){
            answer = "Programm wird beendet";
        }else{
            answer = "-";
        }
        return answer;
    }

    private static int[] getZahlen1bis(int end){
        int[] zahlen = new int[end];

        for(int i = 0; i < end; i++){
            zahlen[i] = i+1;
        }

        return zahlen;
    }
}