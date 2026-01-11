public class Product {

    private long id;
    private String name;
    private String brand;
    private double price;
    private String description;
    private int numberInStock;

    // Constructor for Lists part (simple)
    public Product(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = "";
        this.description = "";
        this.numberInStock = 0;
    }

    // Constructor for Generics / Metier part
    public Product(long id, String name, String brand,
                   double price, String description, int numberInStock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
        this.numberInStock = numberInStock;
    }

    // Getters and setters
    public long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getNumberInStock() { return numberInStock; }
    public void setNumberInStock(int numberInStock) { this.numberInStock = numberInStock; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + brand + " | " + price +
                " | " + description + " | stock: " + numberInStock;
    }
}
