package co.edu.uptc.view.panels.bill.subpanels;

import co.edu.uptc.view.EventsView;
import co.edu.uptc.view.buttons.GrayButton;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TableEditPanel extends JPanel {
    private JTable tableEdit;
    private JLabel addProductBill;
    private JLabel nLabel;
    private JLabel productCode;
    private JLabel quantity;
    private GrayButton addProductButton;
    private List<String> listBill;
    private EventsView eventsView;
    private JLabel productsValue, ivaValue, totalPay;
    private JLabel productsValueText, ivaValueText, totalPayText;

    public TableEditPanel(){
        this.setBackground(new Color(222));
        this.setSize(837,451);
        this.setMinimumSize(new java.awt.Dimension(837, 451));
        this.setMaximumSize(new java.awt.Dimension(837, 451));
        this.setPreferredSize(new java.awt.Dimension(837, 451));
        initComponents();
    }

    private void initComponents(){

    }
}
