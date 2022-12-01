
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Arti.Jadhav
 */
public class MainGenTest {


    public static void main(String[] args) {
        System.out.println("main");
        ArrayList<String> a = new ArrayList<>();
        GenricTest gt = new GenricTest();
        gt.dispaly("1");
        gt.dispaly(1);
        System.out.println("Chile class"+ gt.dispaly("1"));
        System.out.println("Chile class"+ gt.dispaly(123));
        System.out.println("date:: "+new Date().getTime());

    }

}
