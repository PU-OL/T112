public class Main {
    public static void main(String[] args) {
        int[][] weatherdata = getWeatherData();
        float[][] weatherFahrenheit = changetoFahrenheit(weatherdata);
        float[][] mathresults = processdata(weatherdata);
        printdata(weatherdata, weatherFahrenheit, mathresults);
    }

    private static int[][] getWeatherData(){
        int[][] data;
        data = new int[2][31];
        data[0] = new int[]{20, 27, 23, 11, 14, 29, 18, 11, 30, 30, 22, 16,
                12, 25, 30, 15, 19, 22, 17, 10, 10, 30, 25, 12, 15, 13, 27, 17, 19,
                20, 16};
        data[1] = new int[]{10, 11, 48, 36, 31, 0, 2, 0, 0, 0, 46, 20, 26,
                13, 0, 0, 0, 0, 0, 0, 5, 14, 45, 19, 26, 0, 0, 50, 19, 0, 15};

        return data;
    }

    private static float[][] changetoFahrenheit(int[][]data){
        float[][] temp;
        temp = new float[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                temp[i][j] = (float) (data[i][j]* 1.8 + 32);
            }
        }
        return temp;
    }

    private static float[][] processdata(int[][] weatherdata){
        float[][] temp = new float[4][2];
        temp[1][0] = 99.9F;
        for (int i = 0; i < weatherdata.length; i++) {
            for (int j = 0; j < weatherdata[0].length; j++){
                //Maximumberechnung
                if(weatherdata[i][j] > temp[0][i]){
                    temp[0][i] = weatherdata[i][j];
                }
                //Minimalwertberechnung
                if(weatherdata[i][j] < temp[1][i]){
                    temp[1][i] = weatherdata[i][j];
                }
                //Summe aller Felder
                temp[2][i] = temp[2][i] + weatherdata[i][j];
            }
            //Arithmetisches Mittel
            temp[3][i] = temp[2][i]/ weatherdata[0].length;
        }
        return temp;
    }

    private static void printdata(int[][] weatherdata, float[][] weatherFahrenheit, float[][] mathresults){
        System.out.println("Wetterdaten: ");
        System.out.println("----------");
        System.out.println("Temperatur in Grad Celsius: ");
        for (int i = 0; i < weatherdata.length; i++) {
            switch(i){
                case 0:
                    System.out.print("Mai:");
                    break;
                case 1:
                    System.out.print("Juni: ");
                    break;
                default:
                    System.out.print("Monat unbekannt");
                    break;
            }
            for (int j = 0; j < weatherdata[0].length; j++) {
                System.out.print(weatherdata[i][j] + "°C; ");
            }
        }
        System.out.println();
        System.out.println("----------");
        System.out.println("Fahrenheit: ");
        for (int i = 0; i < weatherFahrenheit.length; i++) {
            switch(i){
                case 0:
                    System.out.print("Mai: ");
                    break;
                case 1:
                    System.out.print("Juni: ");
                    break;
                default:
                    System.out.print("Monat unbekannt");
                    break;
            }
            for(int j = 0; j < weatherFahrenheit[0].length; j++){
                System.out.print(weatherFahrenheit[i][j]);
                if(j != weatherFahrenheit.length){
                    System.out.print("°F; ");
                }
            }
        }
        System.out.println();
        System.out.println("----------");
        System.out.println("Ausgabe nach dem Format: Mai; Juni");
        for(int i = 0; i < mathresults.length; i++){
            switch(i){
                case 0:
                    System.out.print("Maximal Werte: ");
                    break;
                case 1:
                    System.out.print("Minimal Werte: ");
                    break;
                case 2:
                    System.out.print("Summer aller Temperaturen: ");
                    break;
                case 3:
                    System.out.print("arithmetische Mittel: ");
                    break;
                default:
                    System.out.println(" --- Kein Hinweis --- ");
            }
            for(int j = 0; j < mathresults[0].length; j++){
                System.out.print(mathresults[i][j] + "°C");
                if(j != mathresults[0].length){
                    System.out.print("; ");
                }
            }
            System.out.println();
        }
    }
}