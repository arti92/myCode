package dp.behaviour.command;

/**
 * @author Arti.Jadhav
 */
public abstract class Receiver {

    private String name;

    public Receiver(String name) {
        this.name = name;
    }

    public abstract void On();

    public abstract void Off();

}
