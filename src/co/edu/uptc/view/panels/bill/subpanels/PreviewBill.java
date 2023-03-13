package co.edu.uptc.view.panels.bill.subpanels;

import co.edu.uptc.view.EventsView;
import javax.swing.*;

public class PreviewBill extends JPanel {
    private EventsView eventsView;
    public PreviewBill(EventsView eventsView) {
        this.setEventsView(eventsView);
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.setSize(617,344);
        this.setMinimumSize(new java.awt.Dimension(617, 349));
        this.setMaximumSize(new java.awt.Dimension(617, 349));
        this.setPreferredSize(new java.awt.Dimension(617, 349));

    }

    public EventsView getEventsView() {
        return eventsView;
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }
}
