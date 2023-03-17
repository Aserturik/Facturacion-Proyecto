package co.edu.uptc.view.panels.bill;

import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.panels.bill.subpanels.DescriptionEditPanel;
import co.edu.uptc.view.panels.bill.subpanels.TableEditPanel;
import co.edu.uptc.view.panels.fathers.BodyPanel;

import java.awt.*;

public class BodyEditBill extends BodyPanel {
    private TableEditPanel tableEditPanel;
    private DescriptionEditPanel descriptionEditPanel;
    private GridBagConstraints gbc;
    private EventsView eventsView;

    public BodyEditBill(EventsView eventsView) {
        this.setEventsView(eventsView);
        tableEditPanel = new TableEditPanel(eventsView);
        descriptionEditPanel = new DescriptionEditPanel(eventsView);
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        initComponents();
    }

    private void  initComponents() {
        tableEditPanel();
        descriptionEditPanel();
    }

    private void tableEditPanel(){
        this.add(tableEditPanel,gbc);
    }

    private void descriptionEditPanel(){
        this.add(descriptionEditPanel);
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }

    public EventsView getEventsView() {
        return eventsView;
    }
}
