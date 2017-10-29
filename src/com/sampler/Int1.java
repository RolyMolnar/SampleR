package com.sampler;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Statement;

public class Int1 extends JFrame {
    BufferedImage img;
    Statement myStmt;
    JRadioButton var1, var2, var3, var4;

    public Int1(Statement myStmt) {
        this.setTitle("Intrebarea nr. 1");
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

        JLabel intreb1 = new JLabel("Intrebarea nr. 1 ", JLabel.CENTER);
        intreb1.setFont(new Font("Arial", Font.BOLD, 28));
        intreb1.setBorder(new EmptyBorder(50, 0, 0, 0));
        JLabel textIntrebare = new JLabel("", JLabel.CENTER);
        String txt = "<html><font style=\"font-family: 'Courier New'; font-size: 20 pt; text-align: 'center'; text-justify: inter-word;\"<p align='center';>Dacă duminica viitoare ar fi alegeri pentru funcţia de Preşedinte al României, </br>";
        txt = txt + "v-aţi prezenta la vot?";

        textIntrebare.setText(txt);

        JPanel varPanel = new JPanel();
        varPanel.setLayout(new BoxLayout(varPanel, BoxLayout.LINE_AXIS));
        ButtonGroup varGroup = new ButtonGroup();

        var1 = new JRadioButton("Cu siguranta da");
        var1.setPreferredSize(new Dimension(300, 40));
        var1.setFont(new Font("Arial", Font.PLAIN, 18));
        var1.setOpaque(false);
        var1.setContentAreaFilled(false);
        var1.setBorderPainted(false);

        var2 = new JRadioButton("Cred ca da");
        var2.setPreferredSize(new Dimension(300, 40));
        var2.setFont(new Font("Arial", Font.PLAIN, 18));
        var2.setOpaque(false);
        var2.setContentAreaFilled(false);
        var2.setBorderPainted(false);

        var3 = new JRadioButton("Cred ca nu");
        var3.setPreferredSize(new Dimension(300, 40));
        var3.setFont(new Font("Arial", Font.PLAIN, 18));
        var3.setOpaque(false);
        var3.setContentAreaFilled(false);
        var3.setBorderPainted(false);

        var4 = new JRadioButton("Cu siguranta nu");
        var4.setPreferredSize(new Dimension(300, 40));
        var4.setFont(new Font("Arial", Font.PLAIN, 18));
        var4.setOpaque(false);
        var4.setContentAreaFilled(false);
        var4.setBorderPainted(false);


        varGroup.add(var1);
        varGroup.add(var2);
        varGroup.add(var3);
        varGroup.add(var4);


        varPanel.add(var1);
        varPanel.add(var2);
        varPanel.add(var3);
        varPanel.add(var4);
        varPanel.setOpaque(false);

        varPanel.setAlignmentY(var1.CENTER_ALIGNMENT);

        mainLabel.add(textIntrebare, BorderLayout.CENTER);
        mainLabel.add(intreb1, BorderLayout.NORTH);
        mainLabel.add(varPanel, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }
}
