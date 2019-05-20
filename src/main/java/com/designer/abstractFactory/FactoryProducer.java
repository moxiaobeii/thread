package com.designer.abstractFactory;

/**
 * @author Administrator 2019-02-18 10:09
 **/
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice){
        if (choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        }else if (choice.equalsIgnoreCase("COLOr")){
            return new ColorFactory();
        }
        return null;
    }
}
