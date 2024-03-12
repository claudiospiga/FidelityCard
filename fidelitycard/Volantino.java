package fidelitycard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Volantino extends JFrame {

    public Volantino() {
        // Impostazione della finestra
        setTitle("Volantino"); // Imposta il titolo della finestra
        setSize(400, 700); // Imposta le dimensioni della finestra (larghezza x altezza)
        setLocationRelativeTo(null); // Posiziona la finestra al centro dello schermo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Imposta l'operazione di default quando la finestra è chiusa

        // Creazione del bottone "Indietro"
        JButton backButton = new JButton("Indietro");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                main.setVisible(true);
                dispose(); // Chiude la finestra corrente (notifiche)
            }
        });

        // Aggiungi il pulsante "Indietro" al pannello superiore
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(backButton);
        getContentPane().add(topPanel, BorderLayout.NORTH);

        // Carica l'immagine
        ImageIcon icon = new ImageIcon(System.getProperty("user.home") + "/Desktop/img/2.jpg");

        // Crea un JLabel per visualizzare l'immagine
        JLabel imageLabel = new JLabel(icon);

        // Crea un pannello per contenere l'immagine
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(imageLabel, BorderLayout.CENTER);

        // Crea uno JScrollPane e aggiunge il pannello ad esso
        JScrollPane scrollPane = new JScrollPane(panel);
        getContentPane().add(scrollPane);

        setVisible(true); // Rende la finestra visibile
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Volantino::new); // Avvia l'applicazione sulla thread dell'interfaccia grafica
    }
}
