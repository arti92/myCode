/**
 * @author Arti.Jadhav
 */
interface GenTest{
     <T> T dispaly(T type);
}
public class GenricTest implements GenTest {
    @Override
    public <T> T dispaly(T type) {
        System.out.println("T"+type);
        return type;
    }
}
