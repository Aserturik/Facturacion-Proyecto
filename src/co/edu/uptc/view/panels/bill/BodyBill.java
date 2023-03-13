package co.edu.uptc.view.panels.bill;

import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.panels.bill.subpanels.PreviewBill;
import co.edu.uptc.view.panels.bill.subpanels.ShowAllBills;
import co.edu.uptc.view.panels.fathers.BodyPanel;

import javax.swing.*;
import java.awt.*;

public class BodyBill extends BodyPanel {
    private PreviewBill previewBill;
    private ShowAllBills showAllBills;
    private GridBagConstraints gbc;
    public BodyBill(EventsView eventsView) {
        super();
        this.setEventsView(eventsView);
        showAllBills = new ShowAllBills(eventsView);
        previewBill = new PreviewBill(eventsView);
        this.setBackground(new Color(255, 255, 255));
        gbc = new GridBagConstraints();
        panelUp();
        showAllBills();
        previewBill();
    }

    public void panelUp(){
        JPanel panelUp = new JPanel();
        panelUp.setBackground(new Color(255, 255, 255));
        panelUp.setSize(1133, 40);
        panelUp.setMinimumSize(new Dimension(1133, 40));
        panelUp.setMaximumSize(new Dimension(1133, 40));
        panelUp.setPreferredSize(new Dimension(1133, 40));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        this.add(panelUp, gbc);
    }

    private void showAllBills() {
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(40, 52, 0, 73);
        this.add(showAllBills, gbc);
    }
    private void previewBill() {
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(40, 82, 0, 64);
        this.add(previewBill, gbc);
    }
}
