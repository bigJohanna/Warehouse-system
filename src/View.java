import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class View {


    static void printList(List<?> list) {
        list.forEach(System.out::println);
    }

    static void whatToPutOnSale(List<ProductInfo> list) {
        System.out.println("Nail polish to put on sale:\n");
        for (ProductInfo p : list) {
           // if (p.getPrice() != ((NailPolish) p).getDiscountedPrice(p))
                System.out.println(p.getBrand() + ", " +p.getName() + ", product ID: " + p.getId()+ ", quantity in stock: " + p.getQuantityInStock() +
                        ", Ordinary price: " + p.getPrice() +
                        ", Sale price: " + (int)((NailPolish) p).season.discountAccordingToSeason((NailPolish) p));
        }
    }


    static void SearchOptions(){
        System.out.println("1. By Name \n 2. By Id");
    }


}