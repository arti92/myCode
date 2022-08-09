package dp.behaviour.command;

/**
 * @author Arti.Jadhav
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void execute() {
        command.exceute();
    }
}
