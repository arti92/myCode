package dp.behaviour.mediator;

/**
 * @author Arti.Jadhav
 */
public class MainClient {

    public static void main(String[] args) {

        //apna chat as a mediator betn users
        ApnaChat chat = new ApnaChatImpl();

        Participent p = new User1(chat);
        p.setName("abc");
        p.sendMsg("hi");
    }

    /*
    ApnaChatroom :- defines the interface for interacting with participants.
            ApnaChatroomImpl :- implements the operations defined by the Chatroom interface. The operations are
            managing the interactions between the objects: when one participant sends a message, the message is sent
            to the other participants.
            Participant :- defines an interface for the users involved in chatting.
            User1, User2, ...UserN :- implements Participant interface; the participant can be a number of users
            involved in chatting. But each Participant will keep only a reference to the ApnaChatRoom.
    */
}
