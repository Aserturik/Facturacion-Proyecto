package co.edu.uptc.view.panels.bill;
import co.edu.uptc.pojo.Person;
import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.panels.PrincipalPanel;
import co.edu.uptc.view.panels.fathers.DefaultPanel;

import java.util.List;

public class PanelBill extends DefaultPanel {
    private HeaderBill headerBill;
    private BodyBill bodyBill;
    private EventsView eventsView;
    private PrincipalPanel principalPanel;
    public PanelBill(EventsView eventsView, PrincipalPanel principalPanel) {
        super();
        this.principalPanel = principalPanel;
        this.setEventsView(eventsView);
        headerBill = new HeaderBill(eventsView,principalPanel);
        bodyBill = new BodyBill(eventsView,principalPanel);
        header();
        body();
        listeners();
    }

    private void header() {
        this.setHeaderPanel(headerBill);
        this.add(this.getHeaderPanel(), java.awt.BorderLayout.NORTH);
    }

    public void body() {
        this.setBodyPanel(bodyBill);
        this.add(this.getBodyPanel(), java.awt.BorderLayout.CENTER);
    }

    public void listeners() {
        this.bodyBill.setEventsView(this.bodyBill.getEventsView());
    }

    public HeaderBill getHeaderBill() {
        return headerBill;
    }

    public void setHeaderBill(HeaderBill headerBill) {
        this.headerBill = headerBill;
    }

    public BodyBill getBodyBill() {
        return bodyBill;
    }

    public void setBodyBill(BodyBill bodyBill) {
        this.bodyBill = bodyBill;
    }

    @Override
    public EventsView getEventsView() {
        return eventsView;
    }

    @Override
    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }

    public PrincipalPanel getPrincipalPanel() {
        return principalPanel;
    }

    public void setPrincipalPanel(PrincipalPanel principalPanel) {
        this.principalPanel = principalPanel;
    }
}
