package co.edu.uptc.view.panels.bill.subpanels;

import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.buttons.GrayButton;

import javax.swing.*;
import java.awt.*;

public class DescriptionEditPanel extends JPanel {
    private EventsView eventsView;
    private JTextArea descriptionArea;
    private JLabel description;
    private GrayButton delete, saveAndExit;

    public DescriptionEditPanel(){
        this.setBackground(new Color(222,111,33));
        this.setSize(296,451);
        this.setMinimumSize(new java.awt.Dimension(296, 451));
        this.setMaximumSize(new java.awt.Dimension(296, 451));
        this.setPreferredSize(new java.awt.Dimension(296, 451));
    }
}
