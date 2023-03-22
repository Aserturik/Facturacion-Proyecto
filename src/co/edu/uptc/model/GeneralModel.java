package co.edu.uptc.model;

import co.edu.uptc.pojo.Bill;
import co.edu.uptc.pojo.Buy;
import co.edu.uptc.pojo.Person;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.presenter.Contract;

import java.util.List;

public class GeneralModel implements Contract.Model{
    Contract.Presenter presenter;
    ListClients listClients;
    ListProducts listProducts;
    ListBills listBills;
    ListBuys listBuys;

    public GeneralModel(){
        listClients = new ListClients(this);
        listProducts = new ListProducts(this);
        listBuys = new ListBuys(this);
        listBills = new ListBills(this);
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
        return listProducts.getProductsClone();
    }

    @Override
    public List<Bill> getBills() {
        return listBills.getBillsClone();
    }

    @Override
    public boolean isPersonExist(boolean isAdult, String document) {
        return listClients.isSearch(isAdult, document);
    }

    @Override
    public boolean isValidDocument(String document) {
        return listClients.isValidDocument(document);
    }

    @Override
    public List<Person> getClients(String text) {
        return listClients.searchAllPersons(text);
    }

    @Override
    public List<Person> getNewClients(Person clients) {
        return listClients.getNewClients(clients);
    }

    @Override
    public boolean getEditClients(int indexOf, Person newPerson) {
        return listClients.getEditClients(indexOf, newPerson);
    }

    @Override
    public void setListClientsView(List<Person> clientsClone) {
        presenter.saveAllClients(clientsClone);
    }

    @Override
    public List<Product> getProducts(String text) {
        return listProducts.searchAllProducts(text);
    }

    @Override
    public boolean isProductExist(String ciu, String barCode) {
        return listProducts.isSearch(ciu, barCode);
    }

    @Override
    public List<Product> getNewProducts(Product newProduct) {
        return listProducts.getNewProducts(newProduct);
    }

    @Override
    public boolean isEditProduct(int index, Product newProduct) {
        return listProducts.isEditProduct(index, newProduct);
    }

    @Override
    public List<Buy> getBuys() {
        return listBuys.getBuysClone();
    }

    @Override
    public Product getProduct(String text) {
        return listProducts.searchProduct(text);
    }

    @Override
    public void DeleteAllClientsNoFactura() {
        listBills.deleteAllClientsNoFactura(getClients());
    }

    @Override
    public void setClients(List<Person> clientsInBills) {
        listClients.setClients(clientsInBills);
    }

    @Override
    public String getClientsNoFactura() {
        return listClients.getClientsNoFacturaString();
    }

    @Override
    public String getClientsYesFactura() {
        return listClients.getClientsYesFacturaString();
    }
}
