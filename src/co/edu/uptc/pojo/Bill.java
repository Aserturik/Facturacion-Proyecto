package co.edu.uptc.pojo;

import java.time.LocalDate;
import java.util.List;

public class Bill {
    private Person client;
    private List<Buy> buys;
    private double total;
    private static final int IVA = 19;
    private static int idLast = 0;
    private int id;
    private LocalDate date;
    private List<Double> prices;
    private Double totalWhitIva;

    public Bill(Person client, List<Buy> buys) {
        id = ++idLast;
        this.client = client;
        this.buys = buys;
        this.total = 0;
        date = LocalDate.now();
    }

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double calculateTotal() {
        double total = 0;

        for (Buy buy : buys) {
            total += buy.calculateTotal();
        }
        return total;
    }

    public double calculateIva() {
        return calculateTotal() * IVA / 100;
    }

    public double calculateTotalWithIva() {
        return calculateTotal() + calculateIva();
    }
    public Bill clone(){
        Bill clone = new Bill(client,buys);
        clone.setTotal(total);
        clone.setId(id);
        return clone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Double getPrice(int index){
        return buys.get(index).calculateTotal();
    }

    public Double getTotalPrice(){
        double price = 0;
        for (int i = 0; i < buys.size(); i++) {
            price += getPrice(i);
        }
        return price;
    }

    public Double getIva(){
        return getTotalPrice() * IVA / 100;
    }

    public void setPrice(int index, Double price){
        prices.set(index, price);
    }

    public void priceWhitIva(){
        double price = 0;
        for (int i = 0; i < buys.size(); i++) {
            price += getPrice(i) * IVA / 100;
        }
        totalWhitIva = price;
    }

    public List<Buy> getBuys() {
        return buys;
    }

    public void setBuys(List<Buy> buys) {
        this.buys = buys;
    }

    public static int getIdLast() {
        return idLast;
    }

    public static void setIdLast(int idLast) {
        Bill.idLast = idLast;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Double> getPrices() {
        return prices;
    }

    public void setPrices(List<Double> prices) {
        this.prices = prices;
    }

    public Double getTotalWhitIva() {
        return totalWhitIva;
    }

    public void setTotalWhitIva(Double totalWhitIva) {
        this.totalWhitIva = totalWhitIva;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "client=" + client +
                ", buys=" + buys +
                ", total=" + total +
                ", id=" + id +
                ", date=" + date +
                '}';
    }
}
