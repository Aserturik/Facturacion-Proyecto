package co.edu.uptc.model;

import co.edu.uptc.presenter.Contract;

public class GeneralModel implements Contract.Model{
    Contract.Presenter presenter;

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }
}
