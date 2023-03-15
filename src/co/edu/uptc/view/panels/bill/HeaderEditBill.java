package co.edu.uptc.view.panels.bill;

import co.edu.uptc.view.buttons.GrayButton;
import co.edu.uptc.view.panels.fathers.HeaderPanel;

import javax.swing.*;
import java.awt.*;

public class HeaderEditBill extends HeaderPanel {
    private JLabel numberBill;
    private JLabel numberBillText;
    private JLabel date;
    private JLabel clientName;
    private GrayButton buttonSelectClient;
    private JLabel clientNameActual;
    private JLabel clientNameActualText;
    private GridBagConstraints gbc;
    public HeaderEditBill() {
        super();
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.setLayout(new java.awt.GridBagLayout());
        gbc = new GridBagConstraints();
        initComponents();
    }

    private void generalGbc(int gridx, int gridy, int gridwidth, int gridheight) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
    }

    private void initComponents(){
        numberBill();
        numberBillText();
        clientName();
        buttonSelectClient();
        clientNameActual();
        clientNameActualText();
        date();
    }

    private void numberBill() {
        numberBill = new JLabel("N* Factura:", SwingConstants.CENTER);
        numberBill.setSize(191,42);
        numberBill.setOpaque(true);
        numberBill.setFont(new java.awt.Font("Cabin", 1, 24));
        numberBill.setBackground(new java.awt.Color(217, 217, 217));
        numberBill.setForeground(new java.awt.Color(0, 0, 0, 60));
        generalGbc(0, 0, 1, 1);
        gbc.insets = new Insets(0, 0, 0, 0);
        this.add(numberBill, gbc);
    }

    private void numberBillText() {
        numberBillText = new JLabel("Numero", SwingConstants.CENTER);
        numberBillText.setSize(166,42);
        numberBillText.setFont(new java.awt.Font("Cabin", 1, 24));
        numberBillText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        numberBillText.setBackground(new java.awt.Color(255, 255, 255));
        numberBillText.setForeground(new java.awt.Color(0, 0, 0, 60));
        generalGbc(1, 0, 1, 1);
        gbc.insets = new Insets(0, 0, 0, 0);
        this.add(numberBillText, gbc);
    }

    private void clientName() {
        clientName = new JLabel("Cliente:", SwingConstants.LEFT);
        clientName.setSize(191,42);
        clientName.setOpaque(true);
        clientName.setFont(new java.awt.Font("Cabin", 1, 24));
        clientName.setBackground(new java.awt.Color(217, 217, 217));
        clientName.setForeground(new java.awt.Color(0, 0, 0, 60));
        generalGbc(2, 0, 1, 1);
        gbc.insets = new Insets(0, 0, 0, 0);
        this.add(clientName, gbc);
    }

    private void buttonSelectClient() {
        buttonSelectClient = new GrayButton("Seleccionar");
        buttonSelectClient.setFont(new java.awt.Font("Cabin", 1, 24));
        generalGbc(3, 0, 1, 1);
        gbc.insets = new Insets(0, 0, 0, 0);
        this.add(buttonSelectClient, gbc);
    }

    private void date() {
        date = new JLabel("dd/mm/aaaa", SwingConstants.CENTER);
        date.setSize(232,42);
        date.setOpaque(true);
        date.setFont(new java.awt.Font("Cabin", 1, 24));
        date.setBackground(new java.awt.Color(217, 217, 217));
        date.setForeground(new java.awt.Color(0, 0, 0, 60));
        generalGbc(4, 0, 1, 1);
        gbc.insets = new Insets(0, 0, 0, 0);
        this.add(date, gbc);
    }

    private void clientNameActual() {
        clientNameActual = new JLabel("Cliente Actual:", SwingConstants.LEFT);
        clientNameActual.setSize(191,42);
        clientNameActual.setOpaque(true);
        clientNameActual.setFont(new java.awt.Font("Cabin", 1, 24));
        clientNameActual.setBackground(new java.awt.Color(217, 217, 217));
        clientNameActual.setForeground(new java.awt.Color(0, 0, 0, 60));
        generalGbc(2, 1, 1, 1);
        gbc.insets = new Insets(0, 0, 0, 0);
        this.add(clientNameActual, gbc);
    }

    private void clientNameActualText() {
        clientNameActualText = new JLabel("Cliente Actual", SwingConstants.LEFT);
        clientNameActualText.setFont(new java.awt.Font("Cabin", 1, 24));
        clientNameActualText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        clientNameActualText.setBackground(new java.awt.Color(255, 255, 255));
        clientNameActualText.setForeground(new java.awt.Color(0, 0, 0, 60));
        generalGbc(3, 1, 1, 1);
        gbc.insets = new Insets(0, 0, 0, 0);
        this.add(clientNameActualText, gbc);
    }
}
