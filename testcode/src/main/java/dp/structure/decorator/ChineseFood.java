package dp.structure.decorator;

/**
 * @author Arti.Jadhav
 */
public class ChineseFood extends FoodDecorator {
    public ChineseFood(Food newFood) {
        super(newFood);
    }

    @Override
    public String prepareFood() {
        return this.newFood.prepareFood() + " chinese";
    }

    @Override
    public double foodPrice() {
        return this.newFood.foodPrice() + 7;
    }
}
