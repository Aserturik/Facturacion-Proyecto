package co.edu.uptc.view.panels.bill.subpanels;

import co.edu.uptc.view.EventsView;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PreviewBill extends JPanel {
    private EventsView eventsView;
    private final String title = "Previsualización de la factura";
    private final String nameClient = "Cliente: ";
    private String nameText = "";
    private String productsValueText = "";
    private String ivaValueText = "";
    private String totalValueText = "";

    private final String billNumber = "Número de factura: ";
    private String billNumberText = "";
    private final String date = "dd/mm/aaaa";
    private JTable tableBill;
    private List<String> listBill;
    private GridBagConstraints gbc;
    public PreviewBill(EventsView eventsView) {
        this.setEventsView(eventsView);
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.setSize(617,344);
        this.setMinimumSize(new java.awt.Dimension(617, 349));
        this.setMaximumSize(new java.awt.Dimension(617, 349));
        this.setPreferredSize(new java.awt.Dimension(617, 349));
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();

        initComponents();
    }

    private void initComponents(){
        tableBill = new JTable(0,6);
        tableHeaderTemplate(tableBill.getTableHeader());
        tableModelTemplate();
        billList();
        addTable();
    }

    private void tableHeaderTemplate(JTableHeader tableHeader){
        tableBill.getColumnModel().getColumn(0).setHeaderValue("N");
        tableBill.getColumnModel().getColumn(1).setHeaderValue("CIU");
        tableBill.getColumnModel().getColumn(2).setHeaderValue("Descripción");
        tableBill.getColumnModel().getColumn(3).setHeaderValue("Precio Unitario");
        tableBill.getColumnModel().getColumn(4).setHeaderValue("Cantidad");
        tableBill.getColumnModel().getColumn(5).setHeaderValue("Total");
        tableHeader.setFont(new Font("Cabin", Font.PLAIN, 13));
        tableHeader.setBackground(new Color(217, 217, 217));
        tableHeader.setReorderingAllowed(false);
        tableHeader.setResizingAllowed(false);
    }

    private void tableModelTemplate(){
        tableBill.setEnabled(false);
        tableBill.setRowHeight(26);
        tableBill.setShowGrid(false);
        tableBill.setShowHorizontalLines(true);
        tableBill.setShowVerticalLines(true);
        tableBill.setFont(new Font("Cabin", Font.PLAIN, 13));
        tableBill.getColumnModel().getColumn(0).setMaxWidth(50);
        tableBill.getColumnModel().getColumn(1).setMaxWidth(50);
        tableBill.setBackground(new Color(255, 255, 255));
    }

    private void billList(){
        listBill = new ArrayList<>();
    }

    private void addTable(){
        JScrollPane scrollPane = new JScrollPane(tableBill);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setSize(594,200);
        scrollPane.setMinimumSize(new Dimension(this.getWidth(),26));
        scrollPane.setMaximumSize(new Dimension(this.getWidth(),26));
        scrollPane.setPreferredSize(new Dimension(this.getWidth(),26));
        add(scrollPane, new GridBagConstraints(0, 0, 2, 1, 1, 20,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(40, 0, 60, 0),
                0, 0));
    }

    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        java.awt.Graphics2D gg = (java.awt.Graphics2D) g;
        title(gg);
        rectClient(gg);
        nameText(gg);
        billNumber(gg);
        date(gg);
        productsValue(gg);
        ivaValue(gg);
        totalValue(gg);

        productsValueText(gg);
        ivaValueText(gg);
        totalValueText(gg);
    }

    private void title(java.awt.Graphics2D gg) {
        gg.setColor(new java.awt.Color(217, 217, 217));
        gg.fillRect(0, 0, 617, 37);
        gg.setColor(new java.awt.Color(0, 0, 0));
        gg.setFont(new java.awt.Font("Cabin", java.awt.Font.BOLD, 24));
        gg.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gg.drawString(title, 182, 29);
    }

    private void rectClient(Graphics2D gg){
        gg.setColor(new java.awt.Color(217, 217, 217));
        gg.fillRect(8, 49, 66, 22);
        gg.setColor(new java.awt.Color(0, 0, 0));
        gg.setFont(new java.awt.Font("Cabin", java.awt.Font.BOLD, 15));
        gg.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gg.drawString(nameClient, 10, 65);
    }

    private void nameText(Graphics2D gg){
        gg.setColor(new java.awt.Color(255, 255, 255, 255));
        gg.fillRect(76, 49, 196, 22);
        gg.setColor(new java.awt.Color(0, 0, 0));
        gg.drawRect(76, 49, 196, 22);
        gg.setFont(new java.awt.Font("Cabin", java.awt.Font.BOLD, 15));
        gg.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gg.drawString(nameText, 82, 65);
    }

    private void billNumber(Graphics2D gg){
        gg.setColor(new java.awt.Color(0, 0, 0));
        gg.setFont(new java.awt.Font("Cabin", java.awt.Font.BOLD, 15));
        gg.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gg.drawString((billNumber + billNumberText), 279, 65);
    }

    private void date(Graphics2D gg){
        gg.setColor(new java.awt.Color(0, 0, 0));
        gg.setFont(new java.awt.Font("Cabin", java.awt.Font.BOLD, 15));
        gg.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gg.drawString(date, 500, 65);
    }

    private void productsValue(Graphics2D gg){
        gg.setColor(new java.awt.Color(197, 191, 191));
        gg.fillRect(53, 295, 205, 26);
        gg.setColor(new java.awt.Color(0, 0, 0));
        gg.setFont(new java.awt.Font("Cabin", java.awt.Font.BOLD, 15));
        gg.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gg.drawString("Valor de los Productos ", 73, 315);
    }

    private void ivaValue(Graphics2D gg){
        gg.setColor(new java.awt.Color(197, 191, 191));
        gg.fillRect(268, 295, 140, 26);
        gg.setColor(new java.awt.Color(0, 0, 0));
        gg.setFont(new java.awt.Font("Cabin", java.awt.Font.BOLD, 15));
        gg.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gg.drawString("Valor del IVA ", 290, 315);
    }

    private void totalValue(Graphics2D gg){
        gg.setColor(new java.awt.Color(197, 191, 191));
        gg.fillRect(418, 295, 140, 26);
        gg.setColor(new java.awt.Color(0, 0, 0));
        gg.setFont(new java.awt.Font("Cabin", java.awt.Font.BOLD, 15));
        gg.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gg.drawString("Total a Pagar ", 440, 315);
    }

    private void productsValueText(Graphics2D gg){
        gg.setColor(new java.awt.Color(217, 217, 217));
        gg.fillRect(53, 325, 205, 26);
        gg.setColor(new java.awt.Color(0, 0, 0));
        gg.setFont(new java.awt.Font("Cabin", java.awt.Font.BOLD, 15));
        gg.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gg.drawString(productsValueText, 73, 345);
    }

    private void ivaValueText(Graphics2D gg){
        gg.setColor(new java.awt.Color(217, 217, 217));
        gg.fillRect(268, 325, 140, 26);
        gg.setColor(new java.awt.Color(0, 0, 0));
        gg.setFont(new java.awt.Font("Cabin", java.awt.Font.BOLD, 15));
        gg.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gg.drawString(ivaValueText, 290, 345);
    }

    private void totalValueText(Graphics2D gg){
        gg.setColor(new java.awt.Color(217, 217, 217));
        gg.fillRect(418, 325, 140, 26);
        gg.setColor(new java.awt.Color(0, 0, 0));
        gg.setFont(new java.awt.Font("Cabin", java.awt.Font.BOLD, 15));
        gg.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gg.drawString(totalValueText, 440, 340);
    }

    public EventsView getEventsView() {
        return eventsView;
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }

    public String getNameText() {
        return nameText;
    }

    public void setNameText(String nameText) {
        this.nameText = nameText;
    }

    public String getTitle() {
        return title;
    }

    public String getNameClient() {
        return nameClient;
    }

    public String getProductsValueText() {
        return productsValueText;
    }

    public void setProductsValueText(String productsValueText) {
        this.productsValueText = productsValueText;
    }

    public String getIvaValueText() {
        return ivaValueText;
    }

    public void setIvaValueText(String ivaValueText) {
        this.ivaValueText = ivaValueText;
    }

    public String getTotalValueText() {
        return totalValueText;
    }

    public void setTotalValueText(String totalValueText) {
        this.totalValueText = totalValueText;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public String getBillNumberText() {
        return billNumberText;
    }

    public void setBillNumberText(String billNumberText) {
        this.billNumberText = billNumberText;
    }

    public String getDate() {
        return date;
    }

    public JTable getTableBill() {
        return tableBill;
    }

    public void setTableBill(JTable tableBill) {
        this.tableBill = tableBill;
    }

    public List<String> getListBill() {
        return listBill;
    }

    public void setListBill(List<String> listBill) {
        this.listBill = listBill;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }
}
