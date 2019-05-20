package com.designer.decorator;

/**
 * @author Administrator 2019-02-18 10:45
 **/
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("rectangle");
    }
}
