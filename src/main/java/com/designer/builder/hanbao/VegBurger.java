package com.designer.builder.hanbao;

/**
 * @author Administrator 2019-02-15 16:55
 **/
public class VegBurger  extends Burger{
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
