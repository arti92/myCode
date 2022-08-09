package dp.behaviour.command;

/**
 * @author Arti.Jadhav
 */
public class OnCommand implements Command {

    //has a realtionship
    private Receiver receiver;

    //ctor for creating instace of class by association
    public OnCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void exceute() {
        receiver.On();
    }
}
