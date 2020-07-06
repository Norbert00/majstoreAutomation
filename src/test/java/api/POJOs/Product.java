package api.POJOs;

public class Product {

    private int id;
    private String name;
    private String slug;
    private String price;

    public Product(int id, String name, String slug, String price) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.price = price;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
