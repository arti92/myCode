package dp.behaviour.mediator;

/**
 * @author Arti.Jadhav
 */
public abstract class Participent {

    ApnaChat chat;

    public Participent(ApnaChat chat) {
        this.chat = chat;
    }

    public abstract void sendMsg(String msg);

    public abstract String getName();

    public abstract void setName(String name);

}
