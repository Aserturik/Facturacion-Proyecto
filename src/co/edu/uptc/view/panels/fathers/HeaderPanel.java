package co.edu.uptc.view.panels.fathers;

import co.edu.uptc.view.EventsView;

import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {
    private String title = "";
    private EventsView eventsView;
    public HeaderPanel(){
        super();
        this.setMinimumSize(new java.awt.Dimension(1133, 124));
        this.setMaximumSize(new java.awt.Dimension(1133, 124));
        this.setPreferredSize(new java.awt.Dimension(1133, 124));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        headerTitle(gg);
    }

    public void headerTitle(Graphics2D gg){
        this.removeAll();
        gg.setColor(new Color(217, 217, 217));
        gg.fillRect(60,82,1013,42);
        gg.setColor(new Color(0,0,0,60));
        gg.setFont(new Font("Cabin", Font.BOLD, 32));
        gg.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gg.drawString(title, 413, 114);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
        repaint();
    }

    public EventsView getEventsView() {
        return eventsView;
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }
}
