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

public class Int2 extends JFrame {
    BufferedImage img;
    Statement myStmt;
    JRadioButton var1, var2, var3, var4, var5, var6, var7;
    JButton inainte, inapoi, exit;
    ButtonGroup varGroup;

    public Int2(Statement myStmt) {
        this.setTitle("SampleR - Intrebarea nr. 2");
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

        JLabel intreb1 = new JLabel("Intrebarea nr. 2 ", JLabel.CENTER);
        intreb1.setFont(new Font("Arial", Font.BOLD, 28));
        intreb1.setBorder(new EmptyBorder(50, 0, 150, 0));
        JLabel textIntrebare = new JLabel("", JLabel.CENTER);
        String txt = "<html><font style=\"font-family: 'Courier New'; font-size: 20 pt; text-align: 'center'; text-justify: inter-word;\"<p align='center';>Indiferent dacă v-aţi prezenta sau nu la vot, </br>";
        txt = txt + "intenţia dvs de vot spre care dintre posibilii candidaţii pentru Preşedinte s-ar îndrepta? ";

        textIntrebare.setText(txt);
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());

        JPanel varPanel = new JPanel();
        varPanel.setLayout(new BoxLayout(varPanel, BoxLayout.PAGE_AXIS));
        varGroup = new ButtonGroup();

        var1 = new JRadioButton("Antonescu Crin");
        var1.setPreferredSize(new Dimension(300, 40));
        var1.setFont(new Font("Arial", Font.PLAIN, 18));
        var1.setOpaque(false);
        var1.setContentAreaFilled(false);
        var1.setBorderPainted(false);


        var2 = new JRadioButton("Diaconescu Dan");
        var2.setPreferredSize(new Dimension(300, 40));
        var2.setFont(new Font("Arial", Font.PLAIN, 18));
        var2.setOpaque(false);
        var2.setContentAreaFilled(false);
        var2.setBorderPainted(false);

        var3 = new JRadioButton("Isarescu Mugur");
        var3.setPreferredSize(new Dimension(300, 40));
        var3.setFont(new Font("Arial", Font.PLAIN, 18));
        var3.setOpaque(false);
        var3.setContentAreaFilled(false);
        var3.setBorderPainted(false);

        var4 = new JRadioButton("Ponta Victor");
        var4.setPreferredSize(new Dimension(300, 40));
        var4.setFont(new Font("Arial", Font.PLAIN, 18));
        var4.setOpaque(false);
        var4.setContentAreaFilled(false);
        var4.setBorderPainted(false);

        var5 = new JRadioButton("Ungureanu Mihai Razvan");
        var5.setPreferredSize(new Dimension(300, 40));
        var5.setFont(new Font("Arial", Font.PLAIN, 18));
        var5.setOpaque(false);
        var5.setContentAreaFilled(false);
        var5.setBorderPainted(false);

        var6 = new JRadioButton("Vadim Tudor Corneliu");
        var6.setPreferredSize(new Dimension(300, 40));
        var6.setFont(new Font("Arial", Font.PLAIN, 18));
        var6.setOpaque(false);
        var6.setContentAreaFilled(false);
        var6.setBorderPainted(false);

        var7 = new JRadioButton("Altul");
        var7.setPreferredSize(new Dimension(300, 40));
        var7.setFont(new Font("Arial", Font.PLAIN, 18));
        var7.setOpaque(false);
        var7.setContentAreaFilled(false);
        var7.setBorderPainted(false);

        var1.setActionCommand("1");
        var2.setActionCommand("2");
        var3.setActionCommand("3");
        var4.setActionCommand("4");
        var5.setActionCommand("5");
        var6.setActionCommand("6");
        var7.setActionCommand("7");

        varGroup.add(var1);
        varGroup.add(var2);
        varGroup.add(var3);
        varGroup.add(var4);
        varGroup.add(var5);
        varGroup.add(var6);
        varGroup.add(var7);


        varPanel.add(var1);
        varPanel.add(var2);
        varPanel.add(var3);
        varPanel.add(var4);
        varPanel.add(var5);
        varPanel.add(var6);
        varPanel.add(var7);
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
                String intre2 = varGroup.getSelection().getActionCommand();
                System.out.println(intre2);
                if (intre2 != null) {
                    new Int3(myStmt);
                    dispose();
                }

            }// Sursa eventului este butonul "LIST"
            else if (e.getSource() == inapoi) {
                // Deschide fereastra List
                // Inchide fereastra Welcome
                new Int1(myStmt);
                dispose();
            }
        }
    }

}
