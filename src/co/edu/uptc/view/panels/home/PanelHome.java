package co.edu.uptc.view.panels.home;
import co.edu.uptc.view.panels.fathers.DefaultPanel;

public class PanelHome extends DefaultPanel {
    private BodyHome bodyPanelHome;
    public PanelHome() {
        super();
        header();
        body();
        paintComponents(getGraphics());
    }

    public void header(){
        super.getHeaderPanel().setBackground(new java.awt.Color(255, 255, 255));
        super.getHeaderPanel().setTitle("BIENVENIDO");
    }

    public void body() {
        bodyPanelHome = new BodyHome();
        this.setBodyPanel(bodyPanelHome);
        this.add(this.getBodyPanel());
    }
}
