package co.edu.uptc.model;

public class Product {
    private int ciu;
    private String barCode;
    private String description;
    private double price;

    public Product(int ciu, String barCode, String description, double price) {
        this.ciu = ciu;
        this.barCode = barCode;
        this.description = description;
        this.price = price;
    }

    public Product() {
    }

    public int getCiu() {
        return ciu;
    }

    public void setCiu(int ciu) {
        this.ciu = ciu;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "ciu=" + ciu + ", barCode=" + barCode + ", description=" + description + ", price=" + price + '}';
    }
}
