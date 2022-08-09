package dp.behaviour.command;

/**
 * @author Arti.Jadhav
 */
public class Bulp extends Receiver {
    public Bulp(String name) {
        super(name);
    }

    @Override
    public void On() {
        System.out.println("Bulp On");
    }

    @Override
    public void Off() {
        System.out.println("Bulp off");
    }
}
