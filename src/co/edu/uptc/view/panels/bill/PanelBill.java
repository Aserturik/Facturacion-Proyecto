package co.edu.uptc.view.panels.bill;
import co.edu.uptc.view.panels.fathers.DefaultPanel;

public class PanelBill extends DefaultPanel {
    private HeaderBill headerBill;
    private BodyBill bodyBill;
    public PanelBill() {
        super();
        headerBill = new HeaderBill();
        bodyBill = new BodyBill();
        header();
        body();
    }

    private void header() {
        this.setHeaderPanel(headerBill);
        this.add(this.getHeaderPanel(), java.awt.BorderLayout.NORTH);
    }

    public void body() {
        this.setBodyPanel(bodyBill);
        this.add(this.getBodyPanel(), java.awt.BorderLayout.CENTER);
    }
}
