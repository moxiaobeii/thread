package com.designer.factory;

/**
 * @author Administrator 2019-02-18 09:44
 **/
public class ShapeFactory {

    //使用getShape方法获取形状类型的对象
    public Shape getShape(String shapType){
        if (shapType == null){
            return null;
        }
        if (shapType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if (shapType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if (shapType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
