package co.edu.uptc.view.panels.bill.subpanels;

import co.edu.uptc.model.dinamic.UptcList;
import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.buttons.GrayButton;
import co.edu.uptc.view.textfield.TextFieldGray;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class TableEditPanel extends JPanel {
    private JTable tableEdit;
    private JLabel addProductLabel;
    private TextFieldGray productCode;
    private TextFieldGray quantity;
    private GrayButton addProductButton;
    private List<String> listBill;
    private EventsView eventsView;
    private JLabel productsValue, ivaValue, totalPay;
    private JLabel productsValueText, ivaValueText, totalPayText;
    private GridBagConstraints gbc;

    public TableEditPanel(EventsView eventsView) {
        this.setEventsView(eventsView);
        this.setBackground(new Color(255, 255, 255));
        this.setSize(837,451);
        this.setMinimumSize(new java.awt.Dimension(837, 451));
        this.setMaximumSize(new java.awt.Dimension(837, 451));
        this.setPreferredSize(new java.awt.Dimension(837, 451));
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        initComponents();
    }

    private void initComponents(){
        tableEdit = new JTable(0,5);
        tableHeaderTemplate(tableEdit.getTableHeader());
        tableModelTemplate();
        billList();
        addTable();
        addProductBill();
        values();
    }

    private void tableHeaderTemplate(JTableHeader tableHeader){
        tableEdit.getColumnModel().getColumn(0).setHeaderValue("N");
        tableEdit.getColumnModel().getColumn(1).setHeaderValue("Codigo Producto");
        tableEdit.getColumnModel().getColumn(2).setHeaderValue("Precio Unitario");
        tableEdit.getColumnModel().getColumn(3).setHeaderValue("Cantidad");
        tableEdit.getColumnModel().getColumn(4).setHeaderValue("Borrar");
        tableHeader.setFont(new Font("Cabin", Font.PLAIN, 13));
        tableHeader.setBackground(new Color(217, 217, 217));
        tableHeader.setReorderingAllowed(false);
        tableHeader.setResizingAllowed(false);
    }
    
    private void tableModelTemplate(){
        tableEdit.setEnabled(false);
        tableEdit.setRowHeight(26);
        tableEdit.setShowGrid(false);
        tableEdit.setShowHorizontalLines(true);
        tableEdit.setShowVerticalLines(true);
        tableEdit.setFont(new Font("Cabin", Font.PLAIN, 13));
        tableEdit.setBackground(new Color(255, 255, 255));
    }

    private void billList(){
        listBill = new UptcList<>();
    }

    private void addTable(){
        JScrollPane scrollPane = new JScrollPane(tableEdit);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setSize(755,267);
        scrollPane.setMinimumSize(new Dimension(755,267));
        scrollPane.setMaximumSize(new Dimension(755,267));
        scrollPane.setPreferredSize(new Dimension(755, 267));
        add(scrollPane, new GridBagConstraints(0, 0, 3, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(15, 56, 0, 26),
                0, 0));
    }

    // Elementos del Footer

    private JLabel getFormatLabel(JLabel label,int whidth, int heigth){
        label.setSize(whidth,heigth);
        label.setPreferredSize(new Dimension(whidth,heigth));
        label.setMinimumSize(new Dimension(whidth,heigth));
        label.setMaximumSize(new Dimension(whidth,heigth));
        label.setOpaque(true);
        label.setFont(new java.awt.Font("Cabin", 1, 24));
        label.setBackground(new java.awt.Color(217, 217, 217));
        label.setForeground(new java.awt.Color(0, 0, 0));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    private void addProductBill(){
        addProductLabel();
        productCode();
        quantity();
        addProductButton();
    }

    private void addProductLabel(){
        addProductLabel = new JLabel("Agregar Producto");
        addProductLabel = getFormatLabel(addProductLabel, 605, 21);
        addProductLabel.setFont(new Font("Cabin", Font.PLAIN, 13));
        addProductLabel.setBackground(new Color(197, 191, 191));
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(15, 0, 0, 0);
        add(addProductLabel,gbc);
    }

    private void productCode(){
        productCode = new TextFieldGray("Codigo Producto");
        productCode.setSmall();
        productCode.setPreferredSize(new Dimension(202, 21));
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 115, 0, 0);
        add(productCode,gbc);
    }

    private void quantity(){
        quantity = new TextFieldGray("Cantidad");
        quantity.setSmall();
        quantity.setPreferredSize(new Dimension(202, 21));
        gbc.gridy = 2;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(quantity,gbc);
    }

    private void addProductButton(){
        addProductButton = new GrayButton("Añadir a la factura");
        addProductButton.setSize(202, 21);
        addProductButton.setPreferredSize(new Dimension(202, 21));
        addProductButton.setMinimumSize(new Dimension(202, 21));
        addProductButton.setMaximumSize(new Dimension(202, 21));
        addProductButton.setFont(new Font("Cabin", Font.PLAIN, 15));
        gbc.gridy = 2;
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 0, 115);
        add(addProductButton,gbc);
    }

    public void values() {
        productsValueText();
        productsValue();
        ivaValueText();
        ivaValue();
        totalPayText();
        totalPay();
    }

    private void productsValueText() {
        productsValueText = new JLabel("Productos");
        productsValueText = getFormatLabel(productsValueText, 202, 21);
        productsValueText.setFont(new Font("Cabin", Font.PLAIN, 13));
        productsValueText.setBackground(new Color(197, 191, 191));
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 115, 0, 0);
        add(productsValueText,gbc);
    }

    private void productsValue() {
        productsValue = new JLabel("0");
        productsValue = getFormatLabel(productsValue, 202, 21);
        productsValue.setFont(new Font("Cabin", Font.PLAIN, 13));
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 115, 0, 0);
        add(productsValue,gbc);
    }

    private void ivaValueText() {
        ivaValueText = new JLabel("IVA");
        ivaValueText = getFormatLabel(ivaValueText, 202, 21);
        ivaValueText.setFont(new Font("Cabin", Font.PLAIN, 13));
        ivaValueText.setBackground(new Color(197, 191, 191));
        gbc.gridy = 3;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 0, 0, 0);
        add(ivaValueText,gbc);
    }

    private void ivaValue() {
        ivaValue = new JLabel("0");
        ivaValue = getFormatLabel(ivaValue, 202, 21);
        ivaValue.setFont(new Font("Cabin", Font.PLAIN, 13));
        gbc.gridy = 4;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(ivaValue,gbc);
    }

    private void totalPayText() {
        totalPayText = new JLabel("Total a pagar");
        totalPayText = getFormatLabel(totalPayText, 202, 21);
        totalPayText.setFont(new Font("Cabin", Font.PLAIN, 13));
        totalPayText.setBackground(new Color(197, 191, 191));
        gbc.gridy = 3;
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 0, 0, 115);
        add(totalPayText,gbc);
    }

    private void totalPay() {
        totalPay = new JLabel("0");
        totalPay = getFormatLabel(totalPay, 202, 21);
        totalPay.setFont(new Font("Cabin", Font.PLAIN, 13));
        gbc.gridy = 4;
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 0, 115);
        add(totalPay,gbc);
    }

    public void addRow(String[] row){
        DefaultTableModel model = (DefaultTableModel) tableEdit.getModel();
        model.addRow(row);
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }
}
