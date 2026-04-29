import java.util.*;

public class Main{
    static Random rand = new Random();
    static boolean debug = false;
    public static void main(String[] args){
        int[] value = wuerfeln();
        System.out.print("Würfelergebnisse: ");
        for(int i = 0; i < value.length; i++){
            System.out.print(value[i] + " ");
        }
        System.out.println();
        System.out.println("Sechs gewürfelt? " + findSix(value, 6));
        System.out.println("Anzahl an gewürfelten Sechsen: " + returnSix(value,6));

        int[] player = {1,3,5,7,8,10,11,13,14,16,19};
        int playernumber = 3;
        System.out.println("Player with Number " +  playernumber + " is playing: " + binarySearch(player, playernumber));
    }

    private static int[] wuerfeln(){
        int[] result = new int[30];
        for (int i = 0; i < result.length; i++){
            result[i] =  (rand.nextInt(6)+1);
            if(debug) System.out.println((i+1) + ". Wurf: " + result[i]);
        }
        return result;
    }

    private static boolean findSix(int[] array, int searchValue){
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == searchValue){
                if(debug) System.out.println("Searchvalue (" + searchValue + ") found.");
                return true;
            }
        }
        return false;
    }

    private static int returnSix(int[] array, int searchValue){
        int result = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == searchValue){
                if(debug) System.out.println("Found " + searchValue + " at Position " + i + ", new value = " + result);
                result++;
            }
        }
        return result;
    }

    private static boolean binarySearch(int[] array, int searchValue){
        int left = 0;
        int right = array.length-1;
        int middle;
        while(left <= right){
            middle = (left + right)/2;
            if(debug){
                System.out.println("Left: " + left + "; Middle: " + middle + "; Right: " + right);
            }
            if(array[middle] == searchValue){
                if(debug) System.out.println("Player found");
                return true;
            }
            if(array[middle] < searchValue){
                left = middle + 1;
            }
            if(array[middle] > searchValue){
                right = middle -1;
            }
        }
        if(debug) System.out.println("Player not found");
        return false;
    }

}