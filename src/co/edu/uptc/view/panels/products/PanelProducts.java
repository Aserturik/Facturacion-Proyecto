package co.edu.uptc.view.panels.products;

import co.edu.uptc.pojo.Product;
import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.MyFrame;
import co.edu.uptc.view.panels.PrincipalPanel;
import co.edu.uptc.view.panels.fathers.DefaultPanel;

public class PanelProducts extends DefaultPanel {
    private HeaderProducts headerProducts;
    private BodyProducts bodyProducts;
    private EventsView eventsView;
    private PrincipalPanel principalPanel;
    public PanelProducts(EventsView eventsView, PrincipalPanel principalPanel) {
        super();
        this.setEventsView(eventsView);
        this.setPrincipalPanel(principalPanel);
        headerProducts = new HeaderProducts(eventsView,this);
        bodyProducts = new BodyProducts(eventsView,this);
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

    public MyFrame getFrame() {
        return principalPanel.getFrame();
    }

    public HeaderProducts getHeaderProducts() {
        return headerProducts;
    }

    public void setHeaderProducts(HeaderProducts headerProducts) {
        this.headerProducts = headerProducts;
    }

    public BodyProducts getBodyProducts() {
        return bodyProducts;
    }

    public void setBodyProducts(BodyProducts bodyProducts) {
        this.bodyProducts = bodyProducts;
    }

    @Override
    public EventsView getEventsView() {
        return eventsView;
    }

    @Override
    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }

    public PrincipalPanel getPrincipalPanel() {
        return principalPanel;
    }

    public void setPrincipalPanel(PrincipalPanel principalPanel) {
        this.principalPanel = principalPanel;
    }
}
