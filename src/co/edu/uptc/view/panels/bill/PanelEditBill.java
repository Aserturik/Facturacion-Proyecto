package co.edu.uptc.view.panels.bill;

import co.edu.uptc.pojo.Bill;
import co.edu.uptc.pojo.Person;
import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.panels.PrincipalPanel;
import co.edu.uptc.view.panels.fathers.DefaultPanel;

public class PanelEditBill extends DefaultPanel {
    private BodyEditBill bodyPanelEditBill;
    private HeaderEditBill headerPanelEditBill;
    private PrincipalPanel principalPanel;
    public PanelEditBill(EventsView eventsView,PrincipalPanel principalPanel) {
        super();
        this.setEventsView(eventsView);
        this.principalPanel = principalPanel;
        headerPanelEditBill = new HeaderEditBill(eventsView,principalPanel);
        bodyPanelEditBill = new BodyEditBill(eventsView,principalPanel);
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

    public void setActualClient(Person person){
        headerPanelEditBill.setActualClient(person);
    }

    public void loadEditBill(Bill bill) {
        headerPanelEditBill.loadEditBill(bill);
        bodyPanelEditBill.loadEditBill(bill);
    }

    public BodyEditBill getBodyPanelEditBill() {
        return bodyPanelEditBill;
    }

    public void setBodyPanelEditBill(BodyEditBill bodyPanelEditBill) {
        this.bodyPanelEditBill = bodyPanelEditBill;
    }

    public HeaderEditBill getHeaderPanelEditBill() {
        return headerPanelEditBill;
    }

    public void setHeaderPanelEditBill(HeaderEditBill headerPanelEditBill) {
        this.headerPanelEditBill = headerPanelEditBill;
    }

    public PrincipalPanel getPrincipalPanel() {
        return principalPanel;
    }

    public void setPrincipalPanel(PrincipalPanel principalPanel) {
        this.principalPanel = principalPanel;
    }
}
