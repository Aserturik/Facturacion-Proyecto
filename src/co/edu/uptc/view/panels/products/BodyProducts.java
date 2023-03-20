package co.edu.uptc.view.panels.products;

import co.edu.uptc.pojo.Product;
import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.MyFrame;
import co.edu.uptc.view.buttons.ButtonImage;
import co.edu.uptc.view.panels.fathers.BodyPanel;
import co.edu.uptc.view.textfield.TextFieldGray;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BodyProducts extends BodyPanel {
    private GridBagConstraints gbc;
    private boolean isAddProduct;
    private boolean isEdit;
    private ButtonImage buttonProducts, buttonAdd, buttonEdit, buttonDelete, buttonCheck;
    private TextFieldGray textFieldCIU, textFieldBarCode,textFieldPrice,textFieldDescription;
    private PanelProducts panelProducts;
    private EventsView eventsView;
    private Product productSelected;
    private boolean isModeEdit;
    private Product newProduct;
    private List<Product> products;

    public BodyProducts(EventsView eventsView,PanelProducts panelProducts) {
        super();
        this.setEventsView(eventsView);
        this.setPanelProducts(panelProducts);
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();
        this.products = panelProducts.getPrincipalPanel().getFrame().getProducts();
        initComponents();
    }

    public void generalGbc(int x, int y,int height,int insets){
        gbc.gridy = y;
        gbc.gridx = x;
        gbc.gridwidth = 1;
        gbc.gridheight = height;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(insets,insets,insets,insets);
    }

    public void initComponents(){
        buttonProducts();
        textFieldCIU();
        textFieldBarCode();
        textFieldPrice();
        textFieldDescription();
        buttonAdd();
        buttonEdit();
        buttonDelete();
        buttonCheck();
    }

    public void buttonProducts(){
        this.buttonProducts = new ButtonImage("shop", false, 255,255, 255);
        generalGbc(0,0,6,15);
        gbc.insets = new Insets(80,80,80,15);
        this.add(this.buttonProducts, gbc);
    }

    public void showProductData(Product productSelected) {
        this.productSelected = productSelected;
        this.textFieldCIU.setText(""+productSelected.getCiu());
        this.textFieldBarCode.setText(productSelected.getBarCode());
        this.textFieldPrice.setText(""+productSelected.getPrice());
        this.textFieldDescription.setText(productSelected.getDescription());
    }

    public void textFieldCIU(){
        this.textFieldCIU = new TextFieldGray("Código CIU");
        this.textFieldCIU.setBig();
        generalGbc(1,0,1,5);
        this.add(this.textFieldCIU, gbc);
    }

    public void textFieldBarCode(){
        this.textFieldBarCode = new TextFieldGray("Código de barras");
        this.textFieldBarCode.setBig();
        generalGbc(1,1,1,5);
        this.add(this.textFieldBarCode, gbc);
    }

    public void textFieldPrice(){
        this.textFieldPrice = new TextFieldGray("Precio");
        this.textFieldPrice.setBig();
        generalGbc(1,2,1,5);
        this.add(this.textFieldPrice, gbc);
    }

    public void textFieldDescription(){
        this.textFieldDescription = new TextFieldGray("Descripción");
        this.textFieldDescription.setBig();
        generalGbc(1,3,3,5);
        this.add(this.textFieldDescription, gbc);
    }

    public void buttonAdd(){
        this.buttonAdd = new ButtonImage("addProducts", true, 255,255, 255);
        generalGbc(2,0,3,15);
        gbc.insets = new Insets(80,50,15,15);
        this.add(this.buttonAdd, gbc);

        buttonAdd.addActionListener(e -> {
            setEdit(true);
            setModeEdit(false);
            habilitateFields();
            clearFields();
            setAddProduct(true);
            eventsView.ocultHeaderProducts();
            getMyFrame().disableFooterButtons();
        });
    }
    
    public void setAddProduct(boolean addProduct) {
        this.isAddProduct = addProduct;
    }

    public void clearFields(){
        this.textFieldCIU.setText("");
        this.textFieldBarCode.setText("");
        this.textFieldPrice.setText("");
        this.textFieldDescription.setText("");
    }

    public void buttonEdit(){
        this.buttonEdit = new ButtonImage("edit", true, 255,255, 255);
        generalGbc(3,0,3,15);
        gbc.insets = new Insets(80,15,15,80);
        this.add(this.buttonEdit, gbc);

        buttonEdit.addActionListener(e -> {
            setEdit(true);
            habilitateFields();
            eventsView.ocultHeaderProducts();
        });
    }

    public void buttonDelete(){
        this.buttonDelete = new ButtonImage("delete", true, 255,255, 255);
        generalGbc(2,3,3,15);
        gbc.insets = new Insets(15,50,80,15);
        this.add(this.buttonDelete, gbc);

        buttonDelete.addActionListener(e -> {
            optionPaneDelete();
        });
    }

    private void optionPaneDelete() {
        int option = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el producto?", "Eliminar producto", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            deleteProduct();
        }else{
            JOptionPane.showMessageDialog(null, "No se eliminó el producto");
        }
    }

    private void deleteProduct(){
        products.remove(productSelected);
        eventsView.showNormalHeaderProducts();
        panelProducts.getHeaderProducts().setListProducts(products);
        JOptionPane.showMessageDialog(null, "Se eliminó el producto");
    }

    public void buttonCheck(){
        this.buttonCheck = new ButtonImage("chek", true, 255,255, 255);
        generalGbc(3,3  ,3,15);
        gbc.insets = new Insets(15,15,80,80);
        this.add(this.buttonCheck, gbc);

        buttonCheck.addActionListener(e -> {
            if(isValidData() && isAddProduct && !isProductExist() && !isModeEdit){
                // Agregar producto
                addProduct();
            }else if(isValidData() && isModeEdit && isEdit && !isProductExist()){
                // Editar producto
                editProduct();
            }
            eventsView.showNormalHeaderProducts();
            inabiliteFields();
            getMyFrame().enableFooterButtons();
            setEdit(false);
            setAddProduct(false);
        });
    }

    private void addProduct(){
        newProduct = getNewProduct();
        getMyFrame().setProducts(getMyFrame().getNewProducts(newProduct));
        panelProducts.getHeaderProducts().setListProducts(getMyFrame().getProducts());
        JOptionPane.showMessageDialog(null, "Producto agregado correctamente", "Agregado", JOptionPane.INFORMATION_MESSAGE);
    }

    private void editProduct(){
        newProduct = getNewProduct();
        int index = panelProducts.getHeaderProducts().getProductsComboBox().getSelectedIndex();
        productSelected = products.get(index);
        boolean isEdit = getMyFrame().isEditProduct(index, newProduct);
        // luego validar si el producto esta referenciado en una factura
        products = getMyFrame().getProducts();
        panelProducts.getHeaderProducts().setListProducts(products);
        if(isEdit){
            JOptionPane.showMessageDialog(null, "Producto editado correctamente", "Editado", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Producto referenciado, no editable", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Product getNewProduct(){
        newProduct = new Product();
        newProduct.setCiu(textFieldCIU.getText());
        newProduct.setBarCode(textFieldBarCode.getText());
        newProduct.setPrice(Double.parseDouble(textFieldPrice.getText()));
        newProduct.setDescription(textFieldDescription.getText());
        return newProduct;
    }

    private boolean isValidData(){
        if(textFieldCIU.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo CIU no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(textFieldBarCode.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo código de barras no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(textFieldPrice.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo precio no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!getMyFrame().isValidDocument(textFieldPrice.getText())) {
            JOptionPane.showMessageDialog(null, "El precio no es valido");
            return false;
        }

        if(textFieldDescription.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo descripción no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isProductExist(){
        String ciu = textFieldCIU.getText();
        String barCode = textFieldBarCode.getText();
        if (getMyFrame().isProductExist(ciu,barCode)){
            JOptionPane.showMessageDialog(null, "CIU o Codigo de barras Existente", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    public void habilitateFields(){
        this.textFieldCIU.setEditable(true);
        this.textFieldBarCode.setEditable(true);
        this.textFieldPrice.setEditable(true);
        this.textFieldDescription.setEditable(true);
    }

    public void inabiliteFields(){
        this.textFieldCIU.setEditable(false);
        this.textFieldBarCode.setEditable(false);
        this.textFieldPrice.setEditable(false);
        this.textFieldDescription.setEditable(false);
    }
    public void setEdit(boolean edit) {
        isEdit = edit;
        if (isEdit){
            this.buttonEdit.opacity(0.5f);
            this.buttonDelete.opacity(0.5f);
            this.buttonAdd.opacity(0.5f);
            this.buttonCheck.opacity(1f);
        }else {
            this.buttonEdit.opacity(1f);
            this.buttonDelete.opacity(1f);
            this.buttonAdd.opacity(1f);
            this.buttonCheck.opacity(0.5f);
        }
    }

    public void setModeEdit(boolean modeEdit){
        isModeEdit = modeEdit;
    }

    // Setters and Getters

    public void setEventsView(EventsView eventsView){
        this.eventsView = eventsView;
    }

    public void setPanelProducts(PanelProducts panelProducts){
        this.panelProducts = panelProducts;
    }

    public PanelProducts getPanelProducts(){
        return this.panelProducts;
    }

    private MyFrame getMyFrame() {
        return panelProducts.getFrame();
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }

    public boolean isEdit() {
        return isEdit;
    }

    public ButtonImage getButtonProducts() {
        return buttonProducts;
    }

    public void setButtonProducts(ButtonImage buttonProducts) {
        this.buttonProducts = buttonProducts;
    }

    public ButtonImage getButtonAdd() {
        return buttonAdd;
    }

    public void setButtonAdd(ButtonImage buttonAdd) {
        this.buttonAdd = buttonAdd;
    }

    public ButtonImage getButtonEdit() {
        return buttonEdit;
    }

    public void setButtonEdit(ButtonImage buttonEdit) {
        this.buttonEdit = buttonEdit;
    }

    public ButtonImage getButtonDelete() {
        return buttonDelete;
    }

    public void setButtonDelete(ButtonImage buttonDelete) {
        this.buttonDelete = buttonDelete;
    }

    public ButtonImage getButtonCheck() {
        return buttonCheck;
    }

    public void setButtonCheck(ButtonImage buttonCheck) {
        this.buttonCheck = buttonCheck;
    }

    public TextFieldGray getTextFieldCIU() {
        return textFieldCIU;
    }

    public void setTextFieldCIU(TextFieldGray textFieldCIU) {
        this.textFieldCIU = textFieldCIU;
    }

    public TextFieldGray getTextFieldBarCode() {
        return textFieldBarCode;
    }

    public void setTextFieldBarCode(TextFieldGray textFieldBarCode) {
        this.textFieldBarCode = textFieldBarCode;
    }

    public TextFieldGray getTextFieldPrice() {
        return textFieldPrice;
    }

    public void setTextFieldPrice(TextFieldGray textFieldPrice) {
        this.textFieldPrice = textFieldPrice;
    }

    public TextFieldGray getTextFieldDescription() {
        return textFieldDescription;
    }

    public void setTextFieldDescription(TextFieldGray textFieldDescription) {
        this.textFieldDescription = textFieldDescription;
    }

    @Override
    public EventsView getEventsView() {
        return eventsView;
    }

    public Product getProductSelected() {
        return productSelected;
    }

    public void setProductSelected(Product productSelected) {
        this.productSelected = productSelected;
    }
}
