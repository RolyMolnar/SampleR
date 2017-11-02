package com.sampler;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Statement;
import java.util.Vector;

public class Sumar extends JFrame {
    BufferedImage img;
    Statement myStmt;
    JButton inainte, inapoi, exit;
    Vector data, row, columnNames;


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

        JPanel listPanel = new JPanel();
        listPanel.setOpaque(false);
        columnNames = new Vector();
        columnNames.add("Intrebare");
        columnNames.add("Raspuns");

        data = new Vector();
        row = new Vector();
        row.add("Intrebarea nr. 1");
        row.add(Int1.intre1);
        data.add(row);
        row = new Vector();
        row.add("Intrebarea nr.2");
        row.add(Int2.intre2);
        data.add(row);
        row = new Vector();
        row.add("Intrebarea nr.3");
        row.add(Int3.intre3);
        data.add(row);
        row = new Vector();
        row.add("Intrebarea nr.4");
        row.add(Int4.intre4);
        data.add(row);
        row = new Vector();
        row.add("Intrebarea nr.5");
        row.add(Int5.intre5);
        data.add(row);
        row = new Vector();
        row.add("Intrebarea nr.6.1");
        row.add(Int6_1.intre6_1);
        data.add(row);
        row = new Vector();
        row.add("Intrebarea nr.6.2");
        row.add(Int6_2.intre6_2);
        data.add(row);
        row = new Vector();
        row.add("Intrebarea nr.6.3");
        row.add(Int6_3.intre6_3);
        data.add(row);
        row = new Vector();
        row.add("Intrebarea nr.7");
        row.add(Int7.intre7);
        data.add(row);
        row = new Vector();
        row.add("Intrebarea nr.8");
        row.add(Int8.intre8);
        data.add(row);
        row = new Vector();
        row.add("Intrebarea nr.9");
        row.add(Int9.intre9);
        data.add(row);
        row = new Vector();
        row.add("Intrebarea nr.10");
        row.add(Int10.intre10);
        data.add(row);


        JTable jTable = new JTable(data, columnNames);
        jTable.setRowHeight(jTable.getRowHeight() + 10);
        jTable.setFont(new Font("Arial", Font.PLAIN, 18));
        JTableHeader header = jTable.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 18));
        JScrollPane scrollPane = new JScrollPane(jTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setOpaque(false);
        listPanel.add(scrollPane);
        listPanel.setOpaque(false);
        mainLabel.add(listPanel, BorderLayout.CENTER);

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
