package com.designer.observer;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Administrator 2019-02-18 11:00
 **/
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    private void notifyAllObservers() {
        for (Observer observer : observers){
            observer.update();
        }
    }
}
