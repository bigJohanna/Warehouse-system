import java.util.Objects;

public final class NailSerum extends ProductInfo {

    private int ml;
    private String info;


    public NailSerum(Brand brandName, int id, double price, int quantityInStock, String name, String category, int ml, String info) {
        super(brandName, id, price, quantityInStock, name, category);
        this.ml = ml;
        this.info = info;
    }

    public int getMl() {
        return ml;
    }

    public String getInfo() {return info;}

    @Override       // TODO: 2019-09-14 Hur skriva ut produktinfo?
    public String toString() {
        return "\nNailSerum{" +
                "\nbrand: " + getBrand() +
                ", id: " + getId() +
                ", price: " + getPrice() +
                ", quantityInStock: " + getQuantityInStock() +
                ", name: '" + getName() + '\'' +
                ", ml: " + ml +
                ", info " + info +
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