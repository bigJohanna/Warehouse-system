import java.util.*;

public class Warehouse {
    static Scanner sc = new Scanner(System.in);

    private Map<String, List<ProductInfo>> categories = new HashMap<>();

    private List<ProductInfo> stock = new ArrayList<>();

    private List<ProductInfo> nailCareList = new ArrayList<>();
    private List<ProductInfo> nailpolishList = new ArrayList<>();
    private List<Brand> brands = new ArrayList<>();


    void startWarehouse(Warehouse warehouse) {

        Brand mac = new Brand("MAC");
        Brand opi = new Brand("OPI");
        Brand loreal = new Brand("LOREAL");

        new Files().importFiles(warehouse);

        brands.add(mac);
        brands.add(opi);
        brands.add(loreal);

        categories.put("Nail Care", nailCareList);
        categories.put("Nail Polish", nailpolishList);

        runMenu();
    }

    void addToWarehouse(ProductInfo product) {
        boolean exists = stock.stream().anyMatch(product::equals);
        if (!exists) {
            stock.add(product);
            product.getBrand().products.add(product);
        }

       addToCategories(product);
    }

    void addToCategories(ProductInfo product){

        boolean exists = nailpolishList.stream().anyMatch(product::equals);
        if (!exists && product.getCategory().equals("Nail Polish"))
            nailpolishList.add(product);

        exists = nailCareList.stream().anyMatch(product::equals);
        if (!exists && product.getCategory().equals("Nail Care"))
            nailCareList.add(product);

    }

    void runMenu() {
        Files files = new Files();

        List<MenuOption> menuList = new ArrayList<>();
        List<MenuOption> chooseCategory = new ArrayList<>();
        List<MenuOption> chooseBrand = new ArrayList<>();
        List<MenuOption> chooseSearchOptions = new ArrayList<>();


        MenuOption mo0 = new MenuOption();
        mo0.text = "All products";
        mo0.run = () -> View.printList(stock);
        menuList.add(mo0);

        MenuOption mo1 = new MenuOption();
        mo1.text = "View Categories";
        mo1.run = () -> View.printList(chooseCategory);
        menuList.add(mo1);

        MenuOption mo2 = new MenuOption();
        mo2.text = "View All Brands";
        mo2.run = () -> View.printList(brands);
        menuList.add(mo2);

        MenuOption mo3 = new MenuOption();
        mo3.text = "View products to put on sale";
        mo3.run = () -> View.whatToPutOnSale(nailpolishList);
        menuList.add(mo3);

        MenuOption mo4 = new MenuOption();
        mo4.text = "Search";
        mo4.run = () -> View.printList(chooseSearchOptions);
        menuList.add(mo4);

        MenuOption mo5 = new MenuOption();
        mo5.text = "Export and save products to text-file";
        mo5.run = () -> files.exportFiles(categories);
        menuList.add(mo5);

        MenuOption mo6 = new MenuOption();
        mo6.text = "Exit";
        mo6.run = () -> System.exit(0);
        menuList.add(mo6);



        MenuOption vc1 = new MenuOption();
        vc1.text = "1. Nail Care";
        vc1.run = () -> View.printList(nailCareList);
        chooseCategory.add(vc1);

        MenuOption vc2 = new MenuOption();
        vc2.text = "2.Nail Polish";
        vc2.run = () -> View.printList(nailpolishList);
        chooseCategory.add(vc2);


        MenuOption so1 = new MenuOption();
        so1.text = "1.Search by name";
        so1.run = () -> Search.byId(stock, sc);
        chooseSearchOptions.add(so1);

        MenuOption so2 = new MenuOption();
        so2.text = "2.Search by ID";
        so2.run = () -> Search.byName(stock, sc);
        chooseSearchOptions.add(so2);


        do {            // TODO: 2019-09-25 throw exception
            int i = 1;
            for (MenuOption x : menuList) {
                System.out.println("\n" + i + ". " + x);
                i++;
            }

            int input = Wrappers.wrapString(sc.nextLine());
            if (input > 0 && input < 8)
                menuList.get(input - 1).run.run();

            else
                System.out.println("Invalid option");

            if (input == 2) {            //todo metodanrop istället för if
                System.out.println("\nChoose category to see products");
                input = Wrappers.wrapString(sc.nextLine());
                chooseCategory.get(input - 1).run.run();

            } else if (input == 3) {
                System.out.println("\nChoose brand to see products, use numbers");
                int k = Wrappers.wrapString(sc.nextLine());
                if (k > 0 && k < (brands.size() - 1))
                    View.printList(brands.get(k - 1).products);

                    /*if(input == 4){
                        System.out.println("Register new sale price? 1.Yes 2.No");
                        //if(input == 1)
                            //registerDiscountedPrice();
                    }*/

            } else if (input == 5) {
                System.out.println("\nChoose search method");
                input = Wrappers.wrapString(sc.nextLine());
                if (input > 0 && input < 3) {
                    chooseSearchOptions.get(input - 1).run.run();
                } else
                    System.out.println("Invalid option");
            }

        } while (true);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(categories, warehouse.categories) &&
                Objects.equals(stock, warehouse.stock) &&
                Objects.equals(nailCareList, warehouse.nailCareList) &&
                Objects.equals(nailpolishList, warehouse.nailpolishList) &&
                Objects.equals(brands, warehouse.brands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categories, stock, nailCareList, nailpolishList, brands);
    }
}