package il.co.sears.autoplayground;

public class Product {
    private long id;
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private String imageUrl;
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public Product(long id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        return imageUrl != null ? imageUrl.equals(product.imageUrl) : product.imageUrl == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }
}
