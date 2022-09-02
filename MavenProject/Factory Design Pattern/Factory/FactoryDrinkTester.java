package org.example.Factory;

public class FactoryDrinkTester {

    public static void main(String[] args) {

        // Test Drink Factory creating diff drinks from factory
        DrinkFactory drinkFactory = new DrinkFactory();

        String str1 = drinkFactory.createDrinks("Water").drink();
        String str2 =  drinkFactory.createDrinks("Soda").drink();
        String str3 =  drinkFactory.createDrinks("Juice").drink();

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

    }
}
