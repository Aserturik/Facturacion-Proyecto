package co.edu.uptc.view;

import co.edu.uptc.pojo.Person;
import co.edu.uptc.presenter.Contract;
import co.edu.uptc.view.panels.PrincipalPanel;

import javax.swing.*;

public class MyFrame extends JFrame implements Contract.View, EventsView{
    private Contract.Presenter presenter;
    private PrincipalPanel principalPanel;

    public MyFrame() {
        super("Facturacion");
        setSize(1133,744);
        setResizable(false);
        setMinimumSize(getSize());
        setMaximumSize(getSize());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        principalPanel();
    }

    private void principalPanel() {
        principalPanel = new PrincipalPanel(this);
        this.add(principalPanel);
    }


    // Eventos del Presenter

    @Override
    public void start() {
        this.setVisible(true);
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }


    // Eventos de los paneles
    @Override
    public void openHome() {
        System.out.println("openHome");
        principalPanel.openHome();
    }

    @Override
    public void openClients() {
        System.out.println("openClients");
        principalPanel.openClients();
    }


    @Override
    public void openProducts() {
        System.out.println("openProducts");
        principalPanel.openProducts();
    }

    @Override
    public void openBill() {
        principalPanel.openBill();
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
        principalPanel.openEditBill();
    }

    @Override
    public void searchBill() {
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
        principalPanel.disableFooterButtons();
        Person selectClient = principalPanel.getPanelClients().getSelectedClient();
    }

    @Override
    public void enableFooterButtons(){
        System.out.println("enableFooterButtons()");
        principalPanel.enableFooterButtons();
    }
}
