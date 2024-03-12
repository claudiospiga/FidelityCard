package fidelitycard;



import javax.swing.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mappa extends JFrame {
    public Mappa() {
        setTitle("Dove siamo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 700);

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
        
        // Inizializza JFXPanel per incorporare la mappa di Google Maps
        JFXPanel jfxPanel = new JFXPanel();
        getContentPane().add(jfxPanel, BorderLayout.CENTER);

        // Carica la mappa di Google Maps nell'interfaccia JavaFX
        Platform.runLater(() -> {
            WebView webView = new WebView();
            jfxPanel.setScene(new Scene(webView));
            webView.getEngine().load("https://shorturl.at/kIPU4");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Mappa mapApp = new Mappa();
            mapApp.setVisible(true);
        });
    }
}

