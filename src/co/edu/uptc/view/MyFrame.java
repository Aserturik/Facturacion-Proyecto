package co.edu.uptc.view;

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
        setEventsView();
    }

    private void initComponents() {
        principalPanel();
    }

    private void principalPanel() {
        principalPanel = new PrincipalPanel();
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

    private void setEventsView(){
        principalPanel.setEventsView(this);
        principalPanel.getFooterPanel().setEventsView(this);
        principalPanel.getPanelHome().getBodyPanel().setEventsView(this);
    }
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
    public void openEditBill() {
        principalPanel.openEditBill();
    }
}
