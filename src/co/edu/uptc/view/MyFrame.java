package co.edu.uptc.view;

import co.edu.uptc.pojo.Bill;
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
        System.out.println("setClients");
        clients = clientsClone;
    }

    @Override
    public void setProducts(List<Product> products) {
        System.out.println("setProducts");
        //principalPanel.getPanelProducts().setProducts(products);
    }

    @Override
    public void setBills(List<Bill> bills) {
        System.out.println("setBills");
        //principalPanel.getPanelBills().setBills(bills);
    }

    // Eventos de los paneles
    @Override
    public void openHome() {
        System.out.println("openHome");
        saveAllLists();
        principalPanel.openHome();
    }

    @Override
    public void openClients() {
        System.out.println("openClients");
        saveAllLists();
        principalPanel.openClients();
    }


    @Override
    public void openProducts() {
        System.out.println("openProducts");
        saveAllLists();
        principalPanel.openProducts();
    }

    @Override
    public void openBill() {
        System.out.println("openBill");
        saveAllLists();
        principalPanel.openBill();
    }

    private void saveAllLists() {
        presenter.loadClients();
        presenter.loadProducts();
        presenter.loadBills();
    }

    @Override
    public void openEditBill(int index) {
        System.out.println("openEditBill");
        principalPanel.openEditBill(index);
    }

    @Override
    public void openEditBill() {
        System.out.println("openEditBill");
        principalPanel.openEditBill();
    }
    @Override
    public void openAddBill() {
        System.out.println("openAddBill");
        principalPanel.openEditBill();
    }

    @Override
    public void searchBill() {
        System.out.println("searchBill");
        //principalPanel.get
    }

    @Override
    public void saveBillAndExit() {
        System.out.println("saveBillAndExit");
        principalPanel.openBill();
    }

    @Override
    public void ocultHeaderClients() {
        System.out.println("ocultHeaderClients");
        principalPanel.getPanelClients().ocultHeader();
    }

    @Override
    public void ocultHeaderProducts() {
        System.out.println("ocultHeaderProducts");
        principalPanel.getPanelProducts().ocultHeader();
    }

    @Override
    public void showNormalHeaderClients(){
        System.out.println("showNormalHeaderClients()");
        principalPanel.getPanelClients().showNormalHeader();
    }

    @Override
    public void comboBoxClients(){
        System.out.println("comboBoxClients()");
        //principalPanel.getPanelClients().comboBoxClients();
    }

    @Override
    public void showNormalHeaderProducts(){
        System.out.println("showNormalHeaderProducts()");
        principalPanel.getPanelProducts().showNormalHeader();
    }

    @Override
    public void selectClient(){
        System.out.println("selectClient()");
        principalPanel.openClients();
        disableFooterButtons();
    }

    @Override
    public void openSelectedPerson(){
        System.out.println("openSelectedPerson()");
        if(!principalPanel.getFooterPanel().isEnableButtons()){
            enableFooterButtons();
            Person selectClient = principalPanel.getPanelClients().getSelectedClient();
            principalPanel.openEditBill();
            principalPanel.getPanelEditBill().setActualClient(selectClient);
        }
    }

    private void disableFooterButtons(){
        System.out.println("disableFooterButtons()");
        principalPanel.disableFooterButtons();
    }

    @Override
    public void enableFooterButtons(){
        System.out.println("enableFooterButtons()");
        principalPanel.enableFooterButtons();
    }

    @Override
    public void showClientData(Person client){
        System.out.println("showClientData()");
        principalPanel.getPanelClients().showClientData(client);
    }

    public List<Person> getClients() {
        return clients;
    }
}
