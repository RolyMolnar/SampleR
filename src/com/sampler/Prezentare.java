package com.sampler;
/* Prima fereastra - Welcome */

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Statement;

public class Prezentare extends JFrame {
    JButton exitButton, incepeButton, rezultateButton;
    BufferedImage img;
    Statement myStmt;

    public Prezentare(Statement myStmt) {
        this.myStmt = myStmt;
        // Titlul ferestrei
        this.setTitle("SampleR");
        // Modalitatea de inchidere a ferestrei
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Marimea ferestrei
        this.setSize(700, 400);
        // Pozitioneaza fereastra in centrul ecranului
        this.setLocationRelativeTo(null);
        // Creaza mainPanel - panel principal care include toate elementele


        try {
            img = ImageIO.read(new File("C:\\Users\\molro\\Desktop\\bigwave.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Modifica dimensiunile la imaginea de background
        ImageIcon imageIcon = new ImageIcon(img);
        JLabel mainLabel = new JLabel();
        mainLabel.setLayout(new BorderLayout());
        // Adauga imaginea de fond la mainLabel
        mainLabel.setIcon(imageIcon);
        this.setContentPane(mainLabel);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);

        //JPanel mainPanel = new JPanel();
        // Textul din fereastra principala
        JLabel welcomeLabel = new JLabel("Barometru de opinie publica", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 28));
        welcomeLabel.setBorder(new EmptyBorder(50, 0, 0, 0));

        JLabel instructiuni = new JLabel("", JLabel.CENTER);

        String txt = "<html><h1 align='center'; padding: 30;>Instructiuni</h1>";
        txt = txt + "</br>";

        txt = txt + "<font style=\"font-family: 'Courier New'; font-size: 18 pt; text-align: 'center'; text-justify: inter-word;\">";
        txt = txt + "<p align='center'; padding:10;>Prin acest sondaj de opinie am dori sa cunoastem parerile oamenilor<br/>";
        txt = txt + "in legatura cu situatia politica a Mun. Petrosani.<br/>";
        txt = txt + "Daca sunteti de acord sa ne raspundeti la intrebari, speram sa nu va rapim mai mult de 15 de minute. <br/>";
        txt = txt + "Datele obtinute sunt confidentiale, ele fiind necesare doar pentru a fi prelucrate statistic.<p/>";
        instructiuni.setText(txt);


        JPanel buttonPanel = new JPanel();
        // Precizeaza layout pentru buttonPanel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        // Butonul exit
        exitButton = new JButton("EXIT");
        exitButton.setPreferredSize(new Dimension(150, 40));
        exitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        exitButton.setBackground(Color.red);
        //Butonul register
        incepeButton = new JButton("INCEPE");
        incepeButton.setPreferredSize(new Dimension(150, 40));
        incepeButton.setFont(new Font("Arial", Font.PLAIN, 18));
        incepeButton.setBackground(Color.yellow);
        // Butonul list
        rezultateButton = new JButton("REZULTATE");
        rezultateButton.setPreferredSize(new Dimension(150, 40));
        rezultateButton.setFont(new Font("Arial", Font.PLAIN, 18));
        rezultateButton.setBackground(new Color(0, 128, 255));
        // Face ca butoanele sa poata fi receptive la events
        ListenForButton listenForButton = new ListenForButton();
        exitButton.addActionListener(listenForButton);
        incepeButton.addActionListener(listenForButton);
        rezultateButton.addActionListener(listenForButton);
        // Adauga butoanele la buttonPanel
        buttonPanel.add(exitButton);
        buttonPanel.add(incepeButton);
        buttonPanel.add(rezultateButton);
        buttonPanel.setOpaque(false);
        // Adauga buttonPanel la mainPanel
        mainLabel.add(buttonPanel, BorderLayout.SOUTH);
        // Adauga textul la mainPAnel
        mainLabel.add(welcomeLabel, BorderLayout.NORTH);
        mainLabel.add(instructiuni, BorderLayout.CENTER);
        // Adauga mainPanel la Frame
        //this.add(mainLabel);
        // Face fereastra vizibila
        this.pack();
        this.setVisible(true);
    }

    // Pentru events
    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Sursa eventului este butonul "EXIT"
            if (e.getSource() == exitButton) {
                // Inchide fereastra Welcome
                System.exit(0);

            } else if (e.getSource() == incepeButton) {
                new Int1(myStmt);
                dispose();

            }// Sursa eventului este butonul "LIST"
            else if (e.getSource() == rezultateButton) {
                // Deschide fereastra List
                // Inchide fereastra Welcome
                dispose();
            }
        }
    }
}
