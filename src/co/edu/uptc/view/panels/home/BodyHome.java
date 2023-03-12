package co.edu.uptc.view.panels.home;

import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.buttons.ButtonImage;
import co.edu.uptc.view.panels.fathers.BodyPanel;

import java.awt.*;

public class BodyHome extends BodyPanel {
    private ButtonImage buttonHome, buttonPerson, buttonShop;
    private EventsView eventsView;
    public BodyHome(){
        super();
        this.setBackground(new java.awt.Color(255,255, 255));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        initComponents(gbc);
        listeners();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        footerBar(gg);
    }

    private void initComponents(GridBagConstraints gbc){
        buttonPerson = new ButtonImage("client", false, 255,255, 255);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(buttonPerson, gbc);
        buttonHome = new ButtonImage("home", false, 255,255, 255);
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(buttonHome, gbc);
        buttonShop = new ButtonImage("shop", false, 255,255, 255);
        gbc.gridx = 2;
        gbc.gridy = 1;
        this.add(buttonShop, gbc);
    }

    public void footerBar(Graphics2D gg){
        gg.setColor(new Color(217, 217, 217));
        gg.fillRect(60,368,1013,42);
    }

    private void listeners(){
        buttonHome.addActionListener(e -> eventsView.openHome());
        buttonPerson.addActionListener(e -> eventsView.openClients());
        buttonShop.addActionListener(e -> eventsView.openProducts());
    }

    public EventsView getEventsView() {
        return eventsView;
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }

}
