package cs.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataSubject implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Integer number) {
        for (Observer observer : observers) {
            observer.update(number);
        }
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public List<Observer> getObservers() {
        return this.observers;
    }
}
    
