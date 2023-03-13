package co.edu.uptc.view.panels.clients;

import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.panels.fathers.DefaultPanel;

public class PanelClients extends DefaultPanel {
    private HeaderClients headerClients;
    private BodyClients bodyClients;
    public PanelClients(EventsView eventsView){
        super();
        this.setEventsView(eventsView);
        header();
        body();
    }

    private void header(){
        headerClients = new HeaderClients();
        this.setHeaderPanel(headerClients);
        this.add(this.getHeaderPanel(), java.awt.BorderLayout.NORTH);
    }

    public void body(){
        bodyClients = new BodyClients();
        this.setBodyPanel(bodyClients);
        this.add(this.getBodyPanel(), java.awt.BorderLayout.CENTER);
        bodyClients.inabiliteFields();
    }
}
