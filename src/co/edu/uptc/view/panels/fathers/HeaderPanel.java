package co.edu.uptc.view.panels.fathers;

import co.edu.uptc.view.EventsView;

import javax.swing.*;

public class HeaderPanel extends JPanel {
    private EventsView eventsView;

    public HeaderPanel() {
        super();
        this.setMinimumSize(new java.awt.Dimension(1133, 124));
        this.setMaximumSize(new java.awt.Dimension(1133, 124));
        this.setPreferredSize(new java.awt.Dimension(1133, 124));
        this.setBackground(new java.awt.Color(0, 0, 255));
    }

    public EventsView getEventsView() {
        return eventsView;
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }
}
