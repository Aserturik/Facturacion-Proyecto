package co.edu.uptc.view.panels.fathers;

import javax.swing.*;
import java.awt.*;

public class DefaultPanel extends JPanel {
    private HeaderPanel headerPanel;
    private BodyPanel bodyPanel;
    private FooterPanel footerPanel;
    public DefaultPanel(){
        super();
        initComponents();
    }

    private void initComponents(){
        this.headerPanel = new HeaderPanel();
        this.bodyPanel = new BodyPanel();
        this.footerPanel = new FooterPanel();
        this.add(this.headerPanel, BorderLayout.NORTH);
        this.add(this.bodyPanel, BorderLayout.CENTER);
        this.add(this.footerPanel, BorderLayout.SOUTH);
    }
}
