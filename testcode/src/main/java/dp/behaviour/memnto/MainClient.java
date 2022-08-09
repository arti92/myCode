package dp.behaviour.memnto;

/**
 * @author Arti.Jadhav
 */
public class MainClient {
    public static void main(String[] args) {
        System.out.println("memento test.....");
// memento object that will capture the internal state of Originator.
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("1");
        //  caretaker.addMementoList(originator.saveToMem());
        caretaker.addMementoList(originator.saveToMem());

        originator.setState("2");
        caretaker.addMementoList(originator.saveToMem());
        originator.setState("3");
        caretaker.addMementoList(originator.saveToMem());

        System.out.println("current state:: " + originator.getState());
        System.out.println("other");
        for (Memento m : caretaker.getMementoList()) {
            System.out.println(m.getState());
            System.out.println("ori:: " + originator.getState(m));
        }
    }
    /*
   - Stores internal state of the originator object. The state can include any number of state variables.
   - The Memento must have two interfaces, an interface to the caretaker. This interface must not allow any operations or
any access to internal state stored by the memento and thus maintains the encapsulation.
The other interface is Originator and it allows the Originator to access any state variables necessary to the originator
 to restore the previous state.
     */
}
