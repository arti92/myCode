package dp.structure.decorator;

/**
 * @author Arti.Jadhav
 */
public class MainClient {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException {
        System.out.println("Decorator pattern...");

        /**
         * alraedy have veg class , now want to decorate veg class with chinese n non veg
         * so we add abstract class fooddecorator
         */
        //dif way to create instaces
        Class c = Class.forName("dp.structure.decorator.VegFood");
        Food fa = (Food) c.newInstance();
        System.out.println("dyanmic: " + fa.prepareFood());

        Food f = new VegFood();
        System.out.println(f.prepareFood());
        System.out.println(f.foodPrice());

        /**
         * in abstarct class we give veg in ctor and call there respective methods
         * in non veg class we add extra price(10) with veg price (5) so combine these two and present
         */
        Food fn = new NonVegFood(new VegFood());
        System.out.println(fn.prepareFood());
        System.out.println(fn.foodPrice());

        /**
         * in this way we didnt touch veg class and we didint add extra veg nonveg..we simply combine both by adding decorator class
         */
    }

    /**
     * notes : 1)abstract class no need to overrird interface meth bt nonveg which extend abstract class need to add these meths
     * 2) if we add ctor in abstrct class then its child also need to add ctor
     */
}
