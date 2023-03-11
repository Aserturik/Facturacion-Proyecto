package co.edu.uptc.view.panels.clients;

import co.edu.uptc.view.panels.fathers.DefaultPanel;

public class PanelClients extends DefaultPanel {
    private BodyClients bodyClients;
    public PanelClients(){
        super();
        header();
        body();
    }

    private void header(){
        super.getHeaderPanel().setBackground(new java.awt.Color(255, 255, 255));
        super.getHeaderPanel().setTitle("CLIENTES");
    }

    public void body(){
        bodyClients = new BodyClients();
        this.setBodyPanel(bodyClients);
        this.add(this.getBodyPanel());
    }

    private void footer(){
       // this.getFooterPanel().setEventsView(super.getEventsView());
    }
}
