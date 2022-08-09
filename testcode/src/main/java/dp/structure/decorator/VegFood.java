package dp.structure.decorator;

/**
 * @author Arti.Jadhav
 */
public class VegFood implements Food {
    @Override
    public String prepareFood() {
        return "veg";
    }

    @Override
    public double foodPrice() {
        return 5;
    }
}
