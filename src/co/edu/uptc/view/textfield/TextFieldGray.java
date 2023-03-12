package co.edu.uptc.view.textfield;

import co.edu.uptc.view.TextPrompt.TextPrompt;

import javax.swing.*;
import java.awt.*;

public class TextFieldGray extends JTextField {
    private String value;
    private TextPrompt placeholder;
    public TextFieldGray(){
        super();
        this.setBackground(new java.awt.Color(204, 204, 204));
        this.setFont(new java.awt.Font("Cabin", 0, 20));
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    }
    public TextFieldGray(String value){
        super();
        this.value = " " + value;
        this.setFont(new java.awt.Font("Cabin", 0, 20));
        this.setBackground(new java.awt.Color(204, 204, 204));
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        placeholder = new TextPrompt(value, this);
        placeholder.changeAlpha(0.6f);
        placeholder.changeStyle(Font.ITALIC);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if(enabled){
            this.setBackground(new java.awt.Color(204, 204, 204));
            this.setFont(new java.awt.Font("Cabin", 0, 24));
            this.setForeground(new java.awt.Color(0, 0, 0,100));
            this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        }else{
            this.setBackground(new java.awt.Color(204, 204, 204));
            this.setFont(new java.awt.Font("Cabin", 0, 24));
            this.setForeground(new java.awt.Color(0, 0, 0));
            this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        }
    }

    public void setBig(){
        this.setSize(312,35);
        this.setPreferredSize(new Dimension(312,35));
        this.setMaximumSize(new Dimension(312,35));
        this.setMinimumSize(new Dimension(312,35));
    }

    public void getValue(){
        this.value = this.getText();
    }
}
