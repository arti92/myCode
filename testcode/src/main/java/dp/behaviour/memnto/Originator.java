package dp.behaviour.memnto;

/**
 * @author Arti.Jadhav
 */
public class Originator {


    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public Memento saveToMem() {
        return new Memento(state);
    }
    //instaed of ctor
    //bt need Memento to be return for saving in list
  /*  public void saveToMem(){
        new Memento().setState(state);
    }*/

    public String getState(Memento memento) {
        return memento.getState();
    }
}
