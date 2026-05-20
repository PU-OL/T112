public class Main {
    public static void main(String[] args){
        int[] Test = {5,6,1,8,48,62,68,5163,16169,196,198,63,6469,8,4689,4,935,652,1964,643,7};
        System.out.println("Selevtion Sort: ");
        int[] test = selectionSort(Test);
        for (int i = 0; i < test.length; i++){
            System.out.print(test[i] + " ");
        }
        System.out.println();
        System.out.println("Insertion Sort: ");
        int[] test_I = insertionSort(Test);
        for (int i = 0; i < test.length; i++){
            System.out.print(test[i] + " ");
        }
        System.out.println();
        System.out.println("Bubble Sort: ");
        int[] test_II = bubbleSort(Test);
        for (int i = 0; i < test.length; i++){
            System.out.print(test[i] + " ");
        }
    }

    private static int[] selectionSort(int[] array){
        int left = 0;
        int min = left;

        while(left < array.length){
            min = left;
            for(int i = left+1; i < array.length; i++){
                if (array[i] < array[min]){
                    min = i;
                }
            }
            int a = array[left];
            int b = array[min];
            array[min] = a;
            array[left] = b;
            left = left+1;
        }
        return array;
    }

    private static int[] insertionSort(int[] array){
        for (int i = 1; i < array.length; i++){
            int key = array[i];
            int j = i;
            while (j > 0 && array[j-1] > key){
                array[j] = array[j-1];
                j = j-1;
            }
            array[j] = key;
        }
        return array;
    }

    private static int[] bubbleSort(int[] array){
        int minpos;
        for(int i = 0; i < array.length; i++){
            minpos = i;
            for (int j = i+1; j < array.length; j++){
                if(array[j] < array[minpos]){
                    minpos = j;
                }
            }
            if(minpos > i){
                int a = array[minpos];
                int b = array[i];
                array[i] = a;
                array[minpos] = b;
            }
        }
        return array;
    }
}