package com.designer.observer;

/**
 * @author Administrator 2019-02-18 11:07
 **/
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String : " + Integer.toBinaryString(subject.getState()));
    }
}
