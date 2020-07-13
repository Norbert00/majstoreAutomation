package api.POJOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    private int id;
    private String name;
    private String slug;
    private String regularPrice;

    public Product(int id, String name, String slug, String regularPrice) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.regularPrice = regularPrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getPrice() {
        return regularPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", description='" + regularPrice + '\'' +
                '}';
    }
}
