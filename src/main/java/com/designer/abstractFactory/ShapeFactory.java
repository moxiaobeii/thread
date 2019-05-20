package com.designer.abstractFactory;

/**
 * @author Administrator 2019-02-18 09:59
 **/
public class ShapeFactory  extends AbstractFactory{

    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shap) {
        if (shap == null){
            return null;
        }
        if (shap.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if (shap.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if (shap.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

}
