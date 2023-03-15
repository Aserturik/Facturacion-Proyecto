package co.edu.uptc.view.panels.bill.subpanels;

import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.buttons.GrayButton;
import co.edu.uptc.view.textfield.TextFieldGray;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShowAllBills extends JPanel {
    private String title = "Todas las Facturas";
    private GrayButton searchButton,addButton;
    private TextFieldGray searchTextField;
    private JTable table;
    private List<String> listBill;
    private GridBagConstraints gbc;
    private EventsView eventsView;
    public ShowAllBills(EventsView eventsView) {
        this.setEventsView(eventsView);
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.setSize(308,349);
        this.setMinimumSize(new java.awt.Dimension(308, 349));
        this.setMaximumSize(new java.awt.Dimension(308, 349));
        this.setPreferredSize(new java.awt.Dimension(308, 349));
        this.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();

        initComponents();
    }

    private void initComponents(){
        table = new JTable(0,1);
        tableModelTemplate();
        listBill();
        addTable();
        addSearch();
        listeners();
    }

    private void tableModelTemplate() {
        table.setEnabled(false);
        table.setBackground(new Color(217, 217, 217));
        table.setFont(new Font("Cabin", Font.PLAIN, 20));
        table.setShowGrid(false);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setRowHeight(32);
        centerTableData();
        table.getColumnModel().getColumn(0).setMaxWidth(306);

        table.setMinimumSize(new Dimension(306,333));
        table.setMaximumSize(new Dimension(306,333));
        table.setPreferredSize(new Dimension(306,333));
    }

    private void centerTableData() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);
    }

    public void listBill(){
        listBill = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int i = 0; i < 10; i++) {
            listBill.add("Factura " + i);
        }

        for (int i = 0; i < listBill.size(); i++) {
            model.addRow(new Object[]{listBill.get(i)});
        }

        table.setModel(model);
    }

    public void addTable(){
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, new GridBagConstraints(0, 0, 2, 1, 1, 20,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(40, 0, 0, 0),
                0, 0));
    }

    public void addSearch(){
        searchTextField = new TextFieldGray("Numero de la Factura");
        searchTextField.setSmall();
        searchButton = new GrayButton("Buscar");
        addButton = new GrayButton("Agregar Factura");

        add(addButton, new GridBagConstraints(0, 4, 2, 1, 1, 1,
                GridBagConstraints.SOUTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
                0, 0));

        add(searchTextField, new GridBagConstraints(0, 5, 1, 1, 1, 1,
                GridBagConstraints.SOUTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
                0, 0));

        add(searchButton, new GridBagConstraints(1, 5, 1, 1, 1, 1,
                GridBagConstraints.SOUTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
                0, 0));

    }

    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        java.awt.Graphics2D gg = (java.awt.Graphics2D) g;
        title(gg);
    }

    public void title(java.awt.Graphics2D gg) {
        gg.setColor(new java.awt.Color(217, 217, 217));
        gg.fillRect(0, 0, 308, 37);
        gg.setColor(new java.awt.Color(0, 0, 0));
        gg.setFont(new java.awt.Font("Cabin", java.awt.Font.BOLD, 24));
        gg.setRenderingHint(java.awt.RenderingHints.KEY_TEXT_ANTIALIASING, java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        gg.drawString(title, 59, 29);
    }

    private void listeners(){
        searchButton.addActionListener(e -> eventsView.searchBill());
        addButton.addActionListener(e -> eventsView.openAddBill());
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }

    public GrayButton getSearchButton() {
        return searchButton;
    }
}
