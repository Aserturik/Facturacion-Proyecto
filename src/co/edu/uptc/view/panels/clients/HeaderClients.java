package co.edu.uptc.view.panels.clients;

import co.edu.uptc.model.dinamic.UptcList;
import co.edu.uptc.view.buttons.GrayButton;
import co.edu.uptc.view.panels.fathers.HeaderPanel;
import co.edu.uptc.view.textfield.TextFieldGray;

import javax.swing.*;
import java.awt.*;

public class HeaderClients extends HeaderPanel {
    private TextFieldGray searchTextField;
    private GrayButton searchButton;
    private JComboBox<String> clientsComboBox;
    private UptcList<String> clientsList;
    private GridBagConstraints gbc;
    public HeaderClients() {
        super();
        this.setLayout(new GridBagLayout());
        this.setBackground(new java.awt.Color(255, 255, 255));
        initComponents();
    }

    private void initComponents(){
        this.gbc = new GridBagConstraints();
        clientsComboBox();
        searchTextField();
        searchButton();
    }

    private void generalGbc(){
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
    }

    public void clientsComboBox(){
        this.clientsComboBox = new JComboBox<>();
        this.clientsComboBox.setSize(272,42);
        this.clientsComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Seleccione un cliente" }));
        this.clientsComboBox.setBounds(10, 10, 200, 30);
        generalGbc();
        gbc.insets = new Insets(82,60,15,0);
        this.add(this.clientsComboBox, gbc);
    }

    public void searchTextField(){
        this.searchTextField = new TextFieldGray("Documento del cliente");
        this.searchTextField.setSize(272,42);
        this.searchTextField.setBounds(10, 10, 200, 30);
        generalGbc();
        gbc.gridx = 1;
        gbc.insets = new Insets(82,60,15,0);
        this.add(this.searchTextField, gbc);
    }

    public void searchButton(){
        this.searchButton = new GrayButton("Buscar");
        this.searchButton.setSize(80,42);
        this.searchButton.setBounds(10, 10, 200, 30);
        generalGbc();
        gbc.gridx = 2;
        gbc.insets = new Insets(82,0,15,80);
        this.add(this.searchButton, gbc);
    }
}
