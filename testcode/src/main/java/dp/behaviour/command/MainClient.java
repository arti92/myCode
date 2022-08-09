package dp.behaviour.command;

import java.util.LinkedList;

/**
 * @author Arti.Jadhav
 */
public class MainClient {

    public static void main(String[] args) {

        Receiver receiver = new Light("flash light");
        //dircet call
        //hardcoding
        receiver.On();//as many operation these many command classes
        //so it will not tightly bound

        System.out.println("by command pattern");
        //by command dp
        Command command = new OnCommand(receiver); // will get reciver and perfom number of commands
        //can change reciver.on in on class without affecting clinet
        Invoker inv = new Invoker(command);
        inv.execute();
        //without invoker
        command.exceute();///there can be multiple steps bt in invoker there will only be one step to do all these steps

        //other way
        Invoker inv2 = new Invoker(new OffCommand(receiver));//to hide command hirarchy
        inv2.execute();
        //////////////////////////////////////////////

        LinkedList<Command> list = new LinkedList<>();
        list.add(command);


    }
}
