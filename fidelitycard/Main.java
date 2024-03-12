package fidelitycard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import java.io.ByteArrayOutputStream;

public class Main extends JFrame {
    public Main() {
        setTitle("Smartphone Fidelity Card");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 700));

        JPanel mainPanel = new JPanel(new GridBagLayout());
        Color blueColor2 = new Color(37, 99, 235);
        mainPanel.setBackground(blueColor2);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 10, 0); 

        
        JPanel titleAndBarcodePanel = new JPanel(new GridBagLayout());
        titleAndBarcodePanel.setBackground(Color.WHITE); //
        mainPanel.add(titleAndBarcodePanel, gbc);

        
        JLabel titleLabel = new JLabel("CENTRO ESTETICO BITCAMP");
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleAndBarcodePanel.add(titleLabel);

       
        gbc.gridy = 1;
        gbc.weighty = 0.1;
        titleAndBarcodePanel.add(Box.createVerticalStrut(10), gbc);

        
        
        JPanel barcodePanel = new JPanel(new GridBagLayout());
        Color blueColor = new Color(37, 99, 235);
        barcodePanel.setBackground(blueColor);
        gbc.gridy = 2;
        gbc.insets = new Insets(20, 20, 20, 20); 
        gbc.fill = GridBagConstraints.BOTH; 
        gbc.weighty = 1.0; 
        mainPanel.add(barcodePanel, gbc);
        
        JLabel barcodeLabel = generateBarcodeLabel("123456789");
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        titleAndBarcodePanel.add(barcodeLabel, gbc);

        
        JLabel reminderLabel = new JLabel("Hai dimenticato la card? Mostra questo codice alla cassa!");
        reminderLabel.setForeground(Color.BLACK);
        gbc.gridy = 3;
        titleAndBarcodePanel.add(reminderLabel, gbc);

        
        JPanel spacerPanel = new JPanel();
        gbc.gridy = 2; 
        gbc.insets = new Insets(20, 0, 20, 0); 
        mainPanel.add(spacerPanel, gbc);

        
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(blueColor);
        gbc.gridy = 3; 
        mainPanel.add(buttonPanel, gbc);

        JButton premiButton = new JButton(new ImageIcon(System.getProperty("user.home") + "/Desktop/img/3.jpeg"));
        premiButton.setPreferredSize(new Dimension(150, 100));
        premiButton.setBackground(Color.YELLOW);
        premiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Premi premi = new Premi();
                premi.setVisible(true);
                dispose();
            }
        });
        
        
        JLabel premiLabel = new JLabel("Premi");
        premiLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel premiPanel = new JPanel(new BorderLayout());
        premiPanel.add(premiButton, BorderLayout.CENTER);
        premiPanel.add(premiLabel, BorderLayout.SOUTH);

        buttonPanel.add(premiPanel);

        JButton doveSiamoButton = new JButton(new ImageIcon(System.getProperty("user.home") + "/Desktop/img/6.png"));
        doveSiamoButton.setPreferredSize(new Dimension(150, 100));
        doveSiamoButton.setBackground(Color.GREEN);
        doveSiamoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Mappa mappa = new Mappa();
                mappa.setVisible(true);
                dispose(); 
            }
        });
        
        JLabel doveSiamoLabel = new JLabel("Dove Siamo");
        doveSiamoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel doveSiamoPanel = new JPanel(new BorderLayout());
        doveSiamoPanel.add(doveSiamoButton, BorderLayout.CENTER);
        doveSiamoPanel.add(doveSiamoLabel, BorderLayout.SOUTH);

        buttonPanel.add(doveSiamoPanel);

        JButton volantinoButton = new JButton(new ImageIcon(System.getProperty("user.home") + "/Desktop/img/8.png"));
        volantinoButton.setPreferredSize(new Dimension(150, 100));
        Color volantinoColor = new Color(0xF8, 0x2C, 0xAA);
        volantinoButton.setBackground(volantinoColor);
        volantinoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Volantino volantino = new Volantino();
                volantino.setVisible(true);
                dispose(); 
            }
        });
        
        JLabel volantinoLabel = new JLabel("Volantino");
        volantinoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel volantinoPanel = new JPanel(new BorderLayout());
        volantinoPanel.add(volantinoButton, BorderLayout.CENTER);
        volantinoPanel.add(volantinoLabel, BorderLayout.SOUTH);

        buttonPanel.add(volantinoPanel);

        JButton notificheButton = new JButton(new ImageIcon(System.getProperty("user.home") + "/Desktop/img/12.jpg"));
        notificheButton.setPreferredSize(new Dimension(150, 100));
        notificheButton.setBackground(Color.ORANGE);
        notificheButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                notifiche Notifiche = new notifiche();
                Notifiche.setVisible(true);
                dispose();
            }
        });

        JLabel notificheLabel = new JLabel("Notifiche");
        notificheLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel notifichePanel = new JPanel(new BorderLayout());
        notifichePanel.add(notificheButton, BorderLayout.CENTER);
        notifichePanel.add(notificheLabel, BorderLayout.SOUTH);

        buttonPanel.add(notifichePanel);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }


    private JLabel generateBarcodeLabel(String barcodeText) {
        try {
            Code128Bean barcodeBean = new Code128Bean();
            final int dpi = 150;
            barcodeBean.setModuleWidth(0.3);
            barcodeBean.doQuietZone(false);

       
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            BitmapCanvasProvider canvasProvider = new BitmapCanvasProvider(
                    outputStream, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

            
            barcodeBean.generateBarcode(canvasProvider, barcodeText);
            canvasProvider.finish();

            
            byte[] barcodeImage = outputStream.toByteArray();

            
            ImageIcon icon = new ImageIcon(barcodeImage);
            return new JLabel(icon);
        } catch (Exception e) {
            e.printStackTrace();
            return new JLabel("Error generating barcode");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            main.setVisible(true);
        });
    }
}
