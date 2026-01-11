import java.util.ArrayList;
import java.util.Scanner;

public class ProductManagementApp {

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Use the 6-argument constructor to avoid confusion
        products.add(new Product(1, "Laptop", "BrandA", 8500, "High-end laptop", 10));
        products.add(new Product(2, "Phone", "BrandB", 4000, "Smartphone", 20));
        products.add(new Product(3, "Headphones", "BrandC", 600, "Wireless headphones", 15));

        displayProducts(products);

        // Delete a product by index (with validation)
        System.out.print("Index to delete: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < products.size()) {
            products.remove(index);
            System.out.println("Product deleted.");
        } else {
            System.out.println("Invalid index! No product deleted.");
        }

        displayProducts(products);

        // Modify a product by index (with validation)
        System.out.print("Index to modify: ");
        int mod = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (mod >= 0 && mod < products.size()) {
            System.out.print("New name: ");
            String name = scanner.nextLine();

            System.out.print("New price: ");
            double price = scanner.nextDouble();

            products.get(mod).setName(name);
            products.get(mod).setPrice(price);
            System.out.println("Product updated.");
        } else {
            System.out.println("Invalid index! No changes made.");
        }

        displayProducts(products);

        // Search for a product by name
        scanner.nextLine(); // consume newline
        System.out.print("Search name: ");
        String search = scanner.nextLine();

        boolean found = false;
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(search)) {
                System.out.println("Found: " + p);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found.");
        }

        scanner.close();
    }

    public static void displayProducts(ArrayList<Product> products) {
        System.out.println("\nProduct List:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + " -> " + products.get(i));
        }
    }
}
