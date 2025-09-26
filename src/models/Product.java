package models;

public abstract class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { if(name != null && !name.isEmpty()) this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { if(price > 0) this.price = price; }

    public abstract String getDescription();
}
