package co.edu.uptc.pojo;

public class Buy {
    private Product product;
    private int quantity;

    public Buy(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Buy clone(){
        return new Buy(product, quantity);
    }

    public double getTotal(){
        return product.getPrice() * quantity;
    }

    public double calculateTotal(){
        return product.getPrice() * quantity;
    }
}
