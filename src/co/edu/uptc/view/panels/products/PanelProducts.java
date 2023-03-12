package co.edu.uptc.view.panels.products;

import co.edu.uptc.view.panels.fathers.DefaultPanel;

public class PanelProducts extends DefaultPanel {
    private HeaderProducts headerProducts;
    private BodyProducts bodyProducts;
    public PanelProducts(){
        super();
        header();
        body();
    }

    private void header(){
        headerProducts = new HeaderProducts();
        this.setHeaderPanel(headerProducts);
        this.add(this.getHeaderPanel(), java.awt.BorderLayout.NORTH);
    }

    public void body(){
        bodyProducts = new BodyProducts();
        this.setBodyPanel(bodyProducts);
        this.add(this.getBodyPanel(), java.awt.BorderLayout.CENTER);
        bodyProducts.inabiliteFields();
    }
}
