package models;

public class Appliance extends Product {
    public Appliance(String name, double price) {
        super(name, price);
    }

    @Override
    public String getDescription() {
        return "Appliance: " + getName();
    }
}
