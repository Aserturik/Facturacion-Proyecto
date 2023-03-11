package co.edu.uptc.view.buttons;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class CustomButtonUI extends BasicButtonUI {
    private final Color customColorPrimary; //Color para el borde o el relleno del botón
    private final Color customColorSecondary; //Color para el relleno o borde del botón


    public CustomButtonUI(Color customColorPrimary, Color customColorSecondary) {
        super();
        this.customColorPrimary = customColorPrimary;
        this.customColorSecondary = customColorSecondary;
    }

    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        //Render para que no se vea tan pixelado
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Color y dibujo del relleno del botón
        g2d.setColor(customColorPrimary);
        g2d.fill(new RoundRectangle2D.Double(1, 1, c.getWidth() - 1, c.getHeight() - 1, 13, 13));
        //Color y dibujo del contorno del botón
        g2d.setColor(customColorSecondary);
        g2d.draw(new RoundRectangle2D.Double(0, 0, c.getWidth() - 1, c.getHeight() - 1, 13, 13));
        super.paint(g2d, c);
    }
}
