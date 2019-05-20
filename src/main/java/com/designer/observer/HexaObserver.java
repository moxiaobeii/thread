package com.designer.observer;

/**
 * @author Administrator 2019-02-18 11:08
 **/
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(){
        System.out.println("Hex String : " + Integer.toOctalString(subject.getState()));
    }
}
