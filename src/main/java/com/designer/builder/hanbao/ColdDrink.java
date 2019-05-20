package com.designer.builder.hanbao;

/**
 * @author Administrator 2019-02-15 17:13
 **/
public abstract class ColdDrink implements Item{


    @Override
    public Packing packing() {
        return new BottlePacking();
    }

    @Override
    public abstract float price();
}
