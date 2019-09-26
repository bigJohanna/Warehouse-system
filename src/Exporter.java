import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;

class Exporter {

    public void exportFile(File filePath, Consumer<FileWriter> impl){
        try (FileWriter out = new FileWriter(filePath)){
            impl.accept(out);
        }catch (IOException e ){
            e.printStackTrace();
        }
    }
}
