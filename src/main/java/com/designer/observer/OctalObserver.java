package com.designer.observer;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @author Administrator 2019-02-18 11:08
 **/
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(){
        System.out.println("Octal String : " + Integer.toOctalString(subject.getState()));
    }
}
