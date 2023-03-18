package co.edu.uptc.model;

import co.edu.uptc.pojo.Bill;
import co.edu.uptc.pojo.Person;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.presenter.Contract;

import java.util.List;

public class GeneralModel implements Contract.Model{
    Contract.Presenter presenter;
    ListClients listClients;

    public GeneralModel(){
        listClients = new ListClients();
    }

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public List<Person> getClients() {
        return listClients.getClientsClone();
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public List<Bill> getBills() {
        return null;
    }
}
