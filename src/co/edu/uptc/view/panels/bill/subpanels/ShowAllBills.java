package co.edu.uptc.view.panels.bill.subpanels;

import co.edu.uptc.view.buttons.GrayButton;
import co.edu.uptc.view.textfield.TextFieldGray;

import javax.swing.*;

public class ShowAllBills extends JPanel {
    private String title = "Todas las Facturas";
    private GrayButton searchButton,addButton;
    private TextFieldGray searchTextField;
    public ShowAllBills() {
        this.setBackground(new java.awt.Color(0, 0, 255));
        this.setSize(617,349);
        this.setMinimumSize(new java.awt.Dimension(308, 349));
        this.setMaximumSize(new java.awt.Dimension(308, 349));
        this.setPreferredSize(new java.awt.Dimension(308, 349));

        initComponents();
    }

    public void initComponents(){

    }

    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        java.awt.Graphics2D gg = (java.awt.Graphics2D) g;
        title(gg);
    }

    public void title(java.awt.Graphics2D gg) {
        gg.setColor(new java.awt.Color(217, 217, 217));
        gg.fillRect(0, 0, 308, 37);
        gg.setColor(new java.awt.Color(0, 0, 0));
        gg.setFont(new java.awt.Font("Cabin", java.awt.Font.BOLD, 24));
        gg.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gg.drawString(title, 59, 29);
    }
}
