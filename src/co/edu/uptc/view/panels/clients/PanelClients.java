package co.edu.uptc.view.panels.clients;

import co.edu.uptc.pojo.Person;
import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.panels.PrincipalPanel;
import co.edu.uptc.view.panels.fathers.DefaultPanel;

import java.util.List;

public class PanelClients extends DefaultPanel {
    private HeaderClients headerClients;
    private BodyClients bodyClients;
    private BodyDeleteCients bodyDeleteCients;
    private EventsView eventsView;
    private List<Person> listClients;
    private PrincipalPanel principalPanel;
    public PanelClients(EventsView eventsView, PrincipalPanel principalPanel) {
        super();
        this.setEventsView(eventsView);
        this.principalPanel = principalPanel;
        header();
        body();
        listClients();
    }

    private void header(){
        headerClients = new HeaderClients(eventsView,this);
        this.setHeaderPanel(headerClients);
        this.add(this.getHeaderPanel(), java.awt.BorderLayout.NORTH);
        headerClients.setPanelClients(this);
    }

    public void body(){
        bodyClients = new BodyClients(eventsView,this);
        this.setBodyPanel(bodyClients);
        this.add(this.getBodyPanel(), java.awt.BorderLayout.CENTER);
        bodyClients.inabiliteFields();
        bodyClients.setPanelClients(this);

        bodyDeleteCients = new BodyDeleteCients(eventsView,this);
        add(bodyDeleteCients, java.awt.BorderLayout.CENTER);
        bodyDeleteCients.setVisible(false);
        bodyClients.setVisible(true);
        this.add(this.getBodyPanel(), java.awt.BorderLayout.CENTER);
    }

    public void showDeleteClient(){
        this.setBodyPanel(bodyDeleteCients);
        this.add(this.getBodyPanel(), java.awt.BorderLayout.CENTER);
        bodyClients.setVisible(false);
        bodyDeleteCients.setVisible(true);
    }

    public void showNormalClient(){
        this.setBodyPanel(bodyClients);
        this.add(this.getBodyPanel(), java.awt.BorderLayout.CENTER);
        bodyDeleteCients.setVisible(false);
        bodyClients.setVisible(true);
    }

    public void listClients(){
        listClients = principalPanel.getFrame().getClients();
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

    public void setListClients(List<Person> clients) {

    }

    public void showClientData(Person client){
        bodyClients.showClientData(client);
    }

    public HeaderClients getHeaderClients() {
        return headerClients;
    }

    public void setHeaderClients(HeaderClients headerClients) {
        this.headerClients = headerClients;
    }

    public BodyClients getBodyClients() {
        return bodyClients;
    }

    public void setBodyClients(BodyClients bodyClients) {
        this.bodyClients = bodyClients;
    }

    @Override
    public EventsView getEventsView() {
        return eventsView;
    }

    public void setPrincipalPanel(PrincipalPanel principalPanel) {
        this.principalPanel = principalPanel;
    }

    public PrincipalPanel getPrincipalPanel() {
        return principalPanel;
    }

    public List<Person> getListClients() {
        return listClients;
    }

    public BodyDeleteCients getBodyDeleteCients() {
        return bodyDeleteCients;
    }

    public void setBodyDeleteCients(BodyDeleteCients bodyDeleteCients) {
        this.bodyDeleteCients = bodyDeleteCients;
    }
}
