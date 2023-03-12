package co.edu.uptc.view.panels.home;
import co.edu.uptc.view.panels.fathers.DefaultPanel;

public class PanelHome extends DefaultPanel {
    private BodyHome bodyPanelHome;
    private HeaderHome headerPanelHome;
    public PanelHome() {
        super();
        headerPanelHome = new HeaderHome();
        bodyPanelHome = new BodyHome();
        header();
        body();
    }

    public void header(){
        this.setHeaderPanel(headerPanelHome);
        this.add(this.getHeaderPanel(), java.awt.BorderLayout.NORTH);
    }

    public void body() {
        this.setBodyPanel(bodyPanelHome);
        this.add(this.getBodyPanel(), java.awt.BorderLayout.CENTER);
    }
}
