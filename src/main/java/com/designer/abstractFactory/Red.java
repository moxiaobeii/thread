package com.designer.abstractFactory;

/**
 * @author Administrator 2019-02-18 09:57
 **/
public class Red implements Color{

    @Override
    public void fill() {
        System.out.println("Inside Red :: fill() method.");
    }
}
