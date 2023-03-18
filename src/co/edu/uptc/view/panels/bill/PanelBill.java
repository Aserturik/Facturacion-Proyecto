package co.edu.uptc.view.panels.bill;
import co.edu.uptc.pojo.Person;
import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.panels.fathers.DefaultPanel;

import java.util.List;

public class PanelBill extends DefaultPanel {
    private HeaderBill headerBill;
    private BodyBill bodyBill;
    public PanelBill(EventsView eventsView) {
        super();
        this.setEventsView(eventsView);
        headerBill = new HeaderBill(eventsView);
        bodyBill = new BodyBill(eventsView);
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
}
