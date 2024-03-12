package fidelitycard;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class notifiche extends JFrame {
    private JTextArea notificaTextArea;

    public notifiche() {
        setTitle("Notifiche");
        setSize(400, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creazione del pannello per le notifiche
        JPanel notificaPanel = new JPanel();
        notificaPanel.setLayout(new BorderLayout());

        notificaTextArea = new JTextArea();
        notificaTextArea.setEditable(false);
        notificaPanel.add(notificaTextArea, BorderLayout.CENTER);

        //Abilita lo scrolling
        JScrollPane scrollPane = new JScrollPane(notificaTextArea);
        notificaPanel.add(scrollPane, BorderLayout.CENTER);
        
        
        JButton clearButton = new JButton("Elimina Notifiche");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearNotifications();
            }
        });
        notificaPanel.add(clearButton, BorderLayout.SOUTH);

        getContentPane().add(notificaPanel);

        // Aggiungere notifiche predefinite
        appendNotification("Hai ricevuto una richiesta di contatto da un nuovo cliente.");
        appendNotification("Hai ricevuto il 10% di sconto.");
        appendNotification("Hai ricevuto un appuntamento.");
        appendNotification("Hai ricevuto il 10% di sconto sul trattamento viso.");
        appendNotification("Hai ricevuto una prenotazione per un massaggio.");
        appendNotification("Nuova promozione: 20% di sconto su manicure e pedicure.");
        appendNotification("Hai esaurito il tuo stock di prodotti per la cura della pelle.");
        appendNotification("Hai un appuntamento con un nuovo fornitore di prodotti cosmetici domani.");
        appendNotification("Il cliente VIP Maria ha richiesto una consulenza personalizzata per domani.");
        appendNotification("Nuovo trattamento disponibile sullo store");
        appendNotification("Il tuo ordine è stato spedito.");
        appendNotification("Hai ricevuto un nuovo messaggio.");
        appendNotification("Ricorda: il tuo appuntamento è domani.");
        appendNotification("Il tuo pagamento è stato confermato.");
        
        // Creazione del bottone "Indietro"
        JButton backButton = new JButton("Indietro");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                main.setVisible(true);
                dispose(); // Chiude la finestra corrente (notifiche)
            }
        });

        // Aggiunta del bottone "Indietro" in alto
        add(backButton, BorderLayout.NORTH);

        // Visualizza la finestra
        setVisible(true);
    }

    private void appendNotification(String notification) {
        notificaTextArea.append(notification + "\n\n");
    }

    private void clearNotifications() {
        notificaTextArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new notifiche();
            }
        });
    }
}