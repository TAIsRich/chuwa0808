package org.example.Factory;

public class DrinkFactory {

    public static Drink createDrinks(String drink){
        if(drink == "Juice"){
            return new Juice();
        }
        if(drink == "Soda"){
            return new Soda();
        }
        if(drink == "Water"){
            return new Water();
        }
        return null;
    }
}
