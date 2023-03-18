package co.edu.uptc.view.panels.fathers;

import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.buttons.GrayButton;

import javax.swing.*;

public class FooterPanel extends JPanel {
    private GrayButton homeButton,clientsButton,productsButton,billButton;
    private EventsView eventsView;
    private boolean isEnableButtons;
    public FooterPanel(EventsView eventsView){
        super();
        this.eventsView = eventsView;
        this.setMinimumSize(new java.awt.Dimension(1133, 169));
        this.setMaximumSize(new java.awt.Dimension(1133, 169));
        this.setPreferredSize(new java.awt.Dimension(1133, 169));
        this.setBackground(new java.awt.Color(255, 255, 255));
        initComponents();
        listeners();
        isEnableButtons = true;
    }

    public void initComponents(){
        this.homeButton = new GrayButton("Principal");
        this.clientsButton = new GrayButton("Personas");
        this.productsButton = new GrayButton("Productos");
        this.billButton = new GrayButton("Factura");
        homeButton.setBig();
        clientsButton.setBig();
        productsButton.setBig();
        billButton.setBig();
        this.add(this.homeButton);
        this.add(this.clientsButton);
        this.add(this.productsButton);
        this.add(this.billButton);
    }

    public void listeners(){
        homeButton();
        clientsButton();
        productsButton();
        billButton();
    }

    public void homeButton(){
        this.homeButton.addActionListener(evt -> eventsView.openHome());
    }

    public void clientsButton(){
        this.clientsButton.addActionListener(evt -> eventsView.openClients());
    }

    public void productsButton(){
        this.productsButton.addActionListener(evt -> eventsView.openProducts());
    }

    public void billButton(){
        // hay que cambiarlo al original
        this.billButton.addActionListener(evt -> eventsView.openEditBill());
    }

    public void disableButtons(){
        this.homeButton.setEnabled(false);
        this.clientsButton.setEnabled(false);
        this.productsButton.setEnabled(false);
        this.billButton.setEnabled(false);
        isEnableButtons = false;
    }

    public void enableButtons(){
        this.homeButton.setEnabled(true);
        this.clientsButton.setEnabled(true);
        this.productsButton.setEnabled(true);
        this.billButton.setEnabled(true);
        isEnableButtons = true;
    }

    public EventsView getEventsView() {
        return eventsView;
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }

    public boolean isEnableButtons() {
        return isEnableButtons;
    }

    public void setEnableButtons(boolean isEnableButtons) {
        this.isEnableButtons = isEnableButtons;
    }
}
