public class Main{
    public static void main(String[] args) {
        long l = 165787121844687L;
        long l2 = 165;

        int i = (int) l; // Ausserhalb des Zahlenbereiches von int
        int i2 = (int) l2; //Im Rahmen des Zahlenbereiches von int

        short s = (short) l; // Ausserhalb des Zahlenbereiches von short
        short s2 = (short) l2; // Im Rahmen des Zahlenbereiches von short

        byte b = (byte) l; // Ausserhalb des Zahlenbereiches von byte
        byte b2 = (byte) l2; // Ausserhalb des Zahlenbereiches von byte

        System.out.println(l + "; " + l2 + "  long -> int: " + i + "; " + i2 + " & short: " + s + "; " + s2 + " & byte: " + b + "; " + b2);

        System.out.println("Wert: \t" + l + l); //Hintereinander hängen der Werte (String + String)
        System.out.println("Wert: \t" + (l + l)); //Addition zu einem Ergebnis (long + long)

        /*
        Es l wird modolo 256 Gerechnet, bei (long -> byte) und als Signed byte gespeichert,
        wodurch die Binärzahl eine 1 an erster position ist und daher negativ angezeigt wird,
        da die Stelle für das Vorzeichen vorgesehen ist.
         */
    }
}