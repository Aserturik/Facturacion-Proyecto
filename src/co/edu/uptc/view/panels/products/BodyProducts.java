package co.edu.uptc.view.panels.products;

import co.edu.uptc.view.buttons.ButtonImage;
import co.edu.uptc.view.panels.fathers.BodyPanel;
import co.edu.uptc.view.textfield.TextFieldGray;

import java.awt.*;

public class BodyProducts extends BodyPanel {
    private GridBagConstraints gbc;
    private boolean isEdit;
    private ButtonImage buttonProducts, buttonAdd, buttonEdit, buttonDelete, buttonCheck;
    private TextFieldGray textFieldCIU, textFieldBarCode,textFieldPrice,textFieldDescription;

    public BodyProducts() {
        super();
        this.setBackground(new java.awt.Color(255, 255, 255));
        this.setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();
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
    }

    public void buttonEdit(){
        this.buttonEdit = new ButtonImage("edit", true, 255,255, 255);
        generalGbc(3,0,3,15);
        gbc.insets = new Insets(80,15,15,80);
        this.add(this.buttonEdit, gbc);

        buttonEdit.addActionListener(e -> {
            setEdit(true);
            habilitateFields();
        });
    }

    public void buttonDelete(){
        this.buttonDelete = new ButtonImage("delete", true, 255,255, 255);
        generalGbc(2,3,3,15);
        gbc.insets = new Insets(15,50,80,15);
        this.add(this.buttonDelete, gbc);
    }

    public void buttonCheck(){
        this.buttonCheck = new ButtonImage("chek", true, 255,255, 255);
        generalGbc(3,3  ,3,15);
        gbc.insets = new Insets(15,15,80,80);
        this.add(this.buttonCheck, gbc);

        buttonCheck.addActionListener(e -> {
            setEdit(false);
            inabiliteFields();
        });
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
}
