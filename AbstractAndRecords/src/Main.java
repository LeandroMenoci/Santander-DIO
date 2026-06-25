import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        var arrayStart = OffsetDateTime.now();
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100_000_000; i++) {
            arrayList.add(i);
        }
        System.out.println(Duration.between(arrayStart, OffsetDateTime.now()).toMillis());

        var vectorStart = OffsetDateTime.now();
        List<Integer> vecotrList = new Vector<>();
        for (int i = 0; i < 100_000_000; i++) {
            vecotrList.add(i);
        }
        System.out.println(Duration.between(vectorStart, OffsetDateTime.now()).toMillis());

        var linkedStart = OffsetDateTime.now();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 100_000_000; i++) {
            linkedList.add(i);
        }
        System.out.println(Duration.between(linkedStart, OffsetDateTime.now()).toMillis());
    }
}
