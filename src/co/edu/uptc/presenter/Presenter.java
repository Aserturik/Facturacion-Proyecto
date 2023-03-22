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
    private List<Buy> buys;

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
    public void loadBuys() {
        buys = model.getBuys();
        view.setBuys(buys);
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
        view.setClients(clients);
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
    @Override
    public boolean isPersonExist(boolean isAdult, String document){
        return model.isPersonExist(isAdult, document);
    }

    @Override
    public boolean isValidDocument(String document) {
        return model.isValidDocument(document);
    }

    @Override
    public List<Person> getClients(String text) {
        return model.getClients(text);
    }

    @Override
    public List<Person> getNewClients(Person newPerson) {
        return model.getNewClients(newPerson);
    }

    @Override
    public boolean getEditClients(int indexOf, Person newPerson) {
        return model.getEditClients(indexOf, newPerson);
    }

    @Override
    public List<Product> getProducts(String text) {
        return model.getProducts(text);
    }

    @Override
    public boolean isProductExist(String ciu, String barCode) {
        return model.isProductExist(ciu, barCode);
    }

    @Override
    public List<Product> getNewProducts(Product newProduct) {
        return model.getNewProducts(newProduct);
    }

    @Override
    public boolean isEditProduct(int index, Product newProduct) {
        return model.isEditProduct(index, newProduct);
    }

    @Override
    public Product getProduct(String text) {
        return model.getProduct(text);
    }

    @Override
    public void DeleteAllClientsNoFactura() {
        model.DeleteAllClientsNoFactura();
    }

    @Override
    public String getClientsNoFactura() {
        return model.getClientsNoFactura();
    }

    @Override
    public String getClientsYesFactura() {
        return model.getClientsYesFactura();
    }

}
