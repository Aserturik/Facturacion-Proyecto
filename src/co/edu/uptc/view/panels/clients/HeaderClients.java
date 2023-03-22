package co.edu.uptc.view.panels.clients;

import co.edu.uptc.model.dinamic.UptcList;
import co.edu.uptc.pojo.Person;
import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.MyFrame;
import co.edu.uptc.view.buttons.GrayButton;
import co.edu.uptc.view.panels.fathers.HeaderPanel;
import co.edu.uptc.view.textfield.TextFieldGray;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HeaderClients extends HeaderPanel {
    private TextFieldGray searchTextField;
    private GrayButton searchButton;
    private JLabel grayLabel;
    private JComboBox<String> clientsComboBox;
    private List<Person> clientsList;
    private EventsView eventsView;
    private GridBagConstraints gbc;
    private PanelClients panelClients;
    private GrayButton deleteAllClientsButton;
    private JLabel MessageDeleteAllClients;
    private GrayButton yesDeleteAllClientsButton, noDeleteAllClientsButton;

    public HeaderClients(EventsView eventsView, PanelClients panelClients) {
        super();
        this.setEventsView(eventsView);
        this.setLayout(new GridBagLayout());
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.panelClients = panelClients;
        initComponents();
    }

    private void ocultHeader(){
        searchButton.setVisible(false);
        searchTextField.setVisible(false);
        clientsComboBox.setVisible(false);
        grayLabel.setVisible(false);
        deleteAllClientsButton.setVisible(false);

        showMessageDeleteAllClients();
        yesDeleteAllClientsButton.setVisible(true);
        noDeleteAllClientsButton.setVisible(true);
    }

    private void showHeader(){
        searchButton.setVisible(true);
        searchTextField.setVisible(true);
        clientsComboBox.setVisible(true);
        grayLabel.setVisible(false);
        deleteAllClientsButton.setVisible(true);

        yesDeleteAllClientsButton.setVisible(false);
        noDeleteAllClientsButton.setVisible(false);

        this.repaint();
    }

    private void initComponents() {
        this.gbc = new GridBagConstraints();
        grayLabel = new JLabel();
        clientsList = panelClients.getPrincipalPanel().getFrame().getClients();
        clientsComboBox();
        searchTextField();
        searchButton();
        deleteAllClientsButton();
        yesDeleteAllClientsButton();
        noDeleteAllClientsButton();
        showHeader();
    }

    private void noDeleteAllClientsButton() {
        noDeleteAllClientsButton = new GrayButton("No");
        this.noDeleteAllClientsButton.setSize(80, 42);
        this.noDeleteAllClientsButton.setBounds(10, 10, 200, 30);
        generalGbc();
        gbc.gridx = 3;
        gbc.insets = new Insets(82, 0, 15, 80);
        this.add(this.noDeleteAllClientsButton, gbc);

        this.noDeleteAllClientsButton.addActionListener(e -> {
            showHeader();
            panelClients.showNormalClient();
        });
        noDeleteAllClientsButton.setVisible(false);
    }

    private void yesDeleteAllClientsButton() {
        yesDeleteAllClientsButton = new GrayButton("Si");
        this.yesDeleteAllClientsButton.setSize(80, 42);
        this.yesDeleteAllClientsButton.setBounds(10, 10, 50, 30);
        generalGbc();
        gbc.gridx = 2;
        gbc.insets = new Insets(82, 0, 15, 0);
        this.add(this.yesDeleteAllClientsButton, gbc);

        this.yesDeleteAllClientsButton.addActionListener(e -> {
            deleteAllClientsNoFactura();
            showHeader();
            panelClients.showNormalClient();
            panelClients.getBodyDeleteCients().showClientsYesFactura();
        });
    }

    private void deleteAllClientsNoFactura(){
        getFrame().DeleteAllClientsNoFactura();
        getFrame().saveAllLists();
        clientsList = getFrame().getClients();
        setListClients(clientsList);
    }

    private void deleteAllClientsButton() {
        grayLabel.setVisible(false);
        deleteAllClientsButton = new GrayButton("Eliminar todos los clientes");
        this.deleteAllClientsButton.setSize(80, 42);
        this.deleteAllClientsButton.setBounds(10, 10, 50, 30);
        generalGbc();
        gbc.gridx = 3;
        gbc.insets = new Insets(82, 0, 15, 80);
        this.add(this.deleteAllClientsButton, gbc);

        this.deleteAllClientsButton.addActionListener(e -> {
            ocultHeader();
            ocultButtons();
            showClientsNoFactura();
            showMessageDeleteAllClients();
        });
    }
    private void ocultButtons() {
        panelClients.showDeleteClient();
    }

    private void showClientsNoFactura() {
        panelClients.getBodyDeleteCients().showClientsNoFactura();
    }

    private void showMessageDeleteAllClients() {
        searchTextField.setVisible(false);
        searchButton.setVisible(false);

        MessageDeleteAllClients = new JLabel("¿Desea eliminar todos los clientes sin factura?");
        MessageDeleteAllClients.setSize(272, 42);
        MessageDeleteAllClients.setBounds(10, 10, 200, 30);
        generalGbc();
        gbc.gridx = 1;
        gbc.insets = new Insets(82, 80, 15, 0);
        this.add(this.MessageDeleteAllClients, gbc);
    }

    private void generalGbc() {
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
    }

    public void clientsComboBox() {
        this.clientsComboBox = new JComboBox<>();
        this.clientsComboBox.setSize(272, 42);
        this.clientsComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Seleccione un cliente"}));
        this.clientsComboBox.setBounds(10, 10, 200, 30);
        generalGbc();
        gbc.insets = new Insets(82, 60, 15, 0);
        this.add(this.clientsComboBox, gbc);
        setListClients(clientsList);
        listenerComboBox();
    }

    public void listenerComboBox() {
        clientsComboBox.addActionListener(e -> {
            panelClients.getBodyClients().setSelectedClient(getSelectedClient(clientsComboBox.getSelectedIndex()));
            panelClients.getBodyClients().showClientData(getSelectedClient(clientsComboBox.getSelectedIndex()));
        });
    }

    public void searchTextField() {
        this.searchTextField = new TextFieldGray("Cliente");
        this.searchTextField.setSize(272, 42);
        this.searchTextField.setBounds(10, 10, 200, 30);
        generalGbc();
        gbc.gridx = 1;
        gbc.insets = new Insets(82, 60, 15, 0);
        this.add(this.searchTextField, gbc);
    }

    public void searchButton() {
        this.searchButton = new GrayButton("Buscar");
        this.searchButton.setSize(80, 42);
        this.searchButton.setBounds(10, 10, 200, 30);
        generalGbc();
        gbc.gridx = 2;
        gbc.insets = new Insets(82, 0, 15, 80);
        this.add(this.searchButton, gbc);

        this.searchButton.addActionListener(e -> {
            List<Person> personListOriginal = clientsList;
            if (searchTextField.getText().equals("")) {
                setListClients(personListOriginal);
            } else {
                setListClients(getFrame().getClients(searchTextField.getText()));
            }
        });
    }

    public void ocultSearch() {
        this.clientsComboBox.setVisible(false);
        this.searchTextField.setVisible(false);
        this.searchButton.setVisible(false);
        grayLabel.setSize(1013, 42);
        grayLabel.setBackground(new java.awt.Color(217, 217, 217));
        grayLabel.setOpaque(true);

        generalGbc();
        gbc.gridx = 1;
        gbc.insets = new Insets(82, 60, 15, 60);
        this.add(this.grayLabel, gbc);
        grayLabel.setVisible(true);
    }

    public void showNormal() {
        this.clientsComboBox.setVisible(true);
        this.searchTextField.setVisible(true);
        this.searchButton.setVisible(true);
        this.grayLabel.setVisible(false);
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }

    public void setListClients(List<Person> clients) {
        this.clientsComboBox.removeAllItems();
        for (Person client : clients) {
            this.clientsComboBox.addItem((client.getName() + " " + client.getLastName()));
        }
    }

    public Person getSelectedClient(int index) {
        if (index == -1) {
            return clientsList.get(0);
        }
        return clientsList.get(index);
    }

    public void setPanelClients(PanelClients panelClients) {
        this.panelClients = panelClients;
    }

    public PanelClients getPanelClients() {
        return panelClients;
    }

    public void setClientsComboBox(JComboBox<String> clientsComboBox) {
        this.clientsComboBox = clientsComboBox;
    }

    public JComboBox<String> getClientsComboBox() {
        return clientsComboBox;
    }

    public MyFrame getFrame() {
        return panelClients.getPrincipalPanel().getFrame();
    }
}
