package cs.lab;

import java.util.List;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(Integer number);
    List<Observer> getObservers();
}
