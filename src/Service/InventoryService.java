package Service;


import models.Product;
import java.util.*;

public class InventoryService {
    private ArrayList<Product> inventory = new ArrayList<>();
    private HashMap<String, Integer> stock = new HashMap<>();
    private double totalSales = 0;

    // Add product
    public boolean addProduct(Product product, int quantity) {
        if (stock.containsKey(product.getName())) {
            return false;
        }
        inventory.add(product);
        stock.put(product.getName(), quantity);
        return true;
    }

    // List inventory
    public String listInventory() {
        if (inventory.isEmpty()) return "Inventory is empty.\n";
        StringBuilder sb = new StringBuilder("=== Inventory ===\n");
        for (Product p : inventory) {
            sb.append(p.getDescription())
                    .append(" | Price: $").append(p.getPrice())
                    .append(" | Stock: ").append(stock.getOrDefault(p.getName(), 0))
                    .append("\n");
        }
        return sb.toString();
    }

    // Buy product
    public String buyProduct(String name, int quantity) {
        if (!stock.containsKey(name)) return "Product not found.";
        if (quantity <= 0) return "Invalid quantity.";

        int available = stock.get(name);
        if (quantity > available) return "Insufficient stock. Available: " + available;

        Product selected = inventory.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst().orElse(null);

        if (selected != null) {
            double subtotal = selected.getPrice() * quantity;
            totalSales += subtotal;
            stock.put(name, available - quantity);
            return "Purchase successful!\nProduct: " + name +
                    "\nQuantity: " + quantity +
                    "\nSubtotal: $" + subtotal;
        }
        return "Unexpected error.";
    }

    // Statistics
    public String getStatistics() {
        if (inventory.isEmpty()) return "Inventory is empty.";
        Product mostExpensive = Collections.max(inventory, Comparator.comparing(Product::getPrice));
        Product cheapest = Collections.min(inventory, Comparator.comparing(Product::getPrice));
        return "Most expensive: " + mostExpensive.getName() + " ($" + mostExpensive.getPrice() + ")\n" +
                "Cheapest: " + cheapest.getName() + " ($" + cheapest.getPrice() + ")";
    }

    // Search
    public String search(String text) {
        StringBuilder sb = new StringBuilder("Search results:\n");
        boolean found = false;
        for (Product p : inventory) {
            if (p.getName().toLowerCase().contains(text.toLowerCase())) {
                sb.append(p.getDescription())
                        .append(" | Price: $").append(p.getPrice())
                        .append(" | Stock: ").append(stock.get(p.getName()))
                        .append("\n");
                found = true;
            }
        }
        return found ? sb.toString() : "No matches found.";
    }

    public double getTotalSales() {
        return totalSales;
    }
}
