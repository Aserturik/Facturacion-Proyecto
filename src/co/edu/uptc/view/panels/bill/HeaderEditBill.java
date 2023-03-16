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

    private JLabel getFormatLabel(JLabel label,int whidth, int heigth){
        label.setSize(whidth,heigth);
        label.setPreferredSize(new Dimension(whidth,heigth));
        label.setMinimumSize(new Dimension(whidth,heigth));
        label.setMaximumSize(new Dimension(whidth,heigth));
        label.setOpaque(true);
        label.setFont(new java.awt.Font("Cabin", 1, 24));
        label.setBackground(new java.awt.Color(217, 217, 217));
        label.setForeground(new java.awt.Color(0, 0, 0, 60));
        return label;
    }

    private JLabel getFormatTextLabel(JLabel label,int whidth, int heigth){
        label.setSize(whidth,heigth);
        label.setPreferredSize(new Dimension(whidth,heigth));
        label.setMinimumSize(new Dimension(whidth,heigth));
        label.setMaximumSize(new Dimension(whidth,heigth));
        label.setOpaque(true);
        numberBillText.setFont(new java.awt.Font("Cabin", 1, 24));
        numberBillText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        numberBillText.setBackground(new java.awt.Color(255, 255, 255));
        numberBillText.setForeground(new java.awt.Color(0, 0, 0, 60));
        return label;
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
        numberBill = getFormatLabel(numberBill,191 ,42);
        generalGbc(0, 0, 1, 1);
        gbc.insets = new Insets(54, 40, 0, 0);
        this.add(numberBill, gbc);
    }

    private void numberBillText() {
        numberBillText = new JLabel("Numero", SwingConstants.CENTER);
        numberBillText = getFormatTextLabel(numberBillText,166,42);
        generalGbc(1, 0, 1, 1);
        gbc.insets = new Insets(54, 0, 0, 40);
        this.add(numberBillText, gbc);
    }

    private void clientName() {
        clientName = new JLabel("Cliente:", SwingConstants.LEFT);
        clientName = getFormatLabel(clientName,191,42);
        generalGbc(2, 0, 1, 1);
        gbc.insets = new Insets(54, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(clientName, gbc);
    }

    private void buttonSelectClient() {
        buttonSelectClient = new GrayButton("Seleccionar");
        buttonSelectClient.setFont(new java.awt.Font("Cabin", 1, 24));
        generalGbc(3, 0, 1, 1);
        gbc.insets = new Insets(54, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(buttonSelectClient, gbc);
    }

    private void date() {
        date = new JLabel("dd/mm/aaaa", SwingConstants.CENTER);
        date = getFormatLabel(date,232,42);
        generalGbc(4, 0, 1, 1);
        gbc.insets = new Insets(54, 22, 0, 0);
        this.add(date, gbc);
    }

    private void clientNameActual() {
        clientNameActual = new JLabel("Cliente Actual:", SwingConstants.LEFT);
        clientNameActual = getFormatLabel(clientNameActual,154,28);
        clientNameActual.setFont(new java.awt.Font("Cabin", 1, 20));
        generalGbc(2, 1, 1, 1);
        gbc.insets = new Insets(7, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(clientNameActual, gbc);
    }

    private void clientNameActualText() {
        clientNameActualText = new JLabel("Cliente Actual", SwingConstants.LEFT);
        clientNameActualText = getFormatTextLabel(clientNameActualText,204,28);
        clientNameActualText.setFont(new java.awt.Font("Cabin", 1, 20));
        generalGbc(3, 1, 1, 1);
        gbc.insets = new Insets(7, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(clientNameActualText, gbc);
    }
}
