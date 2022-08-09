package dp.structure.decorator;

/**
 * @author Arti.Jadhav
 */
public class NonVegFood extends FoodDecorator {

    public NonVegFood(Food newFood) {
        super(newFood);
    }

    @Override
    public String prepareFood() {
        return super.prepareFood() + " nonveg";
    }

    @Override
    public double foodPrice() {
        return super.foodPrice() + 10;
    }
}
