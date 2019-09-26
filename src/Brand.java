import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Brand {

    private String brandName;

    transient List<ProductInfo> products = new ArrayList<>(); // TODO: 2019-09-25 återskapa listan efter inläsning

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    @Override
    public String toString() {
        return brandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(brandName, brand.brandName) &&
                Objects.equals(products, brand.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandName, products);
    }
}

