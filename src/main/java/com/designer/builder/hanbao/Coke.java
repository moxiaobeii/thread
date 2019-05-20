package com.designer.builder.hanbao;

/**
 * @author Administrator 2019-02-18 08:57
 **/
public class Coke extends ColdDrink{


    @Override
    public String name() {
        return "coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
