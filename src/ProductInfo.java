import java.util.Objects;

public abstract class ProductInfo {

    private Brand brand;
    private int productId;
    private double price;
    private int quantityInStock;
    private String name;
    private String category;

    public ProductInfo(Brand brandName, int id, double price, int quantityInStock, String name, String category) {
        this.brand = brandName;
        this.productId = id;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.name = name;
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public int getId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public int getProductId() {
        return productId;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfo that = (ProductInfo) o;
        return productId == that.productId &&
                Double.compare(that.price, price) == 0 &&
                quantityInStock == that.quantityInStock &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(name, that.name) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, productId, price, quantityInStock, name, category);
    }
}