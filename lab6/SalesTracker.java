package lab6;

import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

public class SalesTracker {
    private LinkedList<Product> soldProducts;
    private Map<String, Integer> productCount;

    public SalesTracker() {
        soldProducts = new LinkedList<>();
        productCount = new HashMap<>();
    }

    public void addSoldProduct(Product product) {
        soldProducts.add(product);
        productCount.put(product.getName(), productCount.getOrDefault(product.getName(), 0) + 1);
    }

    public void printSoldProducts() {
        for (Product product : soldProducts) {
            System.out.println(product);
        }
    }

    public double calculateTotalSales() {
        double total = 0;
        for (Product product : soldProducts) {
            total += product.getPrice();
        }
        return total;
    }

    public String getMostPopularProduct() {
        String mostPopularProduct = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : productCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopularProduct = entry.getKey();
            }
        }
        return mostPopularProduct;
    }

    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();

        tracker.addSoldProduct(new Product("Apple", 1.0));
        tracker.addSoldProduct(new Product("Banana", 0.5));
        tracker.addSoldProduct(new Product("Apple", 1.0));
        tracker.addSoldProduct(new Product("Orange", 1.2));
        tracker.addSoldProduct(new Product("Banana", 0.5));
        tracker.addSoldProduct(new Product("Banana", 0.5));

        System.out.println("Sold Products:");
        tracker.printSoldProducts();

        System.out.println("Total Sales: $" + tracker.calculateTotalSales());

        System.out.println("Most Popular Product: " + tracker.getMostPopularProduct());
    }
}
