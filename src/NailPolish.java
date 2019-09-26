import java.util.Objects;

public class NailPolish extends ProductInfo {

    private int ml;
    enum EnColor {RED,PINK,ORANGE,BLUE,GREEN,BLACK,WHITE,METALLIC,GLITTER,YELLOW,PURPLE, CLEAR}
    EnColor color;
    Season season;
    private double discountedPrice;
    private boolean discounted;

    public NailPolish(Brand brandName, int id, double price, int quantityInStock, String name, String category,
                      int ml, EnColor color, Season season, double discountedPrice, boolean discounted) {
        super(brandName, id, price, quantityInStock, name, category);
        this.ml = ml;
        this.color = color;
        this.season = season;
        this.discountedPrice = discountedPrice;
        this.discounted = discounted;
    }

    public int getMl() {
        return ml;
    }

    public EnColor getColor() {
        return color;
    }

    public Season getSeason() {
        return season;
    }

    double getDiscountedPrice(){
        return discountedPrice;
    }

    public void setDiscountedPrice(double discountedPrice) {
        this.discounted = true;
        this.discountedPrice = discountedPrice;
    }

    boolean isDiscounted(){
        return discounted;
    }

    @Override
    public String toString() {  // TODO: 2019-09-14 Hur skriva ut produktinfo?
        return
                "\nNail Polish{" +
                        "\nbrand: " + getBrand() +
                        ", id: " + getId() +
                        ", price: " + getPrice() +
                        ", quantityInStock: " + getQuantityInStock() +
                        ", name: " + getName() +
                        ", ml: " + ml +
                        ", color: " + color +
                        '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NailPolish that = (NailPolish) o;
        return ml == that.ml &&
                color == that.color &&
                season == that.season;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ml, color, season);
    }
}