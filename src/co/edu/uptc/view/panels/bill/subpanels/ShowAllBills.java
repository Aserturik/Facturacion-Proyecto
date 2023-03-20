package co.edu.uptc.view.panels.bill.subpanels;

import co.edu.uptc.pojo.Bill;
import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.buttons.GrayButton;
import co.edu.uptc.view.panels.PrincipalPanel;
import co.edu.uptc.view.textfield.TextFieldGray;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class ShowAllBills extends JPanel {
    private String title = "Todas las Facturas";
    private GrayButton searchButton,addButton, editButton;
    private TextFieldGray searchTextField;
    private JTable table;
    private List<Bill> listBill;
    private GridBagConstraints gbc;
    private EventsView eventsView;
    private PrincipalPanel principalPanel;
    public ShowAllBills(EventsView eventsView, PrincipalPanel principalPanel) {
        this.setEventsView(eventsView);
        this.principalPanel = principalPanel;
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
        tableHeaderTemplate(table.getTableHeader());
        tableModelTemplate();
        listBill();
        addTable();
        tableListeners();
        addSearch();
        listeners();
    }

    private void tableHeaderTemplate(JTableHeader header) {
        table.getColumnModel().getColumn(0).setHeaderValue("Facturas");
        header.setBackground(new Color(255, 255, 255));
        header.setFont(new Font("Cabin", Font.PLAIN, 20));
        header.setPreferredSize(new Dimension(306, 32));
        header.setMinimumSize(new Dimension(306, 32));
        header.setMaximumSize(new Dimension(306, 32));
        header.setReorderingAllowed(false);
        header.setResizingAllowed(false);
    }

    private void tableModelTemplate() {
        table.setBackground(new Color(217, 217, 217));
        table.setFont(new Font("Cabin", Font.PLAIN, 20));
        table.setShowGrid(false);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.setRowHeight(32);
        centerTableData();
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
        listBill = principalPanel.getFrame().getBills();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        for (int i = 0; i < listBill.size(); i++) {
            model.addRow(new Object[]{"Factura: "+listBill.get(i).getId()});
        }

        table.setModel(model);
    }

    public void addTable(){
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setSize(306,333);
        scrollPane.setMinimumSize(new Dimension(306,333));
        scrollPane.setMaximumSize(new Dimension(306,333));
        scrollPane.setPreferredSize(new Dimension(306,333));
        add(scrollPane, new GridBagConstraints(0, 0, 2, 1, 1, 20,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(40, 0, 0, 0),
                0, 0));
    }

    public void addSearch(){
        searchTextField = new TextFieldGray("Numero de la Factura");
        searchTextField.setSmall();
        searchButton = new GrayButton("Buscar");
        addButton = new GrayButton("Agregar Factura");
        editButton = new GrayButton("Editar Factura");

        add(addButton, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.SOUTH, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
                0, 0));

        add(editButton, new GridBagConstraints(1, 4, 1, 1, 1, 1,
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
        editButton.addActionListener(e -> eventsView.openEditBill(table.getSelectedRow()));
    }

    private PreviewBill getPreviewBill(){
        return principalPanel.getPanelBill().getBodyBill().getPreviewBill();
    }

    private void tableListeners(){
        table.setEditingRow(1);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    if (e.getClickCount() == 1) {
                        getPreviewBill().setBill(listBill.get(selectedRow));
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                table.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void setEventsView(EventsView eventsView) {
        this.eventsView = eventsView;
    }

    public GrayButton getSearchButton() {
        return searchButton;
    }
}
