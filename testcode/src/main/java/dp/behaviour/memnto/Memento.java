package dp.behaviour.memnto;

/**
 * @author Arti.Jadhav
 */
public class Memento {
    //a memento object that will capture the internal state of Originator.
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    //instaed of ctor
    /*public void setState(String state) {
        this.state = state;
    }*/
}
