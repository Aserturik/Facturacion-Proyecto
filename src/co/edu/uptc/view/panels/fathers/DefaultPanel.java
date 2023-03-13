package co.edu.uptc.view.panels.fathers;

import co.edu.uptc.view.EventsView;

import javax.swing.*;
import java.awt.*;

public class DefaultPanel extends JPanel {
    private HeaderPanel headerPanel;
    private BodyPanel bodyPanel;
    private EventsView eventsView;
    public DefaultPanel(){
        super();
        this.setMinimumSize(new java.awt.Dimension(1133, 575));
        this.setMaximumSize(new java.awt.Dimension(1133, 575));
        this.setPreferredSize(new java.awt.Dimension(1133, 575));
        initComponents();
    }

    private void initComponents(){
        this.headerPanel = new HeaderPanel();
        this.bodyPanel = new BodyPanel();
        this.setLayout(new BorderLayout());
        this.add(this.headerPanel, BorderLayout.NORTH);
        this.add(this.bodyPanel, BorderLayout.CENTER);
    }

    public HeaderPanel getHeaderPanel() {
        return this.headerPanel;
    }

    public void setHeaderPanel(HeaderPanel headerPanel) {
        this.headerPanel = headerPanel;
    }

    public BodyPanel getBodyPanel() {
        return this.bodyPanel;
    }

    public void setBodyPanel(BodyPanel bodyPanel) {
        this.bodyPanel = bodyPanel;
    }

    public EventsView getEventsView() {
        return eventsView;
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }
}
