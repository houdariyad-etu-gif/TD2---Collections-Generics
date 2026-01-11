import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ----------------------------------
        // PART I: GenericStorage Test
        // ----------------------------------
        System.out.println("=== GENERIC STORAGE TEST ===");

        GenericStorage<Integer> ints = new GenericStorage<>();
        ints.addElement(10);
        ints.addElement(20);
        System.out.println("Integer element 0: " + ints.getElement(0));

        GenericStorage<String> strings = new GenericStorage<>();
        strings.addElement("Java");
        strings.addElement("OOP");
        System.out.println("String element 1: " + strings.getElement(1));

        GenericStorage<Double> doubles = new GenericStorage<>();
        doubles.addElement(14.5);
        doubles.addElement(19.0);
        doubles.addElement(15.0);
        doubles.addElement(10.0);
        System.out.println("Double size: " + doubles.getSize());

        // ----------------------------------
        // PART II: Product Management Menu
        // ----------------------------------
        System.out.println("\n=== PRODUCT MANAGEMENT MENU ===");

        IMetier<Product> productMetier = new MetierProduitImpl();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Display products");
            System.out.println("2. Search product by ID");
            System.out.println("3. Add new product");
            System.out.println("4. Delete product by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    List<Product> products = productMetier.getAll();
                    if (products.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        for (Product p : products) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter product ID to search: ");
                    long searchId = scanner.nextLong();
                    scanner.nextLine();
                    Product found = productMetier.findById(searchId);
                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    long id = scanner.nextLong();
                    scanner.nextLine();

                    // Check duplicate ID
                    boolean exists = false;
                    for (Product p : productMetier.getAll()) {
                        if (p.getId() == id) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("A product with this ID already exists! Cannot add.");
                    } else {
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter brand: ");
                        String brand = scanner.nextLine();

                        System.out.print("Enter price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Enter description: ");
                        String desc = scanner.nextLine();

                        System.out.print("Enter stock: ");
                        int stock = scanner.nextInt();
                        scanner.nextLine();

                        productMetier.add(new Product(id, name, brand, price, desc, stock));
                        System.out.println("Product added successfully!");
                    }
                    break;

                case 4:
                    System.out.print("Enter product ID to delete: ");
                    long deleteId = scanner.nextLong();
                    scanner.nextLine();
                    Product toDelete = productMetier.findById(deleteId);
                    if (toDelete != null) {
                        productMetier.delete(deleteId);
                        System.out.println("Product deleted.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
