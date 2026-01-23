public class Main {
    public static void main(String[] args) {
        int displaySize = 21;
        boolean vram[][] = new boolean[displaySize][displaySize];

        /* Add Full Field
        for (int i = 0; i < vram.length; i++) {
            for (int j = 0; j < vram[0].length; j++) {
                vram[i][j] = true;
            }
        }*/

        /*Add Field with Cross
        for(int i = 0; i < vram.length; i++){
            for(int j = 0; j < vram[0].length;j++){
                if(j == 0 || j == vram.length-1 || i == 0 || i == vram.length-1 || i == j || j == vram[0].length-i){
                    vram[j][i] = true;
                }
            }
        }*/

        /*Add Circle*/
        double sizecircle = displaySize;
        int circle = (int)Math.floor(sizecircle/2);


        for (int i = 0; i < vram.length; i++){
            for (int j = 0; j < vram[0].length; j++) {
                if(vram[j][i]){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}