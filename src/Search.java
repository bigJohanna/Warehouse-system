import java.util.List;
import java.util.Scanner;

public class Search {

    static void byName(List<ProductInfo> list, Scanner sc) {
      System.out.println("Write product name:");
      String searchedName = sc.nextLine();

        list.stream().filter(s -> s.getName().startsWith(searchedName))
                .forEach(System.out::println);
    }

    static void byId(List<ProductInfo> list, Scanner sc) {
       System.out.println("Insert ID number:");
       int searchedId = Integer.parseInt(sc.nextLine());

        list.stream().filter(s -> s.getId() == searchedId)
                .forEach(System.out::println);
    }

}