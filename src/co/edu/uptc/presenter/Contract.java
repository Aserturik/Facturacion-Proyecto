package co.edu.uptc.presenter;

import co.edu.uptc.pojo.Bill;
import co.edu.uptc.pojo.Person;
import co.edu.uptc.pojo.Product;

import java.util.List;

public interface Contract {
    interface View{
        void setPresenter(Presenter presenter);
        void start();
        void setClients(List<Person> clients);
        void setProducts(List<Product> products);
        void setBills(List<Bill> bills);
    }

    interface Presenter{
        void setView(View view);
        void setModel(Model model);
        void loadClients();
        void loadProducts();
        void loadBills();
        void saveClient(Person client);
        void saveProduct(Product product);
        void saveBill(Bill bill);
        void saveAllClients(List<Person> clients);
        void saveAllProducts(List<Product> products);
        void saveAllBills(List<Bill> bills);
        boolean deleteClient(Person client);
        boolean deleteProduct(Product product);
        boolean deleteBill(Bill bill);
        boolean isPersonExist(boolean isAdult, String document);
        boolean isValidDocument(String document);
        List<Person> getClients(String text);

        List<Person> getNewClients(Person clients);

        boolean getEditClients(int indexOf, Person newPerson);

        List<Product> getProducts(String text);

        boolean isProductExist(String ciu, String barCode);

        List<Product> getNewProducts(Product products);

        boolean isEditProduct(int index, Product newProduct);
    }

    interface Model{
        void setPresenter(Presenter presenter);
        List<Person> getClients();
        List<Product> getProducts();
        List<Bill> getBills();
        boolean isPersonExist(boolean isAdult, String document);
        boolean isValidDocument(String document);

        List<Person> getClients(String text);

        List<Person> getNewClients(Person newPerson);

        boolean getEditClients(int indexOf, Person newPerson);

        void setListClientsView(List<Person> clientsClone);

        List<Product> getProducts(String text);

        boolean isProductExist(String ciu, String barCode);

        List<Product> getNewProducts(Product newProduct);

        boolean isEditProduct(int index, Product newProduct);
    }
}
