package aufgaben.remotecontroll.receiver.util.observer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subject {
    public Set<Observer> observers = new HashSet<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        observers.forEach(Observer::update);
    }
}
