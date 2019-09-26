import java.util.List;
import java.util.function.Consumer;

public class Wrappers {

    public static <T>Consumer<T> wrap(CheckedConsumer <T> checkedConsumer  ){
        return t -> {
            try{
                checkedConsumer.apply(t);
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        };
    }

    public static int parser(String s) throws Exception { return Integer.parseInt(s);
    }

    public static int wrapString(String s) {
        try {
            return parser(s);
        } catch (Exception e) {
            System.out.println("hello");
        }
        return 0;
    }

    public static int wrapOption(List<?> list, int i){
        try{
            list.get(i);
        }catch(IndexOutOfBoundsException e){
            System.out.println("Invalid input");
        }
        return i;
    }

}
