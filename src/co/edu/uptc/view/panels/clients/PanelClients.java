package co.edu.uptc.view.panels.clients;

import co.edu.uptc.pojo.Person;
import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.panels.fathers.DefaultPanel;

public class PanelClients extends DefaultPanel {
    private HeaderClients headerClients;
    private BodyClients bodyClients;
    private EventsView eventsView;
    public PanelClients(EventsView eventsView){
        super();
        this.setEventsView(eventsView);
        header();
        body();
    }

    private void header(){
        headerClients = new HeaderClients(eventsView);
        this.setHeaderPanel(headerClients);
        this.add(this.getHeaderPanel(), java.awt.BorderLayout.NORTH);
    }

    public void body(){
        bodyClients = new BodyClients(eventsView);
        this.setBodyPanel(bodyClients);
        this.add(this.getBodyPanel(), java.awt.BorderLayout.CENTER);
        bodyClients.inabiliteFields();
    }

    public void ocultHeader(){
        headerClients.ocultSearch();
    }
    public void showNormalHeader(){
        headerClients.showNormal();
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }

    public Person getSelectedClient(){
        bodyClients.modeSelected();
        return bodyClients.getSelectedClient();
    }
}
