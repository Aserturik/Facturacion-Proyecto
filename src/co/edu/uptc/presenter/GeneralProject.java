package co.edu.uptc.presenter;

import co.edu.uptc.model.GeneralModel;
import co.edu.uptc.view.MyFrame;

public class GeneralProject {
    Contract.View view;
    Contract.Presenter presenter;
    Contract.Model model;

    public GeneralProject(){
        createMVP();
        view.setPresenter(presenter);
        presenter.setView(view);
        presenter.setModel(model);
        model.setPresenter(presenter);
    }

    private void createMVP(){
        view = new MyFrame();
        model = new GeneralModel();
        presenter = new Presenter();
    }

    public void runProject(){
        view.start();
    }
}
