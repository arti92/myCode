package dp.structure.decorator;

/**
 * @author Arti.Jadhav
 */
public abstract class FoodDecorator implements Food {

    Food newFood;

    public FoodDecorator(Food newFood) {
        this.newFood = newFood;
    }

    @Override
    public String prepareFood() {
        return this.newFood.prepareFood();
    }

    @Override
    public double foodPrice() {
        return this.newFood.foodPrice();
    }
}
