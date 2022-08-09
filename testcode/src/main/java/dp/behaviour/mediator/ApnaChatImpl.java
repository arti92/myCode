package dp.behaviour.mediator;

/**
 * @author Arti.Jadhav
 */
public class ApnaChatImpl implements ApnaChat {
    @Override
    public void showMsg(Participent p, String msg) {
        System.out.println("chat room msg from:: " + p.getName() + " ,as:: " + msg);

    }
}
