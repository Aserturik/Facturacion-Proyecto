package co.edu.uptc.view.panels.products;

import co.edu.uptc.model.dinamic.UptcList;
import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.buttons.GrayButton;
import co.edu.uptc.view.panels.fathers.HeaderPanel;
import co.edu.uptc.view.textfield.TextFieldGray;

import javax.swing.*;
import java.awt.*;

public class HeaderProducts extends HeaderPanel {
    private TextFieldGray searchTextField;
    private GrayButton searchButton;
    private JComboBox<String> productsComboBox;
    private UptcList<String> productsList;
    private GridBagConstraints gbc;
    private JLabel grayLabel;
    private EventsView eventsView;

    public HeaderProducts(EventsView eventsView) {
        super();
        this.setEventsView(eventsView);
        this.setLayout(new GridBagLayout());
        this.setBackground(new java.awt.Color(255, 255, 255));
        initComponents();
    }

    private void initComponents(){
        this.gbc = new GridBagConstraints();
        grayLabel = new JLabel();
        productsComboBox();
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

    public void productsComboBox(){
        this.productsComboBox = new JComboBox<>();
        this.productsComboBox.setSize(272,42);
        this.productsComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Seleccione un producto" }));
        this.productsComboBox.setBounds(10, 10, 200, 30);
        generalGbc();
        gbc.insets = new Insets(82,60,15,0);
        this.add(this.productsComboBox, gbc);
    }

    public void searchTextField(){
        this.searchTextField = new TextFieldGray("CIU del producto");
        this.searchTextField.setSize(272,42);
        this.searchTextField.setBounds(10, 10, 200, 30);
        generalGbc();
        gbc.gridx = 1;
        gbc.insets = new Insets(82,60,15,0);
        this.add(this.searchTextField, gbc);
    }

    public void searchButton(){
        this.searchButton = new GrayButton("Buscar");
        this.searchButton.setSize(272,42);
        this.searchButton.setBounds(10, 10, 200, 30);
        generalGbc();
        gbc.gridx = 2;
        gbc.insets = new Insets(82,0,15,80);
        this.add(this.searchButton, gbc);
    }

    public void ocultSearch(){
        this.searchTextField.setVisible(false);
        this.searchButton.setVisible(false);
        this.productsComboBox.setVisible(false);
        grayLabel.setSize(1013,42);
        grayLabel.setBackground(new java.awt.Color(217, 217, 217));
        grayLabel.setOpaque(true);

        generalGbc();
        gbc.gridx = 1;
        gbc.insets = new Insets(82,60,15,60);
        this.add(this.grayLabel, gbc);
        grayLabel.setVisible(true);
    }

    public void showNormal(){
        this.searchTextField.setVisible(true);
        this.searchButton.setVisible(true);
        this.productsComboBox.setVisible(true);
        grayLabel.setVisible(false);
    }

    public TextFieldGray getSearchTextField() {
        return searchTextField;
    }

    public void setSearchTextField(TextFieldGray searchTextField) {
        this.searchTextField = searchTextField;
    }

    public GrayButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(GrayButton searchButton) {
        this.searchButton = searchButton;
    }

    public JComboBox<String> getProductsComboBox() {
        return productsComboBox;
    }

    public void setProductsComboBox(JComboBox<String> productsComboBox) {
        this.productsComboBox = productsComboBox;
    }

    public UptcList<String> getProductsList() {
        return productsList;
    }

    public void setProductsList(UptcList<String> productsList) {
        this.productsList = productsList;
    }

    public EventsView getEventsView() {
        return eventsView;
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }
}
