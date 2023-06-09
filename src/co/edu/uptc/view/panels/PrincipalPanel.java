package co.edu.uptc.view.panels;

import co.edu.uptc.pojo.Person;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.MyFrame;
import co.edu.uptc.view.panels.bill.PanelBill;
import co.edu.uptc.view.panels.bill.PanelEditBill;
import co.edu.uptc.view.panels.clients.PanelClients;
import co.edu.uptc.view.panels.fathers.FooterPanel;
import co.edu.uptc.view.panels.home.PanelHome;
import co.edu.uptc.view.panels.products.PanelProducts;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PrincipalPanel extends JPanel {
    private EventsView eventsView;
    private GridBagConstraints gbc;
    private FooterPanel footerPanel;
    private PanelHome panelHome;
    private PanelClients panelClients;
    private PanelProducts panelProducts;
    private PanelBill panelBill;
    private PanelEditBill panelEditBill;
    private List<Person> listClients;
    private MyFrame frame;

    public PrincipalPanel(EventsView eventsView, MyFrame frame) {
        this.eventsView = eventsView;
        this.frame = frame;
        this.setSize(1133,744);
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        initComponents();
    }

    private void initComponents(){
        panelHome = new PanelHome(eventsView);
        panelClients = new PanelClients(eventsView,this);
        panelClients.setPrincipalPanel(this);
        panelProducts = new PanelProducts(eventsView, this);
        panelBill = new PanelBill(eventsView);
        panelEditBill = new PanelEditBill(eventsView);
        footerPanel = new FooterPanel(eventsView);
        panelHome();
        panelClients();
        panelProducts();
        panelBill();
        panelEditBill();
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
        panelEditBill.setVisible(false);
    }

    private void panelClients(){
        upGbc();
        this.add(panelClients, gbc);
        panelClients.setVisible(false);
    }

    public void openClients(){
        panelHome.setVisible(false);
        panelClients.setVisible(true);
        panelProducts.setVisible(false);
        panelBill.setVisible(false);
        panelEditBill.setVisible(false);
        int index = panelClients.getHeaderClients().getClientsComboBox().getSelectedIndex();
        Person p = panelClients.getHeaderClients().getSelectedClient(index);
        panelClients.getBodyClients().showClientData(p);
    }

    private void panelProducts(){
        upGbc();
        this.add(panelProducts, gbc);
        panelProducts.setVisible(false);
    }

    public void openProducts(){
        panelHome.setVisible(false);
        panelClients.setVisible(false);
        panelProducts.setVisible(true);
        panelEditBill.setVisible(false);
        panelBill.setVisible(false);
        int index = panelProducts.getHeaderProducts().getProductsComboBox().getSelectedIndex();
        Product p = panelProducts.getHeaderProducts().getSelectedProduct(index);
        panelProducts.getBodyProducts().showProductData(p);
    }

    private void panelBill(){
        upGbc();
        this.add(panelBill, gbc);
        panelBill.setVisible(false);
    }

    public void openBill(){
        panelHome.setVisible(false);
        panelClients.setVisible(false);
        panelProducts.setVisible(false);
        panelEditBill.setVisible(false);
        panelBill.setVisible(true);
    }

    private void panelEditBill(){
        upGbc();
        this.add(panelEditBill, gbc);
        panelEditBill.setVisible(false);
    }

    public void openEditBill(){
        panelHome.setVisible(false);
        panelClients.setVisible(false);
        panelProducts.setVisible(false);
        panelBill.setVisible(false);
        panelEditBill.setVisible(true);
    }

    public void openEditBill(int index){
        panelHome.setVisible(false);
        panelClients.setVisible(false);
        panelProducts.setVisible(false);
        panelBill.setVisible(false);
        panelEditBill.setVisible(true);
    }

    private void footerPanel() {
        gbc.gridy = 1;
        this.add(footerPanel, gbc);
    }

    public void disableFooterButtons(){
        footerPanel.disableButtons();
    }

    public void enableFooterButtons(){
        footerPanel.enableButtons();
    }

    // Eventos del Presenter

    // Getters and Setters

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

    public EventsView getEventsView() {
        return eventsView;
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }

    public PanelEditBill getPanelEditBill() {
        return panelEditBill;
    }

    public void setPanelEditBill(PanelEditBill panelEditBill) {
        this.panelEditBill = panelEditBill;
    }
    public void setFrame(MyFrame frame) {
        this.frame = frame;
    }

    public MyFrame getFrame() {
        return frame;
    }
}
