import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Arti.Jadhav
 */
public class Test {

    public static void main(String[] args) {
        //Employee emp = new Employee();
        // emp.setEmp();
        Format formatter = new SimpleDateFormat("dd-MMM-YYYY");
        String s = formatter.format(new Date());
        System.out.println(s);

        /*
        HashMap<String, String> map = new HashMap<>();
        map.put("arti", "Associate");
        map.put("kishor", "Softeware");
        map.put("iswar", "Consultent");

        System.out.println("map");

       // map.entrySet().stream().forEach(s -> System.out.println(s.getKey() + " :: " + s.getValue()));

        Set<String> dest = new HashSet<>();
        dest = map.values().stream().collect(Collectors.toSet());

        Iterator<String> itr = dest.iterator();

       while(itr.hasNext()){
           String next = itr.next();
           List<String> seList = map.entrySet().stream()
                   .filter(m -> next.equalsIgnoreCase(m.getValue()))
                   .map(key -> key.getKey())
                   .collect(Collectors.toList());
           System.out.println(next+" employess:: "+seList);
        }
*/

    }

}
