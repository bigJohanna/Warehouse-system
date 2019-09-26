import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
//import static Wrappers.wrap;

public class Files {

    String path = System.getProperty("user.home") +
            File.separator + "Documents" +
            File.separator + "CustomFolder";

    File nailPolishFilePath = new File(path + File.separator + "NailPolishProducts.csv");
    File nailSerumFilePath = new File(path + File.separator + "NailSerumProducts.csv");

    public void exportFiles(Map<String, List<ProductInfo>> categories) {

        File dir = new File(path);

        if (dir.exists())
            System.out.println("Folder found");
        else if (dir.mkdir())
            System.out.println("Folder created");
        else
            System.out.println("Folder not created");


        Exporter exporter = new Exporter();


        exporter.exportFile(nailPolishFilePath, Wrappers.wrap(out -> exportNailPolish(out, categories.get("Nail Polish"))));

        exporter.exportFile(nailSerumFilePath, Wrappers.wrap(out -> exportNailSerum(out, categories.get("Nail Care"))));
    }

    public static void exportNailPolish(FileWriter out, List<ProductInfo> list) throws IOException {
        for (ProductInfo p : list) {

            out.write(
                    p.getBrand().getBrandName() + "," +
                            p.getProductId() + "," +
                            p.getPrice() + "," +
                            p.getQuantityInStock() + "," +
                            p.getName() + "," +
                            p.getCategory() + "," +
                            ((NailPolish) p).getMl() + "," +
                            ((NailPolish) p).getColor().name() + "," +
                            ((NailPolish) p).getSeason().name() + "," +
                            ((NailPolish) p).getDiscountedPrice() + "," +
                            ((NailPolish) p).isDiscounted() + "," +
                            "\n");
            out.close();
        }
    }

    public static void exportNailSerum(FileWriter out, List<ProductInfo> list) throws IOException {

        for (ProductInfo p : list) {

            out.write(
                    p.getBrand().getBrandName() + "," +
                            p.getProductId() + "," +
                            p.getPrice() + "," +
                            p.getQuantityInStock() + "," +
                            p.getName() + "," +
                            p.getCategory() + "," +
                            ((NailSerum) p).getMl() + "," +
                            "\n");
        }

    }

    public void importFiles(Warehouse warehouse) {

        importNailPolishProducts(warehouse);
        importNailSerumProducts(warehouse);

    }

    void importNailPolishProducts(Warehouse warehouse) {

        List<NailPolish> npList = new ArrayList<>();

        if (nailPolishFilePath.exists()) {
            try (Scanner sc = new Scanner(nailPolishFilePath)) {

                while (sc.hasNext()) {
                    String line = sc.nextLine();

                    String[] fields = line.split(",");
                    NailPolish nailPolish = null;
                    try {
                        nailPolish = new NailPolish(
                                new Brand(fields[0]),
                                Integer.parseInt(fields[1]),
                                Double.parseDouble(fields[2]),
                                Integer.parseInt(fields[3]),
                                fields[4],
                                fields[5],
                                Integer.parseInt(fields[6]),
                                NailPolish.EnColor.valueOf(fields[7]),
                                Season.valueOf(fields[8]),
                                Double.parseDouble(fields[9]),
                                Boolean.parseBoolean(fields[10])
                        );

                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("File not read");
                    }
                    if (nailPolish != null)
                        npList.add(nailPolish);
                }

                for (ProductInfo p : npList) {
                    warehouse.addToWarehouse(p);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    void importNailSerumProducts(Warehouse warehouse) {

        List<NailSerum> nsList = new ArrayList<>();
        if (nailSerumFilePath.exists()) {
            try (Scanner sc = new Scanner(nailSerumFilePath)) {

                while (sc.hasNext()) {
                    String line = sc.nextLine();

                    String[] fields = line.split(",");
                    NailSerum nailSerum = null;
                    try {
                        nailSerum = new NailSerum(
                                new Brand(fields[0]),
                                Integer.parseInt(fields[1]),
                                Double.parseDouble(fields[2]),
                                Integer.parseInt(fields[3]),
                                fields[4],
                                fields[5],
                                Integer.parseInt(fields[6]),
                                fields[7]
                        );

                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("File not read");
                    }
                    if (nailSerum != null)
                        nsList.add(nailSerum);
                }
                for (ProductInfo p : nsList) {
                    warehouse.addToWarehouse(p);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
