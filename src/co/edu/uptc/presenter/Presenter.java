package co.edu.uptc.presenter;

import co.edu.uptc.view.MyFrame;

public class Presenter implements Contract.Presenter {
    private Contract.Model model;
    private Contract.View view;

    @Override
    public void setView(Contract.View view){
        this.view = (MyFrame) view;
    }
    @Override
    public void setModel(Contract.Model model){
        this.model = model;
    }

}
