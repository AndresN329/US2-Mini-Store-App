package ui;

import Service.InventoryService;
import models.Appliance;
import models.Food;
import models.Product;

import javax.swing.*;

public class Menu {
    private InventoryService service = new InventoryService();

    public void start() {
        String option;
        do {
            option = JOptionPane.showInputDialog(null,
                    "===== MINI STORE =====\n" +
                            "1. Add product\n" +
                            "2. List inventory\n" +
                            "3. Buy product\n" +
                            "4. Statistics\n" +
                            "5. Search product\n" +
                            "6. Exit\n");

            if (option == null) break;

            switch (option) {
                case "1" -> addProduct();
                case "2" -> JOptionPane.showMessageDialog(null, service.listInventory());
                case "3" -> buyProduct();
                case "4" -> JOptionPane.showMessageDialog(null, service.getStatistics());
                case "5" -> searchProduct();
                case "6" -> JOptionPane.showMessageDialog(null,
                        "Final total: $" + service.getTotalSales() + "\nThanks for shopping!");
                default -> JOptionPane.showMessageDialog(null, "Invalid option.");
            }
        } while (!"6".equals(option));
    }

    private void addProduct() {
        String type = JOptionPane.showInputDialog("Type:\n1. Food\n2. Appliance");
        String name = JOptionPane.showInputDialog("Name:");
        double price = Double.parseDouble(JOptionPane.showInputDialog("Price:"));
        int qty = Integer.parseInt(JOptionPane.showInputDialog("Stock:"));

        Product p = switch (type) {
            case "1" -> new Food(name, price);
            case "2" -> new Appliance(name, price);
            default -> null;
        };

        if (p != null && service.addProduct(p, qty)) {
            JOptionPane.showMessageDialog(null, "Product added.");
        } else {
            JOptionPane.showMessageDialog(null, "Error: product already exists.");
        }
    }

    private void buyProduct() {
        String name = JOptionPane.showInputDialog("Product name:");
        int qty = Integer.parseInt(JOptionPane.showInputDialog("Quantity:"));
        JOptionPane.showMessageDialog(null, service.buyProduct(name, qty));
    }

    private void searchProduct() {
        String text = JOptionPane.showInputDialog("Search text:");
        JOptionPane.showMessageDialog(null, service.search(text));
    }
}
