package co.edu.uptc.model;

import co.edu.uptc.model.dinamic.UptcList;
import co.edu.uptc.pojo.Product;
import co.edu.uptc.presenter.Contract;

import java.util.List;

public class ListProducts {
    private List<Product> products;
    private List<Product> productsClone;
    private Contract.Model model;

    public ListProducts(Contract.Model model) {
        this.model = model;
        loadProducts();
        loadProductsClone();
    }

    private void loadProducts() {
        products = new UptcList<>();
        products.add(new Product("123", "#dflajlsdf933e", "Cerveza", 1000));
        products.add(new Product("12313", "#daue23lj34ahd", "Coca Cola personal", 2000));
        products.add(new Product("324423", "#dfaeu83ahd", "Cafe Colombiano", 3000));
        products.add(new Product("14234", "#797977ahd", "Cerveza Irlandeza", 4000));
        products.add(new Product("124234", "#dflajlsdf933e", "Cerveza Alemana", 5000));
        products.add(new Product("564322", "#0094dyf43a", "Cerveza Belga", 6000));
    }

    private void loadProductsClone() {
        productsClone = new UptcList<>();
        for (Product product : products) {
            productsClone.add(product.clone(product));
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getProductsClone() {
        return productsClone;
    }

    public List<Product> searchAllProducts(String text) {
        List<Product> products = new UptcList<>();
        for (Product product : productsClone) {
            if (product.getDescription().toLowerCase().contains(text)) {
                products.add(product);
            }
        }
        return products;
    }

    public boolean isSearch(String ciu, String barCode) {
        for (Product product : productsClone) {
            if (product.getCiu().equals(ciu) || product.getBarCode().equals(barCode)) {
                return true;
            }
        }
        return false;
    }

    public List<Product> getNewProducts(Product product) {
        products.add(product);
        productsClone.add(product.clone(product));
        return productsClone;
    }

    public boolean isEditProduct(int index, Product newProduct) {
        // TODO: 11/11/2019
        return false;
    }
}
