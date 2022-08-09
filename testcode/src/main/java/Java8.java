import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Arti.Jadhav
 */
public class Java8 {
    public static void main(String[] args) {

        Java8.addValueinMap();
    }

    public static void addValueinMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Test1", 2);
        map.put("Test2", 4);
        map.put("Test3", 6);
        map.put("Test4", 1);

        List<String> inputKeys = new ArrayList();
        inputKeys.add("Test2");
        inputKeys.add("Test3");

        List<Integer> valList = map.entrySet().stream()
                .filter(m -> m.getKey().equalsIgnoreCase("Test2") || m.getKey().equalsIgnoreCase("Test3"))
                .map(m -> m.getValue()).collect(Collectors.toList());
        System.out.println(valList);

        List<Integer> valList2 = map.entrySet().stream()
                .filter(m -> inputKeys.stream().anyMatch(m.getKey()::equalsIgnoreCase))
                .map(m -> m.getValue()).collect(Collectors.toList());

        System.out.println(valList2);
    }
}
