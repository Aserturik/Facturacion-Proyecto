package co.edu.uptc.view.panels.bill;

import co.edu.uptc.pojo.Person;
import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.panels.fathers.HeaderPanel;

import java.awt.*;
import java.util.List;

public class HeaderBill extends HeaderPanel {
    private String title = "FACTURAS";
    public HeaderBill(EventsView eventsView) {
        super();
        this.setEventsView(eventsView);
        this.setBackground(new java.awt.Color(255, 255, 255));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        headerTitle(gg);
    }

    public void headerTitle(Graphics2D gg) {
        gg.setColor(new Color(217, 217, 217));
        gg.fillRect(60, 82, 1013, 42);
        gg.setColor(new Color(0, 0, 0, 60));
        gg.setFont(new Font("Cabin", Font.BOLD, 32));
        gg.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gg.drawString(title, 428, 114);
    }

}
