package dp.behaviour.command;

/**
 * @author Arti.Jadhav
 */
public class OffCommand implements Command {

    private Receiver receiver;

    public OffCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exceute() {
        receiver.Off();
    }
}
