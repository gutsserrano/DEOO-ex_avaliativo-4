package model.entities;

public class Product {

    private static Long SEQUENCE = 0L;

    private Long id;
    private String name;
    private int quantity;
    private double price;

    public Product() {
        this.id = ++SEQUENCE;
    }

    public Product(String name, int quantity, double price) {
        this();
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void incrementQuantity(int quantity){
        this.quantity += quantity;
    }

    public boolean decrementQuantity(int quantity){
        if(this.quantity - quantity >= 0){
            this.quantity -= quantity;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
