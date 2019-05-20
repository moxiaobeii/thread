package com.designer.decorator;

/**
 * @author Administrator 2019-02-18 10:46
 **/
public abstract class ShapeDecorator implements Shape{

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}
