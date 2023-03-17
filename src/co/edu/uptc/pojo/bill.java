package co.edu.uptc.pojo;

import java.util.List;

public class bill {
    private Person client;
    private List<Product> products;
    private double total;
    private static final int IVA = 19;

    public bill(Person client, List<Product> products, double total) {
        this.client = client;
        this.products = products;
        this.total = total;
    }

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public double calculateIva() {
        return calculateTotal() * IVA / 100;
    }

    public double calculateTotalWithIva() {
        return calculateTotal() + calculateIva();
    }

    @Override
    public String toString() {
        return "bill{" + "client=" + client + ", products=" + products + ", total=" + total + '}';
    }
}
