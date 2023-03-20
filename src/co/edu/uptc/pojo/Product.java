package co.edu.uptc.pojo;

public class Product {
    private static int id;
    private String  ciu;
    private String barCode;
    private String description;
    private double price;
    private int quantity;

    public Product(String ciu, String barCode, String description, double price) {
        id++;
        this.ciu = ciu;
        this.barCode = barCode;
        this.description = description;
        this.price = price;
    }

    public Product() {
    }

    public Product clone(Product product){
        return new Product(ciu, barCode, description, price);
    }

    public String getCiu() {
        return ""+ciu;
    }

    public void setCiu(String ciu) {
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
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return price*quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "ciu=" + ciu + ", barCode=" + barCode + ", description=" + description + ", price=" + price + '}';
    }
}
