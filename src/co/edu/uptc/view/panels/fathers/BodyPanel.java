package co.edu.uptc.view.panels.fathers;

import co.edu.uptc.view.EventsView;

import javax.swing.*;

public class BodyPanel extends JPanel {
    private EventsView eventsView;
    public BodyPanel(){
        super();
        this.setMinimumSize(new java.awt.Dimension(1133, 451));
        this.setMaximumSize(new java.awt.Dimension(1133, 451));
        this.setPreferredSize(new java.awt.Dimension(1133, 451));
    }

    public EventsView getEventsView() {
        return eventsView;
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }
}
