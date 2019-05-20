package com.designer.decorator;

/**
 * @author Administrator 2019-02-18 10:50
 **/
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);

    }

    private void setRedBorder(Shape redBorder){
        System.out.println("Border Color:Red");
    }
}
