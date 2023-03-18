package co.edu.uptc.presenter;

import co.edu.uptc.pojo.*;
import co.edu.uptc.view.MyFrame;

import java.util.List;

public class Presenter implements Contract.Presenter {
    private Contract.Model model;
    private Contract.View view;
    private List<Person> clients;
    private List<Product> products;
    private List<Bill> bills;

    @Override
    public void setView(Contract.View view) {
        this.view = (MyFrame) view;
    }

    @Override
    public void setModel(Contract.Model model) {
        this.model = model;
    }

    @Override
    public void loadClients() {
        clients = model.getClients();
        view.setClients(clients);
    }

    @Override
    public void loadProducts() {
        products = model.getProducts();
        view.setProducts(products);
    }

    @Override
    public void loadBills() {
        bills = model.getBills();
        view.setBills(bills);
    }

    @Override
    public void saveClient(Person client) {

    }

    @Override
    public void saveProduct(Product product) {

    }

    @Override
    public void saveBill(Bill bill) {

    }

    @Override
    public void saveAllClients(List<Person> clients) {

    }

    @Override
    public void saveAllProducts(List<Product> products) {

    }

    @Override
    public void saveAllBills(List<Bill> bills) {

    }

    @Override
    public boolean deleteClient(Person client) {
        return false;
    }

    @Override
    public boolean deleteProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteBill(Bill bill) {
        return false;
    }
}
