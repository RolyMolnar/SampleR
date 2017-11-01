package com.sampler;

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

public class Sumar extends JFrame {
    BufferedImage img;
    Statement myStmt;
    JRadioButton var1, var2, var3, var4;
    JButton inainte, inapoi, exit;


    public Sumar(Statement myStmt) {
        this.setTitle("SampleR - Sumar");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        try {
            img = ImageIO.read(new File("C:\\Users\\molro\\Desktop\\bigwave.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageIcon imageIcon = new ImageIcon(img);
        JLabel mainLabel = new JLabel();
        mainLabel.setLayout(new BorderLayout());


        mainLabel.setIcon(imageIcon);
        this.setContentPane(mainLabel);
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);


        // Creaza buttonPanel pentru butoane
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        // Butonul "EXIT"
        exit = new JButton("EXIT");
        exit.setPreferredSize(new Dimension(150, 40));
        exit.setFont(new Font("Arial", Font.PLAIN, 18));
        exit.setBackground(Color.red);
        // Butonul "REGISTER"
        inainte = new JButton("INAINTE");
        inainte.setPreferredSize(new Dimension(150, 40));
        inainte.setFont(new Font("Arial", Font.PLAIN, 18));
        inainte.setBackground(Color.yellow);

        inapoi = new JButton("INAPOI");
        inapoi.setPreferredSize(new Dimension(150, 40));
        inapoi.setFont(new Font("Arial", Font.PLAIN, 18));
        inapoi.setBackground(new Color(0, 128, 255));
        // Face ca butoanele sa poata fi receptive la events
        ListenForButton listenForButton = new ListenForButton();
        exit.addActionListener(listenForButton);
        inainte.addActionListener(listenForButton);
        inapoi.addActionListener(listenForButton);
        // Adauga butoanele la buttonPanel
        buttonPanel.add(exit);
        buttonPanel.add(inainte);
        buttonPanel.add(inapoi);
        buttonPanel.setOpaque(false);
        // adauga buttonPanel la mainPanel
        mainLabel.add(buttonPanel, BorderLayout.SOUTH);
        // Adauga mainPanel la Frame


        this.pack();
        this.setVisible(true);
    }

    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Sursa eventului este butonul "EXIT"
            if (e.getSource() == exit) {
                // Inchide fereastra Welcome
                System.exit(0);

            } else if (e.getSource() == inainte) {
                new Int2(myStmt);
                dispose();

            }// Sursa eventului este butonul "LIST"
            else if (e.getSource() == inapoi) {
                // Deschide fereastra List
                // Inchide fereastra Welcome
                new Prezentare(myStmt);
                dispose();
            }
        }
    }

}
