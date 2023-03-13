package co.edu.uptc.view.panels.bill;

import co.edu.uptc.view.panels.fathers.DefaultPanel;

public class PanelEditBill extends DefaultPanel {
    private BodyEditBill bodyPanelEditBill;
    private HeaderEditBill headerPanelEditBill;
    public PanelEditBill() {
        super();
        headerPanelEditBill = new HeaderEditBill();
        bodyPanelEditBill = new BodyEditBill();
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
