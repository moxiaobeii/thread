package com.designer.builder.hanbao;

/**
 * @author Administrator 2019-02-15 16:53
 **/
public abstract class Burger implements Item{

    @Override
    public abstract float price();

    @Override
    public Packing packing() {
        return new WrapperPacking();
    }
}
