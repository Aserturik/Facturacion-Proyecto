package co.edu.uptc.view.panels;

import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.panels.bill.PanelBill;
import co.edu.uptc.view.panels.clients.PanelClients;
import co.edu.uptc.view.panels.fathers.FooterPanel;
import co.edu.uptc.view.panels.home.PanelHome;
import co.edu.uptc.view.panels.products.PanelProducts;

import javax.swing.*;
import java.awt.*;

public class PrincipalPanel extends JPanel {
    private EventsView eventsView;
    private GridBagConstraints gbc;
    private FooterPanel footerPanel;
    private PanelHome panelHome;
    private PanelClients panelClients;
    private PanelProducts panelProducts;
    private PanelBill panelBill;


    public PrincipalPanel() {
        this.setSize(1133,744);
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        initComponents();
    }

    private void initComponents(){
        panelHome = new PanelHome();
        panelClients = new PanelClients();
        panelProducts = new PanelProducts();
        panelBill = new PanelBill();
        footerPanel = new FooterPanel();
        panelHome();
        panelClients();
        panelProducts();
        panelBill();
        footerPanel();
    }

    private void upGbc(){
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0,0,0,0);
    }

    private void panelHome(){
        upGbc();
        this.add(panelHome, gbc);
    }

    public void openHome(){
        panelHome.setVisible(true);
        panelClients.setVisible(false);
        panelProducts.setVisible(false);
        panelBill.setVisible(false);
    }

    private void panelClients(){
        upGbc();
        this.add(panelClients, gbc);
    }

    public void openClients(){
        panelHome.setVisible(false);
        panelClients.setVisible(true);
        panelProducts.setVisible(false);
        panelBill.setVisible(false);
    }

    private void panelProducts(){
        upGbc();
        this.add(panelProducts, gbc);
    }

    public void openProducts(){
        panelHome.setVisible(false);
        panelClients.setVisible(false);
        panelProducts.setVisible(true);
        panelBill.setVisible(false);
    }

    private void panelBill(){
        upGbc();
        this.add(panelBill, gbc);
    }

    public void openBill(){
        panelHome.setVisible(false);
        panelClients.setVisible(false);
        panelProducts.setVisible(false);
        panelBill.setVisible(true);
    }

    private void footerPanel() {
        gbc.gridy = 1;
        this.add(footerPanel, gbc);
    }

    public EventsView getEventsView() {
        return eventsView;
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }

    public FooterPanel getFooterPanel() {
        return footerPanel;
    }

    public void setFooterPanel(FooterPanel footerPanel) {
        this.footerPanel = footerPanel;
    }

    public PanelHome getPanelHome() {
        return panelHome;
    }

    public void setPanelHome(PanelHome panelHome) {
        this.panelHome = panelHome;
    }

    public PanelClients getPanelClients() {
        return panelClients;
    }

    public void setPanelClients(PanelClients panelClients) {
        this.panelClients = panelClients;
    }

    public PanelProducts getPanelProducts() {
        return panelProducts;
    }

    public void setPanelProducts(PanelProducts panelProducts) {
        this.panelProducts = panelProducts;
    }

    public PanelBill getPanelBill() {
        return panelBill;
    }

    public void setPanelBill(PanelBill panelBill) {
        this.panelBill = panelBill;
    }
}
