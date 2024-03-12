package fidelitycard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Premi extends JFrame {

    public Premi() {
        // Impostazioni  della finestra
        setTitle("Premi Tessera Punti");
        setSize(400, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        // Creazione dell intro per i punti
        JPanel introPanel = createIntroPanel("Come ottenere punti", "Puoi accumulare punti ogni volta che prenoti un servizio nel nostro centro estetico. Ogni euro speso equivale a 1 punto. Più servizi prenoti, più punti accumuli.");
        
        JScrollPane introScrollPane = new JScrollPane();
        introScrollPane.setViewportView(introPanel);

        // Creazione dei pannelli per i premi
        JPanel panel1 = createPanel("Primo Premio", "100 punti - Massaggio gratis", Color.GREEN, "Massaggi: Massaggio rilassante, Massaggio sportivo, Massaggio linfodrenante");
        JPanel panel2 = createPanel("Secondo Premio", "80 punti - Trattamento viso gratuito", Color.YELLOW, "Trattamenti viso: Pulizia del viso, Trattamento idratante, Trattamento anti-età");
        JPanel panel3 = createPanel("Terzo Premio", "60 punti - Taglio di capelli gratuito", Color.BLUE, "Tagli di capelli: Taglio classico, Taglio moderno, Taglio alla moda");
        JPanel panel4 = createPanel("Quarto Premio", "40 punti - Smalto semipermanente per unghie", Color.ORANGE, "Manicure: Smalto semipermanente, Manicure francese, Manicure con decorazioni");
        JPanel panel5 = createPanel("Quinto Premio", "30 punti - Pedicure con massaggio ai piedi", Color.PINK, "Pedicure: Pedicure classico, Pedicure con massaggi ai piedi, Pedicure con smalto gel");
        JPanel panel6 = createPanel("Sesto Premio", "20 punti - Trattamento alle mani con paraffina", Color.MAGENTA, "Trattamenti mani: Paraffinoterapia, Trattamento idratante, Massaggio alle mani");
        JPanel panel7 = createPanel("Settimo Premio", "10 punti - Sconto del 50% su qualsiasi servizio", Color.CYAN, "Sconto applicabile su qualsiasi servizio del centro estetico");
        JPanel panel8 = createPanel("Ottavo Premio", "5 punti - Prodotto di bellezza omaggio", Color.GRAY, "Ricevi un prodotto di bellezza omaggio con il tuo premio");
        
        // Creazione di uno JScrollPane
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(createPanelContainer( panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8));

        // Layout della finestra
        setLayout(new BorderLayout());

     // Aggiungi il pulsante per tornare indietro
        JButton backButton = new JButton("Indietro");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                main.setVisible(true);
                dispose(); // Chiude la finestra corrente (Premi)
            }
        });
        add(backButton, BorderLayout.NORTH);
       
        add(introScrollPane, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.CENTER);

 
        setVisible(true);
    }

    private JPanel createIntroPanel(String title, String description) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea(description);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createPanelContainer(JPanel... panels) {
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new GridLayout(8, 1));

        for (JPanel panel : panels) {
            containerPanel.add(panel);
        }

        return containerPanel;
    }

    private JPanel createPanel(String title, String description, Color color, String subSections) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.setLayout(new BorderLayout());
        panel.setBackground(color);

        JTextArea textArea = new JTextArea(description + "\n\n" + "Servizi disponibili:\n" + subSections);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Premi());
    }
}
