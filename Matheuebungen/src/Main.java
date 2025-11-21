public class Main {
    public static void main(String[] args) {
        uebung1();
        uebung2();
        uebung3a();
        uebung3b();
        uebung4();
    }

    private static void uebung1() {
        System.out.println("Übung 1:");
        for(int i = 0; i < 18; i++){
            System.out.print(i+8);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println();
        System.out.println("-----");
        System.out.println();
    }

    private static void uebung2(){
        int temp = 0;
        System.out.println("Übung 2:");
        for(int i = 0; i < 24; i++){
            if( i > 1) {
                for (int j = 0; j < i-1; j++) {
                    if (temp == 0) {
                        temp = 2 * 2;
                    } else {
                        temp = temp * 2;
                    }
                }
            }else{
                if(i == 0){
                    temp = 1;
                } else if (i == 1) {
                    temp = 2;
                }
            }
            System.out.print(temp);
            System.out.print(" ");
            temp = 0;
        }
        System.out.println();
        System.out.println();
        System.out.println("-----");
        System.out.println();
    }

    private static void uebung3a(){
        System.out.println("Übung 3a:");
        for(int i = 0; i < 10; i++){
            System.out.println(i+1 + "er Reihe: ");
            for(int j = 0; j < 10; j++){
                System.out.println( (j+1) + "*" + (i+1) + "=" + (j+1)*(i+1) + " ");
            }
            System.out.println();
        }
        System.out.println("-----");
        System.out.println();
    }

    private static void uebung3b(){
        System.out.println("Übung 3b:");
        for(int i = 0; i < 10; i++){
            System.out.print(i+1 + "er Reihe: ");
            for(int j = 0; j < 10; j++){
                System.out.print((i+1)*(j+1) + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("-----");
        System.out.println();
    }

    private static void uebung4(){
        System.out.println("Übung 4:");
        for(int i = 1; i < 60; i++){
            if(i % 10 != 0){
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("-----");
        System.out.println();
    }
}