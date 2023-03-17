package co.edu.uptc.view.panels.bill;

import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.panels.fathers.DefaultPanel;

public class PanelEditBill extends DefaultPanel {
    private BodyEditBill bodyPanelEditBill;
    private HeaderEditBill headerPanelEditBill;
    public PanelEditBill(EventsView eventsView) {
        super();
        this.setEventsView(eventsView);
        headerPanelEditBill = new HeaderEditBill(eventsView);
        bodyPanelEditBill = new BodyEditBill(eventsView);
        header();
        body();
    }

    public void header(){
        this.setHeaderPanel(headerPanelEditBill);
        this.add(this.getHeaderPanel(), java.awt.BorderLayout.NORTH);
    }

    public void body() {
        this.setBodyPanel(bodyPanelEditBill);
        this.add(this.getBodyPanel(), java.awt.BorderLayout.CENTER);
    }
}
