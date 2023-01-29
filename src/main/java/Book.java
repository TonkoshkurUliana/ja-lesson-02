public class Book {
    private String name;
    private String description;
    private double price;
    private String ISBN;
    private int category_id;
    private int id;

    public Book(String name, String description, double price, String ISBN, int category_id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.ISBN = ISBN;
        this.category_id = category_id;
    }

    public Book(int id, String name, String description, double price, String ISBN, int category_id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.ISBN = ISBN;
        this.category_id = category_id;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Book{" +  "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", ISBN='" + ISBN + '\'' +
                ", category_id=" + category_id +
                '}';
    }
}
