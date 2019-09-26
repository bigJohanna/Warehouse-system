import java.util.Objects;

public final class NailSerum extends ProductInfo {

    private int ml;


    public NailSerum(Brand brandName, int id, double price, int quantityInStock, String name, String category, int ml) {
        super(brandName, id, price, quantityInStock, name, category);
        this.ml = ml;
    }

    public int getMl() {
        return ml;
    }

    @Override       // TODO: 2019-09-14 Hur skriva ut produktinfo?
    public String toString() {
        return "\nNailSerum{" +
                "\nbrand: " + getBrand() +
                ", id: " + getId() +
                ", price: " + getPrice() +
                ", quantityInStock: " + getQuantityInStock() +
                ", name: '" + getName() + '\'' +
                ", ml: " + ml +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NailSerum nailSerum = (NailSerum) o;
        return ml == nailSerum.ml;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ml);
    }
}