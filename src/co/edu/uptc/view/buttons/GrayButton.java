package co.edu.uptc.view.buttons;

import javax.swing.*;
import java.awt.*;

public class GrayButton extends JButton {
    public GrayButton(String text) {
        super(text);
        this.setBackground(new java.awt.Color(217, 217, 217));
        this.setForeground(new java.awt.Color(0,0,0));
        this.setMargin(new java.awt.Insets(3, 3, 3, 3));
        this.setFont(new Font("Arial", Font.PLAIN, 14));
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public void setBig(){
        this.setFont(new Font("Cabin", Font.PLAIN, 24));
        this.setSize(236,109);
        this.setMinimumSize(new java.awt.Dimension(236, 109));
        this.setMaximumSize(new java.awt.Dimension(236, 109));
        this.setPreferredSize(new java.awt.Dimension(236, 109));
    }
}
