package co.edu.uptc.view.panels.bill;

import co.edu.uptc.view.panels.bill.subpanels.DescriptionEditPanel;
import co.edu.uptc.view.panels.bill.subpanels.TableEditPanel;
import co.edu.uptc.view.panels.fathers.BodyPanel;

import java.awt.*;

public class BodyEditBill extends BodyPanel {
    private TableEditPanel tableEditPanel;
    private DescriptionEditPanel descriptionEditPanel;
    private GridBagConstraints gbc;

    public BodyEditBill(){
        this.setLayout(new GridBagLayout());
        tableEditPanel = new TableEditPanel();
        descriptionEditPanel = new DescriptionEditPanel();
        gbc = new GridBagConstraints();
        initComponents();
    }

    private void  initComponents() {
        tableEditPanel();
        descriptionEditPanel();
    }

    private void tableEditPanel(){
        this.add(tableEditPanel,gbc);
    }

    private void descriptionEditPanel(){
        this.add(descriptionEditPanel);
    }
}
