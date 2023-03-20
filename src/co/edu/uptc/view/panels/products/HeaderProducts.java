package co.edu.uptc.view.panels.products;
import co.edu.uptc.pojo.Person;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.MyFrame;
import co.edu.uptc.view.buttons.GrayButton;
import co.edu.uptc.view.panels.fathers.HeaderPanel;
import co.edu.uptc.view.textfield.TextFieldGray;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HeaderProducts extends HeaderPanel {
    private TextFieldGray searchTextField;
    private GrayButton searchButton;
    private JComboBox<String> productsComboBox;
    private List<Product> products;
    private GridBagConstraints gbc;
    private JLabel grayLabel;
    private PanelProducts panelProducts;
    private EventsView eventsView;

    public HeaderProducts(EventsView eventsView, PanelProducts panelProducts) {
        super();
        this.panelProducts = panelProducts;
        this.setEventsView(eventsView);
        this.setLayout(new GridBagLayout());
        this.setBackground(new java.awt.Color(255, 255, 255));
        initComponents();
    }

    private void initComponents(){
        this.gbc = new GridBagConstraints();
        grayLabel = new JLabel();
        this.products = panelProducts.getPrincipalPanel().getFrame().getProducts();

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
        setListProducts(products);
        listenersComboBox();
    }

    public void setListProducts(List<Product> products){
        this.productsComboBox.removeAllItems();
        for (Product product : products) {
            this.productsComboBox.addItem(product.getDescription());
        }
    }

    public Product getSelectedProduct(int index){
        if(index == -1){
            return products.get(0);
        }
        return products.get(index);
    }

    public void listenersComboBox() {
        this.productsComboBox.addActionListener(e -> {
            panelProducts.getBodyProducts().setProductSelected(getSelectedProduct(productsComboBox.getSelectedIndex()));
            panelProducts.getBodyProducts().showProductData(getSelectedProduct(productsComboBox.getSelectedIndex()));
        });
    }

    public void searchTextField(){
        this.searchTextField = new TextFieldGray("Descripción del producto");
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

        this.searchButton.addActionListener(e -> {
            List<Product> productsListOriginal = products;
            if (searchTextField.getText().equals("CIU del producto") || searchTextField.getText().equals("")) {
                setListProducts(productsListOriginal);
            } else {
                setListProducts(getFrame().getProducts(searchTextField.getText()));
            }
        });
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

    public EventsView getEventsView() {
        return eventsView;
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }

    public MyFrame getFrame() {
        return panelProducts.getFrame();
    }
}
