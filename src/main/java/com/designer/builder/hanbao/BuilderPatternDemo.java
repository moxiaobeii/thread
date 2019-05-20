package com.designer.builder.hanbao;

/**
 * @author Administrator 2019-02-18 09:14
 **/
public class BuilderPatternDemo {

    public static void main(String[] args) {

        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost:" + vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNoVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost:" +nonVegMeal.getCost());
    }
}