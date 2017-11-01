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

public class Int10 extends JFrame {
    BufferedImage img;
    Statement myStmt;
    JRadioButton var1, var2, var3, var4, var5;
    JButton inainte, inapoi, exit;
    ButtonGroup varGroup;

    public Int10(Statement myStmt) {
        this.setTitle("SampleR - Intrebarea nr. 10");
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

        JLabel intreb1 = new JLabel("Intrebarea nr. 10 ", JLabel.CENTER);
        intreb1.setFont(new Font("Arial", Font.BOLD, 28));
        intreb1.setBorder(new EmptyBorder(50, 0, 150, 0));
        JLabel textIntrebare = new JLabel("", JLabel.CENTER);
        String txt = "<html><font style=\"font-family: 'Courier New'; font-size: 20 pt; text-align: 'center'; text-justify: inter-word;\"<p align='center';>Indiferent dacă v-aţi prezenta sau nu la vot,  </br>";
        txt = txt + "intenţia dvs de vot spre care dintre posibilii candidaţi pentru Primărie s-ar îndrepta?";

        textIntrebare.setText(txt);
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());

        JPanel varPanel = new JPanel();
        varPanel.setLayout(new BoxLayout(varPanel, BoxLayout.PAGE_AXIS));
        varGroup = new ButtonGroup();

        var1 = new JRadioButton("Avram Costel");
        var1.setPreferredSize(new Dimension(300, 40));
        var1.setFont(new Font("Arial", Font.PLAIN, 18));
        var1.setOpaque(false);
        var1.setContentAreaFilled(false);
        var1.setBorderPainted(false);


        var2 = new JRadioButton("Iacob Ridzi Tiberiu");
        var2.setPreferredSize(new Dimension(300, 40));
        var2.setFont(new Font("Arial", Font.PLAIN, 18));
        var2.setOpaque(false);
        var2.setContentAreaFilled(false);
        var2.setBorderPainted(false);

        var3 = new JRadioButton("Rus Ioan");
        var3.setPreferredSize(new Dimension(300, 40));
        var3.setFont(new Font("Arial", Font.PLAIN, 18));
        var3.setOpaque(false);
        var3.setContentAreaFilled(false);
        var3.setBorderPainted(false);

        var4 = new JRadioButton("Vochitoiu Haralambie");
        var4.setPreferredSize(new Dimension(300, 40));
        var4.setFont(new Font("Arial", Font.PLAIN, 18));
        var4.setOpaque(false);
        var4.setContentAreaFilled(false);
        var4.setBorderPainted(false);

        var5 = new JRadioButton("Altul");
        var5.setPreferredSize(new Dimension(300, 40));
        var5.setFont(new Font("Arial", Font.PLAIN, 18));
        var5.setOpaque(false);
        var5.setContentAreaFilled(false);
        var5.setBorderPainted(false);


        varGroup.add(var1);
        varGroup.add(var2);
        varGroup.add(var3);
        varGroup.add(var4);
        varGroup.add(var5);


        varPanel.add(var1);
        varPanel.add(var2);
        varPanel.add(var3);
        varPanel.add(var4);
        varPanel.add(var5);
        varPanel.setOpaque(false);


        JPanel centrare = new JPanel(new GridBagLayout());
        centrare.add(varPanel, new GridBagConstraints());
        centrare.setOpaque(false);

        varPanel.setAlignmentX(var1.RIGHT_ALIGNMENT);
        container.setOpaque(false);

        container.add(textIntrebare, BorderLayout.NORTH);
        container.add(centrare, BorderLayout.CENTER);
        mainLabel.add(container, BorderLayout.CENTER);
        mainLabel.add(intreb1, BorderLayout.NORTH);

        // Creaza buttonPanel pentru butoane
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        // Butonul "EXIT"
        exit = new JButton("EXIT");
        exit.setPreferredSize(new Dimension(150, 40));
        exit.setFont(new Font("Arial", Font.PLAIN, 18));
        exit.setBackground(Color.red);
        // Butonul "REGISTER"
        inainte = new JButton("Sumar");
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
                new Sumar(myStmt);
                dispose();

            }// Sursa eventului este butonul "LIST"
            else if (e.getSource() == inapoi) {
                // Deschide fereastra List
                // Inchide fereastra Welcome
                new Int9(myStmt);
                dispose();
            }
        }
    }

}
