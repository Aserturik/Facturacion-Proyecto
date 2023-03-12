package co.edu.uptc.view.panels.bill;

import co.edu.uptc.view.panels.fathers.DefaultPanel;

public class PanelBill extends DefaultPanel {
    private HeaderBill headerBill;
    private BodyBill bodyBill;
    private BodyEditBill bodyEditBill;
    public PanelBill() {
        super();
        header();
        body();
    }

    private void header() {
        headerBill = new HeaderBill();
        this.setHeaderPanel(headerBill);
        this.add(this.getHeaderPanel(), java.awt.BorderLayout.NORTH);
    }

    public void body() {
        bodyBill = new BodyBill();
        this.setBodyPanel(bodyBill);
        this.add(this.getBodyPanel(), java.awt.BorderLayout.CENTER);
        bodyBill.setVisible(true);

        bodyEditBill = new BodyEditBill();
        this.setBodyPanel(bodyEditBill);
        this.add(this.getBodyPanel(), java.awt.BorderLayout.CENTER);
        bodyEditBill.setVisible(false);
    }

    public void showBodyEditBill(){
        bodyBill.setVisible(false);
        bodyEditBill.setVisible(true);
    }

    public void showBodyBill(){
        bodyBill.setVisible(true);
        bodyEditBill.setVisible(false);
    }
}
