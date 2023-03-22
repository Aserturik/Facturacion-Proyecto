package co.edu.uptc.view;

import co.edu.uptc.pojo.Bill;
import co.edu.uptc.pojo.Buy;
import co.edu.uptc.pojo.Person;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.presenter.Contract;
import co.edu.uptc.view.panels.PrincipalPanel;

import javax.swing.*;
import java.util.List;

public class MyFrame extends JFrame implements Contract.View, EventsView{
    private Contract.Presenter presenter;
    private PrincipalPanel principalPanel;
    private List<Person> clients;
    private List<Product> products;
    private List<Bill> bills;
    private List<Buy> buys;

    public MyFrame() {
        super("Facturacion");
        setSize(1133,744);
        setResizable(false);
        setMinimumSize(getSize());
        setMaximumSize(getSize());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        principalPanel();
    }

    private void principalPanel() {
        principalPanel = new PrincipalPanel(this,this);
        this.add(principalPanel);
    }


    // Eventos del Presenter

    @Override
    public void start() {
        initComponents();
        this.setVisible(true);
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setClients(List<Person> clientsClone) {
        clients = clientsClone;
    }

    @Override
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public void setBuys(List<Buy> buys) {
        this.buys = buys;
    }

    // Eventos de los paneles
    @Override
    public void openHome() {
        saveAllLists();
        principalPanel.openHome();
    }

    @Override
    public void openClients() {
        saveAllLists();
        principalPanel.openClients();
    }


    @Override
    public void openProducts() {
        saveAllLists();
        principalPanel.openProducts();
    }

    @Override
    public void openBill() {
        saveAllLists();
        principalPanel.openBill();
    }

    public void saveAllLists() {
        presenter.loadClients();
        presenter.loadProducts();
        presenter.loadBills();
    }

    @Override
    public void openEditBill(int index) {
        principalPanel.openEditBill(index);
    }

    @Override
    public void openEditBill() {
        principalPanel.openEditBill();
    }
    @Override
    public void openAddBill() {
        principalPanel.openEditBill();
    }

    @Override
    public void searchBill() {
        //principalPanel.get
    }

    @Override
    public void saveBillAndExit() {
        principalPanel.openBill();
    }

    @Override
    public void ocultHeaderClients() {
        principalPanel.getPanelClients().ocultHeader();
    }

    @Override
    public void ocultHeaderProducts() {
        principalPanel.getPanelProducts().ocultHeader();
    }

    @Override
    public void showNormalHeaderClients(){
        principalPanel.getPanelClients().showNormalHeader();
    }

    @Override
    public void comboBoxClients(){
        //principalPanel.getPanelClients().comboBoxClients();
    }

    @Override
    public void showNormalHeaderProducts(){
        principalPanel.getPanelProducts().showNormalHeader();
    }

    @Override
    public void selectClient(){
        principalPanel.getPanelClients().getBodyClients().selectClient();
        principalPanel.getPanelClients().getBodyClients().inabiliteFields();
        principalPanel.getPanelClients().getBodyClients().setEdit(true);
        principalPanel.openClients();
        disableFooterButtons();
    }

    @Override
    public void openSelectedPerson(){
        if(!principalPanel.getFooterPanel().isEnableButtons()){
            enableFooterButtons();
            Person selectClient = principalPanel.getPanelClients().getSelectedClient();
            principalPanel.openEditBill();
            principalPanel.getPanelEditBill().setActualClient(selectClient);
        }
    }

    public List<Person> getClients(String text){
        return presenter.getClients(text);
    }

    public void disableFooterButtons(){
        principalPanel.disableFooterButtons();
    }

    @Override
    public void enableFooterButtons(){
        principalPanel.enableFooterButtons();
    }

    @Override
    public void showClientData(Person client){
        principalPanel.getPanelClients().showClientData(client);
    }

    public List<Person> getClients() {
        return clients;
    }

    public boolean isPersonExist(boolean isAdult, String document){
        return presenter.isPersonExist(isAdult,document);
    }

    public boolean isValidDocument(String document){
        return presenter.isValidDocument(document);
    }

    public List<Person> getNewClients(Person newPerson) {
        return presenter.getNewClients(newPerson);
    }

    public boolean getEditClients(int indexOf, Person newPerson) {
        return presenter.getEditClients(indexOf,newPerson);
    }

    public List<Product> getProducts() {
        return this.products;
    }
    public List<Product> getProducts(String text) {
        return presenter.getProducts(text);
    }

    public boolean isProductExist(String ciu, String barCode){
        return presenter.isProductExist(ciu,barCode);
    }

    public List<Product> getNewProducts(Product newProduct) {
        return presenter.getNewProducts(newProduct);
    }

    public boolean isEditProduct(int index, Product newProduct) {
        return presenter.isEditProduct(index,newProduct);
    }

    public List<Bill> getBills() {
        return bills;
    }

    public List<Bill> getBills(String text) {
        return bills;
    }

    public Product getProduct(String text) {
        return presenter.getProduct(text);
    }

    public void DeleteAllClientsNoFactura() {
        presenter.DeleteAllClientsNoFactura();
    }

    public String getClientsNoFactura() {
        return presenter.getClientsNoFactura();
    }

    public String getClientsYesFactura() {
        return presenter.getClientsYesFactura();
    }
}
