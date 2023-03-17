package co.edu.uptc.view.panels.products;

import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.panels.fathers.DefaultPanel;

public class PanelProducts extends DefaultPanel {
    private HeaderProducts headerProducts;
    private BodyProducts bodyProducts;
    private EventsView eventsView;
    public PanelProducts(EventsView eventsView){
        super();
        this.setEventsView(eventsView);
        headerProducts = new HeaderProducts(eventsView);
        bodyProducts = new BodyProducts(eventsView);
        header();
        body();
    }

    private void header(){
        this.add(headerProducts, java.awt.BorderLayout.NORTH);
    }

    public void body(){
        this.add(bodyProducts, java.awt.BorderLayout.CENTER);
        bodyProducts.inabiliteFields();
    }

    public void ocultHeader(){
        headerProducts.ocultSearch();
    }

    public void showNormalHeader(){
        headerProducts.showNormal();
    }
}
