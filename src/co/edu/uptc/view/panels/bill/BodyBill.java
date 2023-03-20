package co.edu.uptc.view.panels.bill;

import co.edu.uptc.pojo.Person;
import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.panels.PrincipalPanel;
import co.edu.uptc.view.panels.bill.subpanels.PreviewBill;
import co.edu.uptc.view.panels.bill.subpanels.ShowAllBills;
import co.edu.uptc.view.panels.fathers.BodyPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BodyBill extends BodyPanel {
    private PreviewBill previewBill;
    private ShowAllBills showAllBills;
    private GridBagConstraints gbc;
    private List<Person> listClients;
    private PrincipalPanel principalPanel;
    public BodyBill(EventsView eventsView, PrincipalPanel principalPanel) {
        super();
        this.setEventsView(eventsView);
        this.principalPanel = principalPanel;
        showAllBills = new ShowAllBills(eventsView, principalPanel);
        previewBill = new PreviewBill(eventsView, principalPanel);
        this.setBackground(new Color(255, 255, 255));
        gbc = new GridBagConstraints();
        panelUp();
        showAllBills();
        previewBill();
    }

    public void panelUp(){
        JPanel panelUp = new JPanel();
        panelUp.setBackground(new Color(255, 255, 255));
        panelUp.setSize(1133, 40);
        panelUp.setMinimumSize(new Dimension(1133, 40));
        panelUp.setMaximumSize(new Dimension(1133, 40));
        panelUp.setPreferredSize(new Dimension(1133, 40));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        this.add(panelUp, gbc);
    }

    private void showAllBills() {
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(40, 52, 0, 73);
        this.add(showAllBills, gbc);
    }
    private void previewBill() {
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(40, 82, 0, 64);
        this.add(previewBill, gbc);
    }

    public PreviewBill getPreviewBill() {
        return previewBill;
    }

    public void setPreviewBill(PreviewBill previewBill) {
        this.previewBill = previewBill;
    }

    public ShowAllBills getShowAllBills() {
        return showAllBills;
    }

    public void setShowAllBills(ShowAllBills showAllBills) {
        this.showAllBills = showAllBills;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }

    public List<Person> getListClients() {
        return listClients;
    }

    public void setListClients(List<Person> listClients) {
        this.listClients = listClients;
    }

    public PrincipalPanel getPrincipalPanel() {
        return principalPanel;
    }

    public void setPrincipalPanel(PrincipalPanel principalPanel) {
        this.principalPanel = principalPanel;
    }
}
