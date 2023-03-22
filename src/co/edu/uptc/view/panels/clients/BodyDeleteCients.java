package co.edu.uptc.view.panels.clients;

import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.MyFrame;
import co.edu.uptc.view.panels.fathers.BodyPanel;

import javax.swing.*;
import java.awt.*;

public class BodyDeleteCients extends BodyPanel {
    private PanelClients panelClients;
    GridBagConstraints gbc;
    private JTextArea textNoFactura,yesFactura;
    private JLabel labelNoFactura,labelYesFactura;

    public BodyDeleteCients(EventsView eventsView, PanelClients panelClients) {
        this.panelClients = panelClients;
        this.setEventsView(eventsView);
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        initComponents();
    }

    private void initComponents(){
        labelNoFactura = new JLabel("Clientes sin factura              ");
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(labelNoFactura,gbc);
        textNoFactura = new JTextArea("Aqui van los clientes sin factura");
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(textNoFactura,gbc);
        labelYesFactura = new JLabel("            Clientes con factura");
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(labelYesFactura,gbc);
        yesFactura = new JTextArea("Aqui van los clientes con factura");
        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        this.add(yesFactura,gbc);
    }

    public void showClientsNoFactura() {
        textNoFactura.setText(getMyFrame().getClientsNoFactura());
        repaint();
    }

    public void showClientsYesFactura() {
        yesFactura.setText(getMyFrame().getClientsYesFactura());
        repaint();
    }

    public MyFrame getMyFrame() {
        return panelClients.getPrincipalPanel().getFrame();
    }
}
