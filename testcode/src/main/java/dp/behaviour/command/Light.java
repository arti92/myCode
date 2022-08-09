package dp.behaviour.command;

/**
 * @author Arti.Jadhav
 */
public class Light extends Receiver {

    //private String name;
    public Light(String name) {
        super(name);
    }

    @Override
    public void On() {
        System.out.println("light On");
    }

    @Override
    public void Off() {
        System.out.println("light off");
    }
}
