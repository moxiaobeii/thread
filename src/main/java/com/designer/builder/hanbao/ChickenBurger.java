package com.designer.builder.hanbao;

/**
 * @author Administrator 2019-02-15 17:12
 **/
public class ChickenBurger extends Burger{
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.f;
    }
}
