package dp.behaviour.mediator;

/**
 * @author Arti.Jadhav
 */
public class User1 extends Participent {

    private String name;

    public User1(ApnaChat chat) {
        super(chat);
    }

    @Override
    public void sendMsg(String msg) {
        System.out.println("msg....");
        chat.showMsg(this, msg);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
