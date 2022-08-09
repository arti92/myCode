package dp.behaviour.memnto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Arti.Jadhav
 */
public class Caretaker {
    private List<Memento> mementoList = new ArrayList<>();

    public List<Memento> getMementoList() {
        return mementoList;
    }

    public void addMementoList(Memento memento) {
        mementoList.add(memento);
    }
}
