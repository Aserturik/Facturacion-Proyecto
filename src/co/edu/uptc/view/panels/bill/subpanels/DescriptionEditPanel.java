package co.edu.uptc.view.panels.bill.subpanels;

import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.buttons.GrayButton;

import javax.swing.*;
import java.awt.*;

public class DescriptionEditPanel extends JPanel {
    private EventsView eventsView;
    private JLabel description;
    private JTextArea descriptionArea;
    private GrayButton delete, saveAndExit;
    private GridBagConstraints gbc;

    public DescriptionEditPanel(EventsView eventsView) {
        this.setEventsView(eventsView);
        this.setBackground(new Color(255, 255, 255));
        this.setSize(296,451);
        this.setMinimumSize(new java.awt.Dimension(296, 451));
        this.setMaximumSize(new java.awt.Dimension(296, 451));
        this.setPreferredSize(new java.awt.Dimension(296, 451));
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 0, 0, 50);
        initComponents();
        listeners();
    }

    private void initComponents(){
        description = new JLabel("Descripción");
        descriptionArea = new JTextArea();
        delete = new GrayButton("ELIMINAR FACTURA");
        saveAndExit = new GrayButton("GUARDAR Y SALIR");
        descriptionLabel();
        descriptionAreaText();
        deleteButton();
        saveAndExitButton();
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
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    private void descriptionLabel(){
        description = getFormatLabel(description, 236, 54);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.CENTER;
        this.add(description,gbc);
    }

    private void descriptionAreaText(){
        descriptionArea.setBackground(new Color(255, 255, 255));
        descriptionArea.setForeground(new Color(0, 0, 0));
        descriptionArea.setFont(new Font("Cabin", 0, 18));
        descriptionArea.setSize(236, 200);
        descriptionArea.setMinimumSize(new java.awt.Dimension(236, 200));
        descriptionArea.setMaximumSize(new java.awt.Dimension(236, 200));
        descriptionArea.setPreferredSize(new java.awt.Dimension(236, 200));
        descriptionArea.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 1));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.CENTER;
        this.add(descriptionArea,gbc);
    }

    private void deleteButton(){
        delete.setSize(232, 54);
        delete.setMinimumSize(new java.awt.Dimension(232, 54));
        delete.setMaximumSize(new java.awt.Dimension(232, 54));
        delete.setPreferredSize(new java.awt.Dimension(232, 54));

        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(delete, gbc);
    }

    private void saveAndExitButton(){
        saveAndExit.setSize(232, 54);
        saveAndExit.setMinimumSize(new java.awt.Dimension(232, 54));
        saveAndExit.setMaximumSize(new java.awt.Dimension(232, 54));
        saveAndExit.setPreferredSize(new java.awt.Dimension(232, 54));

        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(saveAndExit, gbc);
    }

    // Listeners

    private void listeners(){
        delete.addActionListener(e -> optionPaneDelete());
        saveAndExit.addActionListener(e -> eventsView.saveBillAndExit());
    }

    private void optionPaneDelete(){
        int option = JOptionPane.showConfirmDialog(null, "¿Eliminar la factura?", "Eliminar factura", JOptionPane.YES_NO_OPTION);
        if (option == 0) {
            deleteBill();
        }
    }

    private void deleteBill(){
        // TODO: Eliminar factura
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }
}
