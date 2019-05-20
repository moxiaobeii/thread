package com.designer.factory;

/**
 * @author Administrator 2019-02-18 09:33
 **/
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
