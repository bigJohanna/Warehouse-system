import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Files {

    void saveNailPolishListToCSV(List<ProductInfo> list) {

        String path = System.getProperty("user.home") +
                File.separator + "Documents" +
                File.separator + "CustomFolder";

        File dir = new File(path);

        if (dir.exists())
            System.out.println("Folder exists");
        else if (dir.mkdir())
            System.out.println("Folder created");
        else
            System.out.println("Folder not created");

        File filePath = new File(path + File.separator + "NailPolishProducts.csv");

        try {
            FileWriter out = new FileWriter(filePath, false);
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
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void saveNailSerumListToFileCSV(List<ProductInfo> list) {
        String path = System.getProperty("user.home") +
                File.separator + "Documents" +
                File.separator + "CustomFolder";

        File dir = new File(path);

        if (dir.exists())
            System.out.println("Folder exists");
        else if (dir.mkdir())
            System.out.println("Folder created");
        else
            System.out.println("Folder not created");

        File filePath = new File(path + File.separator + "NailSerumProducts.csv");

        try {
            FileWriter out = new FileWriter(filePath, false);
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
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void readFromCsv(Warehouse warehouse) {
        List<NailPolish> npList = new ArrayList<>();
        String path = System.getProperty("user.home") +
                File.separator + "Documents" +
                File.separator + "CustomFolder";

        File dir = new File(path);

        if (dir.exists())
            System.out.println("Folder exists");
        else if (dir.mkdir())
            System.out.println("Folder created");
        else
            System.out.println("Folder not created");

        File filePath = new File(path + File.separator + "NailPolishProducts.csv");

        if (filePath.exists()) {
            try {
                Scanner sc = new Scanner(filePath);
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

                sc.close();

                for (ProductInfo p : npList) {
                    warehouse.addToWarehouse(p);
                }


                System.out.println("NailPolishProducts.csv is read.");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
