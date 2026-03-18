import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    private enum Operation {
        ADDITION("Addition"),
        SUBTRAKTION("Subtraktion"),
        MULTIPLIKATION("Multiplikation"),
        DIVISION("Division"),
        KUERZEN("Kürzen (erster Bruch)"),
        ERWEITERN("Erweitern auf gemeinsamen Nenner"),
        GGT("Größter gemeinsamer Teiler (erster Bruch)");

        private final String label;

        Operation(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private final JComboBox<Operation> operationBox = new JComboBox<>(Operation.values());
    private final JTextField zaehler1Field = new JTextField("1", 5);
    private final JTextField nenner1Field = new JTextField("2", 5);
    private final JTextField zaehler2Field = new JTextField("1", 5);
    private final JTextField nenner2Field = new JTextField("3", 5);
    private final JTextArea resultArea = new JTextArea(6, 32);
    private JPanel contentPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main app = new Main();
            if (args.length == 2 && "--screenshot".equals(args[0])) {
                app.saveScreenshot(args[1]);
                System.exit(0);
                return;
            }
            app.createAndShowGui();
        });
    }

    private void createAndShowGui() {
        JFrame frame = new JFrame("Bruchrechner");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(buildContent());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel buildContent() {
        if (contentPanel != null) {
            return contentPanel;
        }

        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setText("Ergebnis erscheint hier.");

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("Funktion"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.gridwidth = 3;
        inputPanel.add(operationBox, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Bruch 1"), gbc);
        gbc.gridx = 1;
        inputPanel.add(zaehler1Field, gbc);
        gbc.gridx = 2;
        inputPanel.add(new JLabel("/"), gbc);
        gbc.gridx = 3;
        inputPanel.add(nenner1Field, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Bruch 2"), gbc);
        gbc.gridx = 1;
        inputPanel.add(zaehler2Field, gbc);
        gbc.gridx = 2;
        inputPanel.add(new JLabel("/"), gbc);
        gbc.gridx = 3;
        inputPanel.add(nenner2Field, gbc);

        JButton calculateButton = new JButton("Berechnen");
        calculateButton.addActionListener(this::onCalculate);
        JButton exitButton = new JButton("Beenden");
        exitButton.addActionListener(e -> System.exit(0));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        buttonPanel.add(calculateButton);
        buttonPanel.add(exitButton);

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.add(new JLabel("Anzeige"), BorderLayout.NORTH);
        resultPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        contentPanel = new JPanel(new BorderLayout(8, 8));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPanel.add(inputPanel, BorderLayout.NORTH);
        contentPanel.add(resultPanel, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.SOUTH);
        return contentPanel;
    }

    private void onCalculate(ActionEvent event) {
        resultArea.setText(calculate());
    }

    private String calculate() {
        Operation operation = (Operation) operationBox.getSelectedItem();
        int z1;
        int n1;
        int z2;
        int n2;
        try {
            z1 = Integer.parseInt(zaehler1Field.getText().trim());
            n1 = Integer.parseInt(nenner1Field.getText().trim());
            z2 = Integer.parseInt(zaehler2Field.getText().trim());
            n2 = Integer.parseInt(nenner2Field.getText().trim());
        } catch (NumberFormatException ex) {
            return "Bitte geben Sie ganze Zahlen ein.";
        }

        if (operation == null) {
            return "Bitte wählen Sie eine Funktion.";
        }

        switch (operation) {
            case ADDITION:
                return addieren(z1, n1, z2, n2);
            case SUBTRAKTION:
                return subtraktion(z1, n1, z2, n2);
            case MULTIPLIKATION:
                return multiplikation(z1, n1, z2, n2);
            case DIVISION:
                return dividieren(z1, n1, z2, n2);
            case KUERZEN:
                return kuerzenBeschreibung(z1, n1);
            case ERWEITERN:
                return erweiternBeschreibung(z1, n1, z2, n2);
            case GGT:
                return ggtBeschreibung(z1, n1);
            default:
                return "Unbekannte Funktion.";
        }
    }

    private void saveScreenshot(String path) {
        JPanel panel = buildContent();
        panel.doLayout();
        Dimension preferredSize = panel.getPreferredSize();
        panel.setSize(preferredSize);

        BufferedImage image = new BufferedImage(preferredSize.width, preferredSize.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        g2.setColor(panel.getBackground());
        g2.fillRect(0, 0, preferredSize.width, preferredSize.height);
        panel.printAll(g2);
        g2.dispose();

        try {
            ImageIO.write(image, "png", new File(path));
        } catch (IOException e) {
            System.err.println("Konnte Screenshot nicht speichern: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String kuerzenBeschreibung(int zaehler, int nenner) {
        if (nenner == 0) {
            return "Nenner darf nicht 0 sein.";
        }
        int teiler = ggT(zaehler, nenner);
        int zaehlerGekuertzt = zaehler;
        int nennerGekuertzt = nenner;
        if (teiler > 1) {
            zaehlerGekuertzt = zaehler / teiler;
            nennerGekuertzt = nenner / teiler;
        }
        int[] normalized = normalize(zaehlerGekuertzt, nennerGekuertzt);
        zaehlerGekuertzt = normalized[0];
        nennerGekuertzt = normalized[1];
        return "Der Bruch " + formatFraction(zaehler, nenner) + " wurde zu " + formatFraction(zaehlerGekuertzt, nennerGekuertzt) + " gekürzt.";
    }

    private static String erweiternBeschreibung(int zaehler1, int nenner1, int zaehler2, int nenner2) {
        if (nenner1 == 0 || nenner2 == 0) {
            return "Nenner dürfen nicht 0 sein.";
        }
        int[] werte = erweitern(zaehler1, nenner1, zaehler2, nenner2);
        return "Die Erweiterung der Brüche " + formatFraction(zaehler1, nenner1) + " und " + formatFraction(zaehler2, nenner2) +
                " ergibt: " + formatFraction(werte[1], werte[0]) + " und " + formatFraction(werte[2], werte[0]);
    }

    private static String addieren(int zaehler1, int nenner1, int zaehler2, int nenner2) {
        if (nenner1 == 0 || nenner2 == 0) {
            return "Nenner dürfen nicht 0 sein.";
        }
        int[] erweiterteWerte = erweitern(zaehler1, nenner1, zaehler2, nenner2);
        int nennerGemeinsam = erweiterteWerte[0];
        int zaehlerGemeinsam1 = erweiterteWerte[1];
        int zaehlerGemeinsam2 = erweiterteWerte[2];

        int zaehlerResult = zaehlerGemeinsam1 + zaehlerGemeinsam2;
        int teiler = ggT(zaehlerResult, nennerGemeinsam);
        if (teiler > 1) {
            zaehlerResult = zaehlerResult / teiler;
            nennerGemeinsam = nennerGemeinsam / teiler;
        }
        int[] normalized = normalize(zaehlerResult, nennerGemeinsam);
        zaehlerResult = normalized[0];
        nennerGemeinsam = normalized[1];

        return "Die Addition der Brüche " + formatFraction(zaehler1, nenner1) + " und " + formatFraction(zaehler2, nenner2) +
                " ergibt: " + formatFraction(zaehlerResult, nennerGemeinsam);
    }

    private static String subtraktion(int zaehler1, int nenner1, int zaehler2, int nenner2) {
        if (nenner1 == 0 || nenner2 == 0) {
            return "Nenner dürfen nicht 0 sein.";
        }
        int[] erweiterteWerte = erweitern(zaehler1, nenner1, zaehler2, nenner2);
        int nennerGemeinsam = erweiterteWerte[0];
        int zaehlerGemeinsam1 = erweiterteWerte[1];
        int zaehlerGemeinsam2 = erweiterteWerte[2];

        int zaehlerResult = zaehlerGemeinsam1 - zaehlerGemeinsam2;
        int teiler = ggT(zaehlerResult, nennerGemeinsam);
        if (teiler > 1) {
            zaehlerResult = zaehlerResult / teiler;
            nennerGemeinsam = nennerGemeinsam / teiler;
        }
        int[] normalized = normalize(zaehlerResult, nennerGemeinsam);
        zaehlerResult = normalized[0];
        nennerGemeinsam = normalized[1];

        return "Die Subtraktion der Brüche " + formatFraction(zaehler1, nenner1) + " und " + formatFraction(zaehler2, nenner2) +
                " ergibt: " + formatFraction(zaehlerResult, nennerGemeinsam);
    }

    private static String multiplikation(int zaehler1, int nenner1, int zaehler2, int nenner2) {
        if (nenner1 == 0 || nenner2 == 0) {
            return "Nenner dürfen nicht 0 sein.";
        }
        int zaehlerResult = zaehler1 * zaehler2;
        int nennerResult = nenner1 * nenner2;

        int teiler = ggT(zaehlerResult, nennerResult);
        if (teiler > 1) {
            zaehlerResult = zaehlerResult / teiler;
            nennerResult = nennerResult / teiler;
        }
        int[] normalized = normalize(zaehlerResult, nennerResult);
        zaehlerResult = normalized[0];
        nennerResult = normalized[1];

        return "Die Multiplikation der Brüche " + formatFraction(zaehler1, nenner1) + " und " + formatFraction(zaehler2, nenner2) +
                " ergibt: " + formatFraction(zaehlerResult, nennerResult);
    }

    private static String dividieren(int zaehler1, int nenner1, int zaehler2, int nenner2) {
        if (nenner1 == 0 || nenner2 == 0) {
            return "Nenner dürfen nicht 0 sein.";
        }
        if (zaehler2 == 0) {
            return "Beim Dividieren darf der Zähler des zweiten Bruchs nicht 0 sein.";
        }
        int zaehlerResult = zaehler1 * nenner2;
        int nennerResult = nenner1 * zaehler2;

        int teiler = ggT(zaehlerResult, nennerResult);
        if (teiler > 1) {
            zaehlerResult = zaehlerResult / teiler;
            nennerResult = nennerResult / teiler;
        }
        int[] normalized = normalize(zaehlerResult, nennerResult);
        zaehlerResult = normalized[0];
        nennerResult = normalized[1];

        return "Die Division der Brüche " + formatFraction(zaehler1, nenner1) + " und " + formatFraction(zaehler2, nenner2) +
                " ergibt: " + formatFraction(zaehlerResult, nennerResult);
    }

    private static String ggtBeschreibung(int zaehler, int nenner) {
        if (nenner == 0) {
            return "Nenner darf nicht 0 sein.";
        }
        int teiler = ggT(zaehler, nenner);
        return "Der größte gemeinsame Teiler von " + zaehler + " und " + nenner + " ist: " + teiler;
    }

    /**
     * Liefert die erweiterte Form zweier Brüche.
     * Index 0: gemeinsamer Nenner, 1: erweiterter Zähler des ersten Bruchs, 2: erweiterter Zähler des zweiten Bruchs.
     */
    private static int[] erweitern(int zaehler1, int nenner1, int zaehler2, int nenner2) {
        int[] values = new int[3];

        if (nenner1 != nenner2) {
            values[0] = nenner1 * nenner2;
            values[1] = zaehler1 * nenner2;
            values[2] = zaehler2 * nenner1;
        } else {
            values[0] = nenner1;
            values[1] = zaehler1;
            values[2] = zaehler2;
        }

        return values;
    }

    private static int ggT(int zaehler, int nenner) {
        int a = Math.abs(zaehler);
        int b = Math.abs(nenner);
        if (a == 0 && b == 0) {
            return 1;
        }
        int rest;
        while (b != 0) {
            rest = a % b;
            a = b;
            b = rest;
        }
        return a;
    }

    /**
     * Stellt sicher, dass der Nenner positiv ist, indem ein negatives Vorzeichen auf den Zähler übertragen wird.
     */
    private static int[] normalize(int zaehler, int nenner) {
        if (nenner < 0) {
            zaehler = -zaehler;
            nenner = -nenner;
        }
        return new int[]{zaehler, nenner};
    }

    /**
     * Formats a fraction as Zähler/Nenner (numerator/denominator) for display.
     */
    private static String formatFraction(int zaehler, int nenner) {
        return zaehler + "/" + nenner;
    }
}
