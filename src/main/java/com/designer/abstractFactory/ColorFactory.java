package com.designer.abstractFactory;

/**
 * @author Administrator 2019-02-18 10:07
 **/
public class ColorFactory extends ShapeFactory {
    @Override
    public Color getColor(String color) {
        if (color == null){
            return null;
        }
        if (color.equalsIgnoreCase("RED")){
            return new Red();
        }else if (color.equalsIgnoreCase("GREEN")){
            return new Green();
        }else if (color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shap) {
        return null;
    }
}
