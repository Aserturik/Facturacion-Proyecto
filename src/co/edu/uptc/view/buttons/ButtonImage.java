package co.edu.uptc.view.buttons;

import javax.swing.*;
import java.awt.*;

public class ButtonImage extends JButton {
    private ImageIcon imageIcon;
    private static final long serialVersionUID = 1L;
    private Graphics2D g2d;
    public ButtonImage(String path, boolean isSmall, int r, int g, int b) {
        ImageIcon icon = new ImageIcon("resources/pictures/"+path+".png");
        if(isSmall){
            this.setSize(115,98);
            imageIcon = new ImageIcon(icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        }else{
            this.setSize(197,202);
            imageIcon = new ImageIcon(icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        }
        this.setIcon(imageIcon);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setContentAreaFilled(false);
        this.setBorderPainted(false);
        CustomButtonUI customButtonUI = new CustomButtonUI(new Color(r,g,b), Color.BLACK);
        this.setUI(customButtonUI);
    }
    public ButtonImage(String path, int whith, int height){
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ImageIcon icon = new ImageIcon("resources/img/"+path+".png");
        this.setSize(whith,height);
        imageIcon = new ImageIcon(icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
        this.setIcon(imageIcon);
        setContentAreaFilled(false);
        this.setBorderPainted(false);getAlignmentX();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2d = g2;
        super.paintComponent(g2);
    }

    public void opacity(float opacity){
        if(opacity == 1){
            this.setEnabled(true);
        }else {
            this.setEnabled(false);
        }
    }
}
